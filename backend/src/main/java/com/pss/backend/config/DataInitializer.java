package com.pss.backend.config;

import java.util.List;
import org.springframework.stereotype.Component;
import com.pss.backend.domain.entity.Permisos;
import com.pss.backend.domain.entity.PermisosId;
import com.pss.backend.domain.entity.Roles;
import com.pss.backend.enums.Modulo;
import com.pss.backend.repository.IPermisoRepository;
import com.pss.backend.repository.IRolRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    
    private final IPermisoRepository permisoRepository;
    private final IRolRepository rolRepository;

    @PostConstruct
    public void init() {
        // Verificar si ya hay datos
        if(rolRepository.count() == 0) {
            loadRoles();
        }
        if (permisoRepository.count() == 0) {
            loadPermisos();
        }
    
    }
    
    private void loadRoles() {
        List<Roles> _roles = List.of(
            Roles.builder().rol("ADMIN").build(),
            Roles.builder().rol("PROVEEDOR").build(),
            Roles.builder().rol("CLIENTE").build()
        );
        
        rolRepository.saveAll(_roles);
    }
    
    private void loadPermisos() {
        Roles admin = rolRepository.findByRol("ADMIN").orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));
        Roles proveedor = rolRepository.findByRol("PROVEEDOR").orElseThrow(() -> new RuntimeException("Rol PROVEEDOR no encontrado"));
        Roles cliente = rolRepository.findByRol("CLIENTE").orElseThrow(() -> new RuntimeException("Rol CLIENTE no encontrado"));

        List<Permisos> _permisos = List.of(

            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_SERVICIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_SOLICITUDES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_INVENTARIO.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_PROVEEDORES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_CLIENTES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_CATEGORIAS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_PRECIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_REPORTES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.CONFIGURAR_SISTEMA.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_BITACORA.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.CREAR_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.ELIMINAR_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.EDITAR_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),


            // Proveedor - Gestiona sus servicios y solicitudes recibidas
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_SOLICITUDES.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_MIS_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.EDITAR_MIS_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.ELIMINAR_MIS_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.RESPONDER_SOLICITUDES.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_SOLICITUDES_RECIBIDAS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.ACTUALIZAR_ESTADO_SERVICIO.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_MIS_CALIFICACIONES.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.ACTUALIZAR_DISPONIBILIDAD.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_PEDIDOS_ASIGNADOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.GESTION_HORARIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),

            // Cliente - Solicita servicios y ve su historial
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.CREAR_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.EDITAR_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.CANCELAR_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_SERVICIOS_DISPONIBLES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.BUSCAR_PROVEEDORES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_HISTORIAL_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.CALIFICAR_SERVICIOS.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_DETALLES_SERVICIO.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.REALIZAR_PAGOS.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.VER_MIS_FACTURAS.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permisos.builder().idPermiso(PermisosId.builder().modulo(Modulo.EDITAR_MI_PERFIL.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build()
            
        );
        permisoRepository.saveAll(_permisos);
    }
}
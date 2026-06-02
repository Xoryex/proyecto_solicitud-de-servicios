package com.pss.backend.config;

import java.util.List;
import org.springframework.stereotype.Component;
import com.pss.backend.domain.entity.permisos;
import com.pss.backend.domain.entity.permisosId;
import com.pss.backend.domain.entity.roles;
import com.pss.backend.enums.modulo;
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
        List<roles> _roles = List.of(
            roles.builder().rol("ADMIN").build(),
            roles.builder().rol("PROVEEDOR").build(),
            roles.builder().rol("CLIENTE").build()
        );
        
        rolRepository.saveAll(_roles);
    }
    
    private void loadPermisos() {
        roles admin = rolRepository.findByRol("ADMIN").orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));
        roles proveedor = rolRepository.findByRol("PROVEEDOR").orElseThrow(() -> new RuntimeException("Rol PROVEEDOR no encontrado"));
        roles cliente = rolRepository.findByRol("CLIENTE").orElseThrow(() -> new RuntimeException("Rol CLIENTE no encontrado"));

        List<permisos> _permisos = List.of(

            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_USUARIOS.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_SERVICIOS.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_SOLICITUDES.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_INVENTARIO.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_PROVEEDORES.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_CLIENTES.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_CATEGORIAS.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_PRECIOS.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_REPORTES.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.CONFIGURAR_SISTEMA.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_BITACORA.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.CREAR_USUARIOS.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.ELIMINAR_USUARIOS.name()).idRol(admin.getId()).build()).rol(admin).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.EDITAR_USUARIOS.name()).idRol(admin.getId()).build()).rol(admin).build(),


            // Proveedor - Gestiona sus servicios y solicitudes recibidas
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_SERVICIOS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_SOLICITUDES.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_MIS_SERVICIOS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.EDITAR_MIS_SERVICIOS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.ELIMINAR_MIS_SERVICIOS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.RESPONDER_SOLICITUDES.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_SOLICITUDES_RECIBIDAS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.ACTUALIZAR_ESTADO_SERVICIO.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_MIS_CALIFICACIONES.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.ACTUALIZAR_DISPONIBILIDAD.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_PEDIDOS_ASIGNADOS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.GESTION_HORARIOS.name()).idRol(proveedor.getId()).build()).rol(proveedor).build(),

            // Cliente - Solicita servicios y ve su historial
            permisos.builder().id(permisosId.builder().modulo(modulo.CREAR_SOLICITUDES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_SOLICITUDES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.EDITAR_SOLICITUDES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.CANCELAR_SOLICITUDES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_SERVICIOS_DISPONIBLES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.BUSCAR_PROVEEDORES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_HISTORIAL_SOLICITUDES.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.CALIFICAR_SERVICIOS.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_DETALLES_SERVICIO.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.REALIZAR_PAGOS.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.VER_MIS_FACTURAS.name()).idRol(cliente.getId()).build()).rol(cliente).build(),
            permisos.builder().id(permisosId.builder().modulo(modulo.EDITAR_MI_PERFIL.name()).idRol(cliente.getId()).build()).rol(cliente).build()
            
        );
        permisoRepository.saveAll(_permisos);
    }
}
package com.pss.backend.config;

import java.util.List;
import org.springframework.stereotype.Component;
import com.pss.backend.domain.entity.Permiso;
import com.pss.backend.domain.entity.Cliente;
import com.pss.backend.domain.entity.IdPermiso;
import com.pss.backend.domain.entity.Rol;
import com.pss.backend.domain.entity.Usuario;
import com.pss.backend.enums.Modulo;
import com.pss.backend.repository.IClienteRepository;
import com.pss.backend.repository.IPermisoRepository;
import com.pss.backend.repository.IRolRepository;
import com.pss.backend.repository.IUsuarioRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    
    private final IPermisoRepository permisoRepository;
    private final IRolRepository rolRepository;
    private final IUsuarioRepository usuarioRepository;
    private final IClienteRepository clienteRepository;


    @PostConstruct
    public void init() {
        // Verificar si ya hay datos
        if(rolRepository.count() == 0) {
            loadRoles();
        }
        if (permisoRepository.count() == 0) {
            loadPermisos();
        }
        if (usuarioRepository.count() == 0) {
            loadUsuarios();
        }
        if(clienteRepository.count() == 0){
            loadClientes();
        }

    
    }

    
    private void loadRoles() {
        List<Rol> _roles = List.of(
            Rol.builder().rol("ADMIN").build(),
            Rol.builder().rol("PROVEEDOR").build(),
            Rol.builder().rol("CLIENTE").build()
        );
        
        rolRepository.saveAll(_roles);
    }
    
    private void loadPermisos() {
        Rol admin = rolRepository.findByRol("ADMIN").orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));
        Rol proveedor = rolRepository.findByRol("PROVEEDOR").orElseThrow(() -> new RuntimeException("Rol PROVEEDOR no encontrado"));
        Rol cliente = rolRepository.findByRol("CLIENTE").orElseThrow(() -> new RuntimeException("Rol CLIENTE no encontrado"));

        List<Permiso> _permisos = List.of(

            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_SERVICIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_SOLICITUDES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_INVENTARIO.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_PROVEEDORES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_CLIENTES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_CATEGORIAS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_PRECIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_REPORTES.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.CONFIGURAR_SISTEMA.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_BITACORA.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.CREAR_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.ELIMINAR_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.EDITAR_USUARIOS.name()).idRol(admin.getIdRol()).build()).rol(admin).build(),


            // Proveedor - Gestiona sus servicios y solicitudes recibidas
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_SOLICITUDES.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_MIS_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.EDITAR_MIS_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.ELIMINAR_MIS_SERVICIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.RESPONDER_SOLICITUDES.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_SOLICITUDES_RECIBIDAS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.ACTUALIZAR_ESTADO_SERVICIO.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_MIS_CALIFICACIONES.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.ACTUALIZAR_DISPONIBILIDAD.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_PEDIDOS_ASIGNADOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.GESTION_HORARIOS.name()).idRol(proveedor.getIdRol()).build()).rol(proveedor).build(),

            // Cliente - Solicita servicios y ve su historial
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.CREAR_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.EDITAR_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.CANCELAR_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_SERVICIOS_DISPONIBLES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.BUSCAR_PROVEEDORES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_HISTORIAL_SOLICITUDES.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.CALIFICAR_SERVICIOS.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_DETALLES_SERVICIO.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.REALIZAR_PAGOS.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.VER_MIS_FACTURAS.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build(),
            Permiso.builder().idPermiso(IdPermiso.builder().modulo(Modulo.EDITAR_MI_PERFIL.name()).idRol(cliente.getIdRol()).build()).rol(cliente).build()
            
        );
        permisoRepository.saveAll(_permisos);
    }

    private void loadUsuarios() {
        List<Usuario> _usuarios = List.of(
            Usuario.builder().usuario("admin").password("admin123").rol(rolRepository.findByRol("ADMIN").orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"))).build(),
            Usuario.builder().usuario("proveedor1").password("proveedor123").rol(rolRepository.findByRol("PROVEEDOR").orElseThrow(() -> new RuntimeException("Rol PROVEEDOR no encontrado"))).build(),
            Usuario.builder().usuario("cliente1").password("cliente123").rol(rolRepository.findByRol("CLIENTE").orElseThrow(() -> new RuntimeException("Rol CLIENTE no encontrado"))).build()
        ); 
        usuarioRepository.saveAll(_usuarios);       
    }

    private void loadClientes() {
        List<Cliente> clientes = List.of(
            Cliente.builder().documentoCliente("00000000").nombre("Cliente").apellido("Anonimo").usuario(usuarioRepository.getReferenceById(1)).build()
        );
        clienteRepository.saveAll(clientes);
    }
}
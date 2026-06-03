package com.pss.backend.domain.dto;

public record UsuarioDto(
    Integer idUsuario,
    String usuario,
    String contraseña,
    boolean estado
) {}
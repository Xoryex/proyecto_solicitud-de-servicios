package com.pss.backend.domain.dto;

public record usuarioDto(
    Integer id_usuario,
    String usuario,
    String contraseña,
    boolean estado
) {}
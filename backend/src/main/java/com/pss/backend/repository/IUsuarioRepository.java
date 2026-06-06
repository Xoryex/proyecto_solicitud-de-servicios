package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByUsuario(String usuario);

}

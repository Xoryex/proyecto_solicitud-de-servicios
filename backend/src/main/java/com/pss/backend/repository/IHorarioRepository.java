package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.horarios;
import com.pss.backend.domain.entity.horariosId;

public interface IHorarioRepository extends JpaRepository<horarios, horariosId> {

}

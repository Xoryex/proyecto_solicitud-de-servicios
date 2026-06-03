package com.pss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Horarios;
import com.pss.backend.domain.entity.HorariosId;

public interface IHorarioRepository extends JpaRepository<Horarios, HorariosId> {

}

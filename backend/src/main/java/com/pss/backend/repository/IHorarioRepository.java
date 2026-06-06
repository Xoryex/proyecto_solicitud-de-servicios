package com.pss.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pss.backend.domain.entity.Horario;
import com.pss.backend.domain.entity.IdHorario;

public interface IHorarioRepository extends JpaRepository<Horario, IdHorario> {

    List<Horario> findByIdHorario_DiaOrIdHorario_IdProveedor(String dia,Integer idProveedor);

}

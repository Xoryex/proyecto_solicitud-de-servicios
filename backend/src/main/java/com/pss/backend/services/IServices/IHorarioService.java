package com.pss.backend.services.IServices;

import java.util.List;
import com.pss.backend.domain.dto.horario.HorarioDto;
import com.pss.backend.domain.dto.horario.IdHorarioDto;

public interface IHorarioService extends ICRUDService<HorarioDto, HorarioDto, HorarioDto, IdHorarioDto> {
    List<HorarioDto> findByDiaOrIdProveedor(String dia,Integer idProveedor);
}

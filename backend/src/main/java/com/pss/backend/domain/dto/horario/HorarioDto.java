package com.pss.backend.domain.dto.horario;

import java.time.LocalTime;
import lombok.Builder;

@Builder
public record HorarioDto(
    IdHorarioDto idHorario,
    LocalTime inicioMañana,
    LocalTime finMañana,
    LocalTime inicioTarde,
    LocalTime finTarde,
    Boolean activo
) {}

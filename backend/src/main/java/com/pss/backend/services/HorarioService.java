package com.pss.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pss.backend.domain.dto.horario.HorarioDto;
import com.pss.backend.domain.dto.horario.IdHorarioDto;
import com.pss.backend.domain.dto.mapper.HorarioMapper;
import com.pss.backend.domain.dto.mapper.IdHorarioMapper;
import com.pss.backend.domain.entity.Horario;
import com.pss.backend.domain.entity.IdHorario;
import com.pss.backend.exceptions.ResourceDuplicate;
import com.pss.backend.exceptions.ResourceNotFound;
import com.pss.backend.repository.IHorarioRepository;
import com.pss.backend.services.IServices.IHorarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorarioService implements IHorarioService {

    private final IHorarioRepository repository;
    private final HorarioMapper mapper;
    private final IdHorarioMapper idMapper;

    @Override
    public HorarioDto save(HorarioDto dto) {
        IdHorario id = idMapper.toEntity(dto.idHorario());
        if (repository.existsById(id)) {
            throw new ResourceDuplicate("El horario ya existe");
        }
        Horario horario = mapper.toEntity(dto);
        horario.setIdHorario(id);
        return mapper.toDto(repository.save(horario));
    }

    @Override
    public HorarioDto findById(IdHorarioDto idDto) {
        IdHorario id = idMapper.toEntity(idDto);
        Horario horario = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Horario no encontrado"));
        return mapper.toDto(horario);
    }

    @Override
    public List<HorarioDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public HorarioDto update(HorarioDto dto) {
        IdHorario id = idMapper.toEntity(dto.idHorario());
        Horario horario = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Horario no encontrado"));
        mapper.updateEntity(dto, horario);
        return mapper.toDto(repository.save(horario));
    }

    @Override
    public void deleteById(IdHorarioDto idDto) {
        IdHorario id = idMapper.toEntity(idDto);
        if (!repository.existsById(id)) {
            throw new ResourceNotFound("Horario no encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public List<HorarioDto> findByDiaOrIdProveedor(String dia, Integer idProveedor) {
        return repository.findByIdHorario_DiaOrIdHorario_IdProveedor(dia, idProveedor).stream().map(mapper::toDto).toList();
    }
}

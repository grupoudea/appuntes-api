package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.mappers.ApunteMapper;
import com.Kplus1.appuntesapi.mappers.GrupoApunteMapper;
import com.Kplus1.appuntesapi.repositories.ApunteRepository;
import com.Kplus1.appuntesapi.repositories.GrupoApunteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ApunteService {

    private final ApunteRepository apunteRepository;
    private final GrupoApunteRepository grupoApunteRepository;
    private final ApunteMapper apunteMapper;
    private final GrupoApunteMapper grupoApunteMapper;

    public ApunteService(ApunteRepository apunteRepository, GrupoApunteRepository grupoApunteRepository, ApunteMapper apunteMapper, GrupoApunteMapper grupoApunteMapper) {
        this.apunteRepository = apunteRepository;
        this.grupoApunteRepository = grupoApunteRepository;
        this.apunteMapper = apunteMapper;
        this.grupoApunteMapper = grupoApunteMapper;
    }

    public List<GrupoApunteDto> buscarGruposApuntesPorFiltro(String busqueda, Integer idMateria, Integer idEstudiante) {
        if (Objects.isNull(busqueda)) {
            busqueda = "";
        }
        return grupoApunteMapper.toDto(grupoApunteRepository.filtrarGruposApunte(busqueda, idMateria, idEstudiante));
    }
}

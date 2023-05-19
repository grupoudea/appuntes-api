package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.GrupoApunte;
import com.Kplus1.appuntesapi.mappers.GrupoApunteMapper;
import com.Kplus1.appuntesapi.repositories.GrupoApunteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class GrupoApunteService {

    private final GrupoApunteRepository grupoApunteRepository;
    private final GrupoApunteMapper grupoApunteMapper;

    public GrupoApunteService(GrupoApunteRepository grupoApunteRepository, GrupoApunteMapper grupoApunteMapper) {
        this.grupoApunteRepository = grupoApunteRepository;
        this.grupoApunteMapper = grupoApunteMapper;
    }

    public List<GrupoApunteDto> buscarGruposApuntesPorFiltro(String busqueda, Integer idMateria, Integer idEstudiante) {
        if (Objects.isNull(busqueda)) {
            busqueda = "";
        }
        return grupoApunteMapper.toDto(grupoApunteRepository.filtrarGruposApunte(busqueda, idMateria, idEstudiante));
    }

    public GrupoApunte crearGrupoApunte(GrupoApunteDto grupoApunteDto) {
        GrupoApunte grupoApunte = grupoApunteMapper.toEntity(grupoApunteDto);
        return grupoApunteRepository.save(grupoApunte);
    }

    public void eliminarGrupoApunte(Integer idGrupoApunte) {
        GrupoApunte grupoApunte = grupoApunteRepository.findById(idGrupoApunte).orElse(null);
        if (grupoApunte != null) {
            grupoApunteRepository.delete(grupoApunte);
        }
    }
}


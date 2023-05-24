package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.ApunteDto;
import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.Apunte;
import com.Kplus1.appuntesapi.mappers.ApunteMapper;
import com.Kplus1.appuntesapi.mappers.GrupoApunteMapper;
import com.Kplus1.appuntesapi.repositories.ApunteRepository;
import com.Kplus1.appuntesapi.repositories.GrupoApunteRepository;
import org.hibernate.ObjectNotFoundException;
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

    public List<ApunteDto> buscarApuntesPorFiltro(String busqueda, Integer idGrupoApunte) {
        if (Objects.isNull(busqueda)) {
            busqueda = "";
        }
        return apunteMapper.toDto(apunteRepository.filtrarApuntes(busqueda, idGrupoApunte));
    }

    public Apunte buscarApunte(Integer idApunte) {
        if (Objects.isNull(idApunte)) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        return apunteRepository.findById(idApunte).orElse(null);
    }

    public void eliminarApunte(Integer idApunte) {
        Apunte apunte = buscarApunte(idApunte);
        apunteRepository.delete(apunte);
    }
}

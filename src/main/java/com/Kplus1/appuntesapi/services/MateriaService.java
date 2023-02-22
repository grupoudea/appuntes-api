package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.MateriaDto;
import com.Kplus1.appuntesapi.entities.Materia;
import com.Kplus1.appuntesapi.mappers.MateriaMapper;
import com.Kplus1.appuntesapi.repositories.MateriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final MateriaMapper materiaMapper;

    public MateriaService(MateriaRepository materiaRepository, MateriaMapper materiaMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }

    public MateriaDto crearMateria(MateriaDto materia) {
        if (Objects.isNull(materia) || Objects.isNull(materia.getIdMateriaFk()) || Objects.isNull(materia.getIdEstudianteFk())) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        return materiaMapper.toDto(materiaRepository.save(materiaMapper.toEntity(materia)));
    }

    public MateriaDto editarMateria(MateriaDto materiaDto) {
        if (Objects.isNull(materiaDto) || Objects.isNull(materiaDto.getId())) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        Materia materia = buscarMateria(materiaDto.getId());
        materia.setIdMateriaFk(materiaDto.getIdMateriaFk());
        materia.setIdEstudianteFk(materiaDto.getIdEstudianteFk());
        materia.setCreditos(materiaDto.getCreditos());
        materia.setProfesor(materiaDto.getProfesor());
        return materiaMapper.toDto(materiaRepository.save(materia));
    }

    public Materia buscarMateria(Integer materiaId) {
        if (Objects.isNull(materiaId)) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        return materiaRepository.findById(materiaId).orElse(null);
    }

    public List<MateriaDto> buscarMateriasPorFiltro(String busqueda, Integer idEstudiante) {
        return materiaMapper.toDto(materiaRepository.filtrarMaterias(busqueda, idEstudiante));
    }
}

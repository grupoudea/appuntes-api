package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.MateriaDto;
import com.Kplus1.appuntesapi.dtos.MateriaUniversidadDto;
import com.Kplus1.appuntesapi.entities.Materia;
import com.Kplus1.appuntesapi.entities.MateriaUniversidad;
import com.Kplus1.appuntesapi.mappers.MateriaMapper;
import com.Kplus1.appuntesapi.mappers.MateriaUniversidadMapper;
import com.Kplus1.appuntesapi.repositories.MateriaRepository;
import com.Kplus1.appuntesapi.repositories.MateriaUniversidadRepository;
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
    private final MateriaUniversidadRepository materiaUniversidadRepository;
    private final MateriaUniversidadMapper materiaUniversidadMapper;

    public MateriaService(MateriaRepository materiaRepository, MateriaMapper materiaMapper, MateriaUniversidadRepository materiaUniversidadRepository, MateriaUniversidadMapper materiaUniversidadMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
        this.materiaUniversidadRepository = materiaUniversidadRepository;
        this.materiaUniversidadMapper = materiaUniversidadMapper;
    }

    public MateriaDto crearMateria(MateriaDto materia) {
        if (Objects.isNull(materia) || Objects.isNull(materia.getIdMateriaFk()) || Objects.isNull(materia.getIdEstudianteFk())) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        if (materiaRepository.findByIdMateriaFkAndIdEstudianteFk(materia.getIdMateriaFk(), materia.getIdEstudianteFk()).size() > 0) {
            throw new ObjectNotFoundException(null, "La materia ya existe");
        }
        var materiaEntity = materiaRepository.save(materiaMapper.toEntity(materia));
        var materiaUniversidad =  materiaUniversidadRepository.findById(materiaEntity.getIdMateriaFk()).orElse(new MateriaUniversidad());
        materiaEntity.setMateriaUniversidad(materiaUniversidad);

        return materiaMapper.toDto(materiaEntity);
    }

    public MateriaDto editarMateria(MateriaDto materiaDto) {
        if (Objects.isNull(materiaDto) || Objects.isNull(materiaDto.getId())) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        List<Materia> materiasActuales = materiaRepository
                .findByIdMateriaFkAndIdEstudianteFk(materiaDto.getIdMateriaFk(), materiaDto.getIdEstudianteFk());
        boolean isThis = materiasActuales.stream().anyMatch(m -> m.getId().equals(materiaDto.getId()));
        if (materiasActuales.size() > 0 && !isThis) {
            throw new ObjectNotFoundException(null, "La materia ya existe");
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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (Objects.isNull(busqueda)) {
            busqueda = "";
        }
        return materiaMapper.toDto(materiaRepository.filtrarMaterias(busqueda, idEstudiante));
    }

    public List<MateriaDto> obtenerMateriasPorIdEstudiante(Integer idEstudiante) {
        return materiaMapper.toDto(materiaRepository.findMateriaByIdEstudianteFk(idEstudiante));
    }

    public List<MateriaUniversidadDto> buscarMateriasUniversidad(String materia) {
        return materiaUniversidadMapper.toDto(materiaUniversidadRepository.findAllByMateriaContains(materia));
    }

    public void eliminarMateria(Integer idMateria) {
        Materia materia = buscarMateria(idMateria);
        materiaRepository.delete(materia);
    }


}

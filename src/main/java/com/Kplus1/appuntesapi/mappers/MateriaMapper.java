package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.MateriaDto;
import com.Kplus1.appuntesapi.entities.Materia;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {MateriaUniversidadMapper.class, EstudianteMapper.class})
public interface MateriaMapper extends EntityMapper<MateriaDto, Materia> {
}

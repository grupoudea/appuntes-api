package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.EstudianteTagDto;
import com.Kplus1.appuntesapi.entities.EstudianteTag;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {EstudianteMapper.class, TagMapper.class})
public interface EstudianteTagMapper extends EntityMapper<EstudianteTagDto, EstudianteTag> {
}

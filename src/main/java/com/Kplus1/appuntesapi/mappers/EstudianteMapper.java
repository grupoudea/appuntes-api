package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.EstudianteDto;
import com.Kplus1.appuntesapi.entities.Estudiante;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EstudianteMapper extends EntityMapper<EstudianteDto, Estudiante> {
}

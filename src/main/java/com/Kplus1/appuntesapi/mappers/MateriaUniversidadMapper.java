package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.MateriaUniversidadDto;
import com.Kplus1.appuntesapi.entities.MateriaUniversidad;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MateriaUniversidadMapper extends EntityMapper<MateriaUniversidadDto, MateriaUniversidad> {
}

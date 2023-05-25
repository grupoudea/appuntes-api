package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.GrupoApunte;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {MateriaMapper.class})
public interface GrupoApunteMapper extends EntityMapper<GrupoApunteDto, GrupoApunte> {
}

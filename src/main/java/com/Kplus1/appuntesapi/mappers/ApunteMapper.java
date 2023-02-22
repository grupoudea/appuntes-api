package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.ApunteDto;
import com.Kplus1.appuntesapi.entities.Apunte;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {GrupoApunteMapper.class})
public interface ApunteMapper extends EntityMapper<ApunteDto, Apunte> {
}

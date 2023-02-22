package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.ApunteTagDto;
import com.Kplus1.appuntesapi.entities.ApunteTag;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {ApunteMapper.class, TagMapper.class})
public interface ApunteTagMapper extends EntityMapper<ApunteTagDto, ApunteTag> {
}

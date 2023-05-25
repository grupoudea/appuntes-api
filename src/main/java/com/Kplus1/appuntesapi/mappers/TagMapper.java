package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.TagDto;
import com.Kplus1.appuntesapi.entities.Tag;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TagMapper extends EntityMapper<TagDto, Tag> {
}

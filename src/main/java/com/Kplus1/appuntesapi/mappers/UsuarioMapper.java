package com.Kplus1.appuntesapi.mappers;

import com.Kplus1.appuntesapi.dtos.UsuarioDto;
import com.Kplus1.appuntesapi.entities.Usuario;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {EstudianteMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {
}

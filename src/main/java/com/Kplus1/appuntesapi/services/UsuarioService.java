package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.UsuarioDto;
import com.Kplus1.appuntesapi.exception.DataNotFoundException;
import com.Kplus1.appuntesapi.mappers.UsuarioMapper;
import com.Kplus1.appuntesapi.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
@Data
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioDto buscarUsuarioPorUsuarioContrasena(UsuarioDto usuarioDto){
        if (Objects.isNull(usuarioDto.getNombreUsuario()) ||  Objects.isNull(usuarioDto.getPassword())) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }

        var usuario = usuarioRepository
                .findUsuarioByNombreUsuarioAndPassword(usuarioDto.getNombreUsuario(), usuarioDto.getPassword())
                .orElseThrow(() -> new DataNotFoundException("No se encuentra el usuario"));

        return usuarioMapper.toDto(usuario);
    }


}

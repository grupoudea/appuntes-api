package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.UsuarioDto;
import com.Kplus1.appuntesapi.services.UsuarioService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<StandardResponse<UsuarioDto>> iniciarSesion(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(new StandardResponse<>(usuarioService.buscarUsuarioPorUsuarioContrasena(usuarioDto)));
    }
}

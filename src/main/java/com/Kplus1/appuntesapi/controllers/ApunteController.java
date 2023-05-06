package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.services.ApunteService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apuntes")
public class ApunteController {

    private final ApunteService apunteService;

    public ApunteController(ApunteService apunteService) {
        this.apunteService = apunteService;
    }

    @GetMapping("/filtro-grupos-apuntes")
    public ResponseEntity<StandardResponse<List<GrupoApunteDto>>> buscarGruposApuntesPorFiltro(@RequestParam(value = "busqueda", required = false) String busqueda,
                                                                                               @RequestParam("idMateria") Integer idMateria,
                                                                                               @RequestParam("idEstudiante") Integer idEstudiante) {
        return ResponseEntity.ok(new StandardResponse<>(apunteService.buscarGruposApuntesPorFiltro(busqueda, idMateria, idEstudiante)));
    }
}

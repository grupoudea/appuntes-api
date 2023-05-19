package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.GrupoApunte;
import com.Kplus1.appuntesapi.services.GrupoApunteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos-apuntes")
public class GrupoApunteController {

    private final GrupoApunteService grupoApunteService;

    public GrupoApunteController(GrupoApunteService grupoApunteService) {
        this.grupoApunteService = grupoApunteService;
    }

    @GetMapping
    public ResponseEntity<List<GrupoApunteDto>> buscarGruposApuntes(
            @RequestParam(required = false) String busqueda,
            @RequestParam(required = false) Integer idMateria,
            @RequestParam(required = false) Integer idEstudiante
    ) {
        List<GrupoApunteDto> gruposApuntes = grupoApunteService.buscarGruposApuntesPorFiltro(busqueda, idMateria, idEstudiante);
        return ResponseEntity.ok(gruposApuntes);
    }

    @PostMapping
    public ResponseEntity<GrupoApunte> crearGrupoApunte(@RequestBody GrupoApunteDto grupoApunteDto) {
        GrupoApunte grupoApunte = grupoApunteService.crearGrupoApunte(grupoApunteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoApunte);
    }

    @DeleteMapping("/{idGrupoApunte}")
    public ResponseEntity<Void> eliminarGrupoApunte(@PathVariable Integer idGrupoApunte) {
        grupoApunteService.eliminarGrupoApunte(idGrupoApunte);
        return ResponseEntity.noContent().build();
    }
}


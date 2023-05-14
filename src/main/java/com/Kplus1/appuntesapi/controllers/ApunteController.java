package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.services.ApunteService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/eliminar-apunte/{idApunte}")
    public ResponseEntity<StandardResponse<Void>> elminarApunte(@PathVariable("idApunte") Integer idApunte) {
        apunteService.eliminarApunte(idApunte);
        return ResponseEntity.ok(new StandardResponse<>());
    }
}

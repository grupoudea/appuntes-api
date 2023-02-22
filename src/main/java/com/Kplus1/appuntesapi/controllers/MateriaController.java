package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.MateriaDto;
import com.Kplus1.appuntesapi.services.MateriaService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping("/guardar-materia")
    public ResponseEntity<StandardResponse<MateriaDto>> crearMateria(@RequestBody MateriaDto materia) {
        return ResponseEntity.ok(new StandardResponse<>(materiaService.crearMateria(materia)));
    }

    @PutMapping("/editar-materia")
    public ResponseEntity<StandardResponse<MateriaDto>> editarMateria(@RequestBody MateriaDto materia) {
        return ResponseEntity.ok(new StandardResponse<>(materiaService.editarMateria(materia)));
    }

    @GetMapping("/filtro-materias")
    public ResponseEntity<StandardResponse<List<MateriaDto>>> buscarMateriasPorFiltro(@RequestParam("busqueda") String busqueda,
                                                                                      @RequestParam("idEstudiante") Integer idEstudiante) {
        return ResponseEntity.ok(new StandardResponse<>(materiaService.buscarMateriasPorFiltro(busqueda, idEstudiante)));
    }
}

package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.MateriaDto;
import com.Kplus1.appuntesapi.services.MateriaService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping("/guardar-materia")
    public ResponseEntity<StandardResponse<MateriaDto>> saveGrades(@RequestBody MateriaDto materia) {
        return ResponseEntity.ok(new StandardResponse<>(materiaService.crearMateria(materia)));
    }
}

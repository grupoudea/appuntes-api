package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.ApunteDto;
import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.Apunte;
import com.Kplus1.appuntesapi.entities.GrupoApunte;
import com.Kplus1.appuntesapi.services.ApunteService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.Kplus1.appuntesapi.services.ApunteService.guardarArchivo;

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

    @PostMapping("/crear-grupos-apuntes")
    public ResponseEntity<StandardResponse<GrupoApunte>> crearGruposApuntes(@RequestBody GrupoApunteDto grupoApunteDto) {
        return ResponseEntity.ok(new StandardResponse<>(apunteService.crearGrupoApunte(grupoApunteDto)));
    }

    @DeleteMapping("/eliminar-grupos-apuntes/{idGrupoApuntes}")
    public ResponseEntity<StandardResponse> eliminarGruposApuntes(@PathVariable("idGrupoApuntes") int idGrupoApuntes) {
        apunteService.eliminarGrupoApunte(idGrupoApuntes);
        return ResponseEntity.ok(new StandardResponse());
    }

    @PostMapping("/texto")
    public ResponseEntity<StandardResponse<Apunte>> guardarApunteTexto(@RequestBody ApunteDto apunteDto) {
        return ResponseEntity.ok(new StandardResponse<>(apunteService.guardarApunteTexto(apunteDto)));
    }

    @PostMapping("/audio")
    public ResponseEntity<StandardResponse<Apunte>> guardarApunteAudio(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String rutaArchivo = guardarArchivo(archivo);
            return ResponseEntity.ok(new StandardResponse<>(apunteService.guardarApunteAudio(rutaArchivo)));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/foto")
    public ResponseEntity<StandardResponse<Apunte>> guardarApunteFoto(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String rutaArchivo = guardarArchivo(archivo);
            return ResponseEntity.ok(new StandardResponse<>(apunteService.guardarApunteFoto(rutaArchivo)));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

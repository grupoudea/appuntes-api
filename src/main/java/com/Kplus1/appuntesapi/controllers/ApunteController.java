package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.Apunte;
import com.Kplus1.appuntesapi.entities.GrupoApunte;
import com.Kplus1.appuntesapi.services.ApunteService;
import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("/crear-grupos-apuntes")
    public ResponseEntity<GrupoApunte> crearGruposApuntes(@RequestBody GrupoApunteDto grupoApunteDto) {
        GrupoApunte grupoApunte = apunteService.crearGrupoApunte(grupoApunteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoApunte);
    }

    @DeleteMapping("/eliminar-grupos-apuntes/{idGrupoApuntes}")
    public ResponseEntity<StandardResponse> eliminarGruposApuntes(@PathVariable("idGrupoApuntes") String idGrupoApuntes) {

        return ResponseEntity.ok(new StandardResponse());
    }

    @PostMapping("/texto")
    public ResponseEntity<Apunte> guardarApunteTexto(@RequestBody String texto) {
        Apunte apunte = apunteService.guardarApunteTexto(texto);
        return new ResponseEntity<>(apunte, HttpStatus.CREATED);
    }

    @PostMapping("/audio")
    public ResponseEntity<Apunte> guardarApunteAudio(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String rutaArchivo = guardarArchivo(archivo);
            Apunte apunte = apunteService.guardarApunteAudio(rutaArchivo);
            return new ResponseEntity<>(apunte, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/foto")
    public ResponseEntity<Apunte> guardarApunteFoto(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String rutaArchivo = guardarArchivo(archivo);
            Apunte apunte = apunteService.guardarApunteFoto(rutaArchivo);
            return new ResponseEntity<>(apunte, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String guardarArchivo(MultipartFile archivo) throws IOException {
        // Directorio donde se almacenarán los archivos
        String directorio = "ruta_del_directorio";

        // Generar un nombre de archivo único
        String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();

        // Ruta completa del archivo a guardar
        String rutaArchivo = directorio + File.separator + nombreArchivo;

        // Guardar el archivo en el sistema de archivos
        archivo.transferTo(new File(rutaArchivo));

        return rutaArchivo;
    }

}

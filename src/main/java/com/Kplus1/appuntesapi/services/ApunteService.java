package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.dtos.ApunteDto;
import com.Kplus1.appuntesapi.dtos.GrupoApunteDto;
import com.Kplus1.appuntesapi.entities.Apunte;
import com.Kplus1.appuntesapi.entities.GrupoApunte;
import com.Kplus1.appuntesapi.mappers.ApunteMapper;
import com.Kplus1.appuntesapi.mappers.GrupoApunteMapper;
import com.Kplus1.appuntesapi.repositories.ApunteRepository;
import com.Kplus1.appuntesapi.repositories.GrupoApunteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.Kplus1.appuntesapi.utils.Constantes.*;

@Service
@Transactional
public class ApunteService {

    private final ApunteRepository apunteRepository;
    private final GrupoApunteRepository grupoApunteRepository;
    private final ApunteMapper apunteMapper;
    private final GrupoApunteMapper grupoApunteMapper;

    public ApunteService(ApunteRepository apunteRepository, GrupoApunteRepository grupoApunteRepository, ApunteMapper apunteMapper, GrupoApunteMapper grupoApunteMapper) {
        this.apunteRepository = apunteRepository;
        this.grupoApunteRepository = grupoApunteRepository;
        this.apunteMapper = apunteMapper;
        this.grupoApunteMapper = grupoApunteMapper;
    }

    public List<GrupoApunteDto> buscarGruposApuntesPorFiltro(String busqueda, Integer idMateria, Integer idEstudiante) {
        if (Objects.isNull(busqueda)) {
            busqueda = "";
        }
        return grupoApunteMapper.toDto(grupoApunteRepository.filtrarGruposApunte(busqueda, idMateria, idEstudiante));
    }

    public Apunte buscarApunte(Integer idApunte) {
        if (Objects.isNull(idApunte)) {
            throw new ObjectNotFoundException(null, "Faltan campos requeridos");
        }
        return apunteRepository.findById(idApunte).orElse(null);
    }

    public void eliminarApunte(Integer idApunte) {
        Apunte apunte = buscarApunte(idApunte);
        apunteRepository.delete(apunte);
    }

    public GrupoApunte crearGrupoApunte(GrupoApunteDto grupoApunteDto) {
        GrupoApunte grupoApunte = grupoApunteMapper.toEntity(grupoApunteDto);
        grupoApunte.setFechaCreacion(LocalDateTime.now());
        return grupoApunteRepository.save(grupoApunte);
    }

    public void eliminarGrupoApunte(Integer idGrupoApunte) {
        GrupoApunte grupoApunte = grupoApunteRepository.findById(idGrupoApunte).orElse(null);
        if (grupoApunte != null) {
            grupoApunteRepository.delete(grupoApunte);
        }
    }
    public Apunte guardarApunteTexto(ApunteDto apunteDto) {

        apunteDto.setTipoContenido(TEXTO);
        apunteDto.setFechaCreacion(LocalDateTime.now());

        return apunteRepository.save(apunteMapper.toEntity(apunteDto));
    }

    public Apunte guardarApunteAudio(String rutaArchivo) {
        Apunte apunte = new Apunte();
        apunte.setTipoContenido(AUDIO);
        apunte.setContenido(rutaArchivo);
        return apunteRepository.save(apunte);
    }

    public Apunte guardarApunteFoto(String rutaArchivo) {
        Apunte apunte = new Apunte();
        apunte.setTipoContenido(FOTO);
        apunte.setContenido(rutaArchivo);
        return apunteRepository.save(apunte);
    }

    public List<ApunteDto> listarApuntesPorFiltro(String busqueda, Integer idApunte) {
        if (Objects.isNull(busqueda)) {
            busqueda = "";
        }
        List<Apunte> apuntes = apunteRepository.filtrarApuntes(busqueda, idApunte);
        return apunteMapper.toDto(apuntes);
    }
    public static String guardarArchivo(MultipartFile archivo) throws IOException {
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

package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.GrupoApunte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoApunteRepository extends JpaRepository<GrupoApunte, Integer> {

    @Query("SELECT a " +
            "FROM GrupoApunte a " +
            "JOIN FETCH a.materia m " +
            "WHERE m.idEstudianteFk = :idEstudiante " +
            "AND a.idMateriaFk = :idMateria " +
            "AND ((a.nombre LIKE concat('%', :busqueda, '%'))) ")
    List<GrupoApunte> filtrarGruposApunte(@Param("busqueda") String busqueda,
                                          @Param("idMateria") Integer idMateria,
                                          @Param("idEstudiante") Integer idEstudiante);
}

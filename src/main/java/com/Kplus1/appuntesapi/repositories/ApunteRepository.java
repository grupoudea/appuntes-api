package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Apunte;
import com.Kplus1.appuntesapi.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApunteRepository extends JpaRepository<Apunte, Integer> {


    @Query("SELECT a " +
            "FROM Apunte a " +
            "WHERE a.id = :idApunte " +
            "AND ((a.tipoContenido LIKE concat('%', :busqueda, '%')) " +
            "OR (a.contenido LIKE concat('%', :busqueda, '%'))) ")
    List<Apunte> filtrarApuntes(@Param("busqueda") String busqueda, @Param("idApunte") Integer idApunte);

    @Query("SELECT a " +
            "FROM Apunte a " +
            "WHERE a.tipoContenido = :tipoContenido " +
            "AND a.id = :idApunte ")
    List<Apunte> findByIdApunteAndTipoContenido(@Param("idApunte") Integer idApunte, @Param("tipoContenido") String tipoContenido);
}


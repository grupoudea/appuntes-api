package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.MateriaUniversidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaUniversidadRepository extends JpaRepository<MateriaUniversidad, Integer> {

}

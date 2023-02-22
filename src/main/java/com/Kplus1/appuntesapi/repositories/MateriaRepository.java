package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}

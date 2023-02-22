package com.Kplus1.appuntesapi.repositories;

import com.Kplus1.appuntesapi.entities.Apunte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApunteRepository extends JpaRepository<Apunte, Integer> {

}

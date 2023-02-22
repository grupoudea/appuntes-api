package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.mappers.MateriaMapper;
import com.Kplus1.appuntesapi.repositories.MateriaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final MateriaMapper materiaMapper;

    public MateriaService(MateriaRepository materiaRepository, MateriaMapper materiaMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }
}

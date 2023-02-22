package com.Kplus1.appuntesapi.services;

import com.Kplus1.appuntesapi.mappers.ApunteMapper;
import com.Kplus1.appuntesapi.repositories.ApunteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ApunteService {

    private final ApunteRepository apunteRepository;
    private final ApunteMapper apunteMapper;

    public ApunteService(ApunteRepository apunteRepository, ApunteMapper apunteMapper) {
        this.apunteRepository = apunteRepository;
        this.apunteMapper = apunteMapper;
    }
}

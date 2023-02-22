package com.Kplus1.appuntesapi.controllers;

import com.Kplus1.appuntesapi.services.ApunteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apuntes")
public class ApunteController {

    private final ApunteService apunteService;

    public ApunteController(ApunteService apunteService) {
        this.apunteService = apunteService;
    }
}

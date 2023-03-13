package me.dio.coding.votacaobbbapi.controller;

import me.dio.coding.votacaobbbapi.repository.ParametroRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ParametroController {


    private final ParametroRepository repository;

    public ParametroController(ParametroRepository repository) {
        this.repository = repository;
    }
}

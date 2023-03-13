package me.dio.coding.votacaobbbapi.controller;

import me.dio.coding.votacaobbbapi.model.ParametroModel;
import me.dio.coding.votacaobbbapi.repository.ParametroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {


    private final ParametroRepository repository;

    public ParametroController(ParametroRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametro){
        ParametroModel entidade = repository.save(parametro);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParametroModel> consultar(@RequestParam String chave){
        Optional<ParametroModel> optParametro = repository.findById(chave);
        if (optParametro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optParametro.get());
    }
}

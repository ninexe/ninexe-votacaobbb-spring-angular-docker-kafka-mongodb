package me.dio.coding.votacaobbbapi.controller;

import lombok.AllArgsConstructor;
import me.dio.coding.votacaobbbapi.model.ParametroModel;
import me.dio.coding.votacaobbbapi.model.ParticipanteModel;
import me.dio.coding.votacaobbbapi.repository.ParametroRepository;
import me.dio.coding.votacaobbbapi.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participante")
@AllArgsConstructor
public class ParticipanteController {


    private final ParticipanteRepository repository;

    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante){
        ParticipanteModel entidade = repository.save(participante);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParticipanteModel> consultar(@RequestParam String chave){
        Optional<ParticipanteModel> opt = repository.findById(chave);
        if (opt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(opt.get());
    }
}

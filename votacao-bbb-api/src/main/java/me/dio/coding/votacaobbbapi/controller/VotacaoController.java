package me.dio.coding.votacaobbbapi.controller;

import lombok.AllArgsConstructor;
import me.dio.coding.votacaobbbapi.model.ParticipanteModel;
import me.dio.coding.votacaobbbapi.service.VotacaoService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votacao")
@AllArgsConstructor
public class VotacaoController {

    private final VotacaoService servico;


    @PostMapping
    public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante){
        servico.adicionarEvento(participante);
        return ResponseEntity.ok("voto computado");
    }
}

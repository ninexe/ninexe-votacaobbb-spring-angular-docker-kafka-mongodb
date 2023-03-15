package me.dio.coding.votacaobbbms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.coding.votacaobbbms.model.ParticipanteModel;
import me.dio.coding.votacaobbbms.model.VotacaoModel;
import me.dio.coding.votacaobbbms.repository.VotacaoRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;

    @KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
    private void executar(ConsumerRecord<String, String> registro){

        String partipanteStr = registro.value();
        log.info("Voto recebido = {}", partipanteStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipanteModel participante = null;

        try {
            participante = mapper.readValue(partipanteStr, ParticipanteModel.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter voto [{}]", partipanteStr, ex);
            return;
        }

        VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
        VotacaoModel entity = repository.save(votacao);

        log.info("Voto registrado com sucesso [id={], dataHora={}]", entity.getId(), entity.getDataHora());

    }


}

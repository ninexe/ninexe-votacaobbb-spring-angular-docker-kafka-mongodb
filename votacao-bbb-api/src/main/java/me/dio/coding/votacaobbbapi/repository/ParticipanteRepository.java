package me.dio.coding.votacaobbbapi.repository;

import me.dio.coding.votacaobbbapi.model.ParticipanteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {

}

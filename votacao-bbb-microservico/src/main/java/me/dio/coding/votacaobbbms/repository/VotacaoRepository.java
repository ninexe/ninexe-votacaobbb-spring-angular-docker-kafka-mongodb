package me.dio.coding.votacaobbbms.repository;

import me.dio.coding.votacaobbbms.model.VotacaoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String> {
}

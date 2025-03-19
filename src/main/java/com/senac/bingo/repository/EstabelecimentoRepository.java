package com.senac.bingo.repository;

import com.senac.bingo.model.Estabelecimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends CrudRepository<Estabelecimento, Long> {
}
package com.example.statusNFe.teste.repository;

import com.example.statusNFe.teste.model.Tabela;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TabelaRepository extends JpaRepository<Tabela , Long> {

    @Query(nativeQuery = true, value = "select * from tabela t where uf = :uf ORDER BY data_leitura DESC LIMIT 1")
    List<Tabela> findByOrderByDataLeituraDesc(@Param("uf") String uf);

}

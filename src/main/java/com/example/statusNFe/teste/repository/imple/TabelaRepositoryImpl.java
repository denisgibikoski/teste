package com.example.statusNFe.teste.repository.imple;

import com.example.statusNFe.teste.repository.TabelaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TabelaRepositoryImpl  {

    @PersistenceContext
    private EntityManager em;

    public List<Object[]> findByStatusAtualServicoPorEstado2(String uf, String servico) {

        String sql = "select :servico from tabela t where uf = :uf ORDER BY data_leitura DESC LIMIT 1";
        List<Object[]> retotno = em.createNativeQuery(sql)
                .setParameter("servico", servico.toLowerCase())
                .setParameter("uf", uf)
                .getResultList();

        return retotno;
    }


}

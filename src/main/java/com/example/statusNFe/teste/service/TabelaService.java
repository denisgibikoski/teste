package com.example.statusNFe.teste.service;


import com.example.statusNFe.teste.model.Tabela;
import com.example.statusNFe.teste.model.dto.TabelaResulTDTO;
import com.example.statusNFe.teste.repository.TabelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TabelaService {

    @Autowired
    private TabelaRepository tabelaRepository;

    @Autowired
    private EntityManager entityManager;
    private Object object1;

    public void salvar(Tabela tabela) {
        tabelaRepository.save(tabela);
    }

    public List<Tabela> getStatusAtualServicosPorEstado(String uf) {
        return tabelaRepository.findByOrderByDataLeituraDesc(uf);
    }

    public List<Object[]> getStatusAtualServicoPorEstado(String uf, String servico) {
        String sql = "select t.data_leitura ,t." + servico.toLowerCase() + " from tabela t where uf = :uf ORDER BY t.data_leitura DESC LIMIT 1";
        return entityManager.createNativeQuery(sql)
                .setParameter("uf", uf.toUpperCase())
                .getResultList();
    }

    public List<Tabela> getStatusServicosUFData(String uf, String data) {
        String sql = "select * from tabela t where uf = :uf and t.data_leitura between '"+data+" 00:00:00' and '"+data+" 23:59:59' order by t.data_leitura desc ";
        return entityManager.createNativeQuery(sql)
                .setParameter("uf", uf.toUpperCase())
                .getResultList();
    }

    public  List<TabelaResulTDTO> getServicoMaisIndisponivel() {
        String sql = "select\n" +
                "\tuf,\n" +
                "\tsum(autorizacao4 + consultacadastro4 + consultaprotocolo4  + inutilizacao4 + recepcaoevento4 + retornoautorizacao4 + statusservico4 ) as total\n" +
                "from\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tuf ,\n" +
                "\t\tsum( case when t.autorizacao4 = ' - ' then 1 else 0 end) autorizacao4 ,\n" +
                "\t\tsum( case when t.consultacadastro4 = ' - ' then 1 else 0 end) consultacadastro4 ,\n" +
                "\t\tsum( case when t.consultaprotocolo4 = ' - ' then 1 else 0 end) consultaprotocolo4 ,\n" +
                "\t\tsum( case when t.inutilizacao4 = ' - ' then 1 else 0 end) inutilizacao4 ,\n" +
                "\t\tsum( case when t.recepcaoevento4 = ' - ' then 1 else 0 end) recepcaoevento4 ,\n" +
                "\t\tsum( case when t.retornoautorizacao4 = ' - ' then 1 else 0 end) retornoautorizacao4 ,\n" +
                "\t\tsum( case when t.statusservico4 = ' - ' then 1 else 0 end) statusservico4\n" +
                "\tfrom\n" +
                "\t\ttabela t\n" +
                "\tgroup by\n" +
                "\t\tt.uf ) x\n" +
                "\t\tgroup by uf";

        List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();
        List<TabelaResulTDTO> lisfinal =  new ArrayList<>();
        for (Object[] object1 :list ) {
            String estado =    (String) object1[0] ;
            Integer numero  =  Integer.parseInt( (String) object1[1].toString() );
            lisfinal.add(new TabelaResulTDTO(estado,numero));
        }

        List<TabelaResulTDTO> sortedList = lisfinal.stream()
                .sorted(Comparator.comparingInt(TabelaResulTDTO::getNumero).reversed())
                .collect(Collectors.toList());

        return sortedList;
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }


        return sortedMap;
    }
}

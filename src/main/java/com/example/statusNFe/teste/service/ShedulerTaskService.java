package com.example.statusNFe.teste.service;


import com.example.statusNFe.teste.model.Tabela;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class ShedulerTaskService {
    public Tabela newRegistro(String estado,
                              String autorizacao4,
                              String retornoAutorizacao4,
                              String inutilizacao4,
                              String consultaProtocolo4,
                              String statusServico4,
                              String tempoMedio,
                              String consultaCadastro4,
                              String recepcaoEvento4) {

        Tabela registro = new Tabela();
        registro.setUf(estado);
        registro.setAutorizacao4(  getStatus( autorizacao4 ) );
        registro.setRetornoAutorizacao4( getStatus (retornoAutorizacao4 ) );
        registro.setInutilizacao4( getStatus( inutilizacao4 ) );
        registro.setConsultaProtocolo4( getStatus( consultaProtocolo4 ) );
        registro.setStatusServico4( getStatus( statusServico4 ) );
        registro.setDataLeitura(Date.from(Instant.now())  );
        registro.setTempoMedio(tempoMedio);
        registro.setConsultaCadastro4( getStatus( consultaCadastro4 ) );
        registro.setRecepcaoEvento4( getStatus( recepcaoEvento4 ) );

        System.out.println(registro.toString());

        return registro;
    }

    private String getStatus(String string) {
        if(string.contains("verde")){
            string = "verde";
        }else if (string.contains("amarelo")){
            string = "amarelo";
        }else if (string.contains("vermelho")){
            string = "vermelho";
        }else{
            string = " - ";
        }
        return string ;
    }
}

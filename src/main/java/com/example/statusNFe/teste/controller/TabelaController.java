package com.example.statusNFe.teste.controller;

import com.example.statusNFe.teste.service.TabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/tabela")
public class TabelaController {

    @Autowired
    private TabelaService tabelaService;

    @GetMapping("/status/{uf}")
    public ResponseEntity<?> getStatusAtual(@Valid @PathVariable String uf) {
        // 3- Retornar por rest os status atual dos serviços por estado.
        return ResponseEntity.ok(tabelaService.getStatusAtualServicosPorEstado(uf));
    }

    @GetMapping("/statu/{uf}/{servico}")
    public ResponseEntity<?> getStatusAtualUFServico(@Valid @PathVariable String uf, @Valid @PathVariable String servico) {
        // 4- Retornar por rest o status atual do serviço filtrando por estado.
        return ResponseEntity.ok(tabelaService.getStatusAtualServicoPorEstado(uf, servico));
    }

    @GetMapping("/status/{uf}/{data}")
    public ResponseEntity<?> getStatusAtualUFporData(@Valid @PathVariable String uf,@Valid  @PathVariable String data) {
        // 5- Retornar por rest os status dos serviços por estado filtrando por data.
        return ResponseEntity.ok( tabelaService.getStatusServicosUFData(uf, data) );
    }

    @GetMapping("/status/indisponibilidade")
    public ResponseEntity<?> getStatusAtualIndisponibilidadeServico() {
        // 6- Retornar por rest qual estado teve mais indisponibilidade de serviço.
        return ResponseEntity.ok(tabelaService.getServicoMaisIndisponivel());
    }

}

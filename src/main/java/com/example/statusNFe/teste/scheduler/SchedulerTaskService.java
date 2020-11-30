package com.example.statusNFe.teste.scheduler;

import com.example.statusNFe.teste.model.Tabela;
import com.example.statusNFe.teste.service.ShedulerTaskService;
import com.example.statusNFe.teste.service.TabelaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component @EnableScheduling
public class SchedulerTaskService {

    @Autowired
    private TabelaService tabelaService;

    @Autowired
    private ShedulerTaskService shedulerTaskService;


    @Scheduled(cron = "0 0/1 * * * *")
    public void shedulerTaskServiceExec(){
        try{
            Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
            Element table = doc.getElementById("conteudoDinamico");

            Elements tbody = table.select("tr");

            for ( int i = 1 ; i < 16 ; i ++   ){
                Element tr =  tbody.get(i);
                Elements childs = tr.children();

                Tabela registro = new Tabela();

                registro = shedulerTaskService.newRegistro( ((TextNode)childs.get(0).childNodes().get(0)).getWholeText(),
                                                            ((Attributes)((Element)childs.get(1).childNodes().get(0)).attributes()).html(),
                                                            ((Attributes)((Element)childs.get(2).childNodes().get(0)).attributes()).html(),
                                                            ((Attributes)((Element)childs.get(3).childNodes().get(0)).attributes()).html(),
                                                            ((Attributes)((Element)childs.get(4).childNodes().get(0)).attributes()).html(),
                                                            ((Attributes)((Element)childs.get(5).childNodes().get(0)).attributes()).html(),
                                                            ((TextNode)childs.get(6).childNodes().get(0)).text(),
                                                            ((Attributes)((Element)childs.get(7).childNodes().get(0)).attributes()).html(),
                                                            ((Attributes)((Element)childs.get(8).childNodes().get(0)).attributes()).html() );

                tabelaService.salvar(registro);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

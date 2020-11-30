package com.example.statusNFe.teste.model;

import com.sun.istack.NotNull;
import jdk.jfr.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tabela")
public class Tabela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String uf;
    @NotNull
    @Column(name = "autorizacao4")
    private String autorizacao4;
    @NotNull
    @Column(name = "retornoautorizacao4")
    private String retornoAutorizacao4;
    @NotNull
    @Column(name = "inutilizacao4")
    private String inutilizacao4;
    @NotNull
    @Column(name = "consultaprotocolo4")
    private String consultaProtocolo4;
    @NotNull
    @Column(name = "statusservico4")
    private String statusServico4;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dataLeitura;
    @NotNull
    @Column(name = "tempomedio")
    private String tempoMedio;
    @NotNull
    @Column(name = "consultacadastro4")
    private String consultaCadastro4;
    @NotNull
    @Column(name = "recepcaoevento4")
    private String recepcaoEvento4;


    public Tabela(String uf, String autorizacao4, String retornoAutorizacao4, String inutilizacao4, String consultaProtocolo4, String statusServico4, Date  dataLeitura, String tempoMedio, String consultaCadastro4, String recepcaoEvento4) {
        this.uf = uf;
        this.autorizacao4 = autorizacao4;
        this.retornoAutorizacao4 = retornoAutorizacao4;
        this.inutilizacao4 = inutilizacao4;
        this.consultaProtocolo4 = consultaProtocolo4;
        this.statusServico4 = statusServico4;
        this.dataLeitura = dataLeitura;
        this.tempoMedio = tempoMedio;
        this.consultaCadastro4 = consultaCadastro4;
        this.recepcaoEvento4 = recepcaoEvento4;
    }

    public Tabela() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getAutorizacao4() {
        return autorizacao4;
    }

    public void setAutorizacao4(String autorizacao4) {
        this.autorizacao4 = autorizacao4;
    }

    public String getRetornoAutorizacao4() {
        return retornoAutorizacao4;
    }

    public void setRetornoAutorizacao4(String retornoAutorizacao4) {
        this.retornoAutorizacao4 = retornoAutorizacao4;
    }

    public String getInutilizacao4() {
        return inutilizacao4;
    }

    public void setInutilizacao4(String inutilizacao4) {
        inutilizacao4 = inutilizacao4;
    }

    public String getConsultaProtocolo4() {
        return consultaProtocolo4;
    }

    public void setConsultaProtocolo4(String consultaProtocolo4) {
        this.consultaProtocolo4 = consultaProtocolo4;
    }

    public String getStatusServico4() {
        return statusServico4;
    }

    public void setStatusServico4(String statusServico4) {
        this.statusServico4 = statusServico4;
    }

    public Date  getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(Date  dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public String getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(String tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public String getConsultaCadastro4() {
        return consultaCadastro4;
    }

    public void setConsultaCadastro4(String consultaCadastro4) {
        this.consultaCadastro4 = consultaCadastro4;
    }

    public String getRecepcaoEvento4() {
        return recepcaoEvento4;
    }

    public void setRecepcaoEvento4(String recepcaoEvento4) {
        this.recepcaoEvento4 = recepcaoEvento4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tabela tabela = (Tabela) o;
        return Objects.equals(id, tabela.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "tablela{" +
                "id=" + id +
                ", uf='" + uf + '\'' +
                ", autorização4='" + autorizacao4 + '\'' +
                ", retornoAutorização4='" + retornoAutorizacao4 + '\'' +
                ", Inutilização4='" + inutilizacao4 + '\'' +
                ", consultaProtocolo4='" + consultaProtocolo4 + '\'' +
                ", statusServiço4='" + statusServico4 + '\'' +
                ", dataLeitura=" + dataLeitura +
                ", tempoMédio=" + tempoMedio +
                ", consultaCadastro4='" + consultaCadastro4 + '\'' +
                ", recepçãoEvento4='" + recepcaoEvento4 + '\'' +
                '}';
    }
}

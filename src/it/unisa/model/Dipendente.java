package it.unisa.model;

import java.util.Date;

public class Dipendente {
    private String id, nome, cognome;
    private int oreSettimanali, puntoVendita_id;
    private Date dataDiNascita;

    public Dipendente(String id, String nome, String cognome, int oreSettimanali, int puntoVendita_id, Date dataDiNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.oreSettimanali = oreSettimanali;
        this.puntoVendita_id = puntoVendita_id;
        this.dataDiNascita = dataDiNascita;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getOreSettimanali() {
        return oreSettimanali;
    }

    public void setOreSettimanali(int oreSettimanali) {
        this.oreSettimanali = oreSettimanali;
    }

    public int getPuntoVendita_id() {
        return puntoVendita_id;
    }

    public void setPuntoVendita_id(int puntoVendita_id) {
        this.puntoVendita_id = puntoVendita_id;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}

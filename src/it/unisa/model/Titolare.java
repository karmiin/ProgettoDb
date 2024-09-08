package it.unisa.model;

import java.util.Date;

public class Titolare {
    private String codiceFiscale, nome, cognome;
    private Date dataDiNascita;
    private int puntoVendita_id;

    public Titolare(String codiceFiscale, String nome, String cognome, Date dataDiNascita, int puntoVendita_id) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.puntoVendita_id = puntoVendita_id;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getPuntoVendita_id() {
        return puntoVendita_id;
    }

    public void setPuntoVendita_id(int puntoVendita_id) {
        this.puntoVendita_id = puntoVendita_id;
    }
}

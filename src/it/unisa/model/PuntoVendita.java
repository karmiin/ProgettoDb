package it.unisa.model;

public class PuntoVendita {
    private int id, numeroDipendenti;
    private String provincia, citta, via, civico;

    public PuntoVendita(int id, int numeroDipendenti, String provincia, String citta, String via, String civico) {
        this.id = id;
        this.numeroDipendenti = numeroDipendenti;
        this.provincia = provincia;
        this.citta = citta;
        this.via = via;
        this.civico = civico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDipendenti() {
        return numeroDipendenti;
    }

    public void setNumeroDipendenti(int numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }
}

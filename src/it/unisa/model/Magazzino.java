package it.unisa.model;

public class Magazzino {
    private int id;
    private String provincia, citta, via, civico;

    public Magazzino(int id, String provincia, String citta, String via, String civico) {
        this.id = id;
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

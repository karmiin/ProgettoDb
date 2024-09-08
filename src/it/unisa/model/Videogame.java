package it.unisa.model;

import java.util.Date;

public class Videogame {
    private String codiceABarre, piattaforma, condizione;
    private Date dataDiUscita;


    public Videogame(String codiceABarre, String piattaforma, String condizione, Date dataDiUscita) {
        this.codiceABarre = codiceABarre;
        this.piattaforma = piattaforma;
        this.condizione = condizione;
        this.dataDiUscita = dataDiUscita;
    }

    public String getCodiceABarre() {
        return codiceABarre;
    }

    public void setCodiceABarre(String codiceABarre) {
        this.codiceABarre = codiceABarre;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public String getCondizione() {
        return condizione;
    }

    public void setCondizione(String condizione) {
        this.condizione = condizione;
    }

    public Date getDataDiUscita() {
        return dataDiUscita;
    }

    public void setDataDiUscita(Date dataDiUscita) {
        this.dataDiUscita = dataDiUscita;
    }
}

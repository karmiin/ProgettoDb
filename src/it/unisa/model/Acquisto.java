package it.unisa.model;

import java.util.Date;

public class Acquisto {
    private int numeroOrdine;
    private String indirizzoSpedizione, stato;
    private float totale;
    private Date dataAcquisto;

    public Acquisto(int numeroOrdine, String indirizzoSpedizione, String stato, float totale, Date dataAcquisto) {
        this.numeroOrdine = numeroOrdine;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.stato = stato;
        this.totale = totale;
        this.dataAcquisto = dataAcquisto;
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public float getTotale() {
        return totale;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }
}

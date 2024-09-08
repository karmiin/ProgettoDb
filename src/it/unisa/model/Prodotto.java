package it.unisa.model;

public class Prodotto {
    private String codiceABarre, nome;
    private float prezzo;

    public Prodotto(String codiceABarre, String nome, float prezzo) {
        this.codiceABarre = codiceABarre;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getCodiceABarre() {
        return codiceABarre;
    }

    public void setCodiceABarre(String codiceABarre) {
        this.codiceABarre = codiceABarre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}

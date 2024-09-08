package it.unisa.model;

public class Console {
    private String codiceABarre, nome;
    int annoDiRilascio;

    public Console(String codiceABarre, String nome, int annoDiRilascio) {
        this.codiceABarre = codiceABarre;
        this.nome = nome;
        this.annoDiRilascio = annoDiRilascio;
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

    public int getAnnoDiRilascio() {
        return annoDiRilascio;
    }

    public void setAnnoDiRilascio(int annoDiRilascio) {
        this.annoDiRilascio = annoDiRilascio;
    }
}

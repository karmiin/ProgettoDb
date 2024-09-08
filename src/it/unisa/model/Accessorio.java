package it.unisa.model;

public class Accessorio {
    private String codiceABarre, nome, console_codiceABarre;

    public Accessorio(String codiceABarre, String nome, String console_codiceABarre) {
        this.codiceABarre = codiceABarre;
        this.nome = nome;
        this.console_codiceABarre = console_codiceABarre;
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

    public String getConsole_codiceABarre() {
        return console_codiceABarre;
    }

    public void setConsole_codiceABarre(String console_codiceABarre) {
        this.console_codiceABarre = console_codiceABarre;
    }
}

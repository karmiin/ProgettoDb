package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoDAO {

    public void inserireProdotto(String nome, String codiceABarre,  float prezzo) {
        String query = "INSERT INTO prodotto (nome, codiceABarre, prezzo) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            pst.setString(2, codiceABarre);
            pst.setFloat(3, prezzo);
            pst.executeUpdate();
            System.out.println("Prodotto inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareProdottiPerPuntoVendita(int puntoVenditaId) {
        String query = "SELECT p.nome, p.prezzo, p.codiceABarre " +
                "FROM prodotto p " +
                "JOIN vende v ON p.codiceABarre = v.prodotto " +
                "WHERE v.puntoVendita = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, puntoVenditaId);
            ResultSet rs = ps.executeQuery();

            System.out.println("Prodotti disponibili nel punto vendita con ID " + puntoVenditaId + ":");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Prezzo: " + rs.getFloat("prezzo"));
                System.out.println("Codice a Barre: " + rs.getString("codiceABarre"));
                System.out.println("---------------------------------");
            }

            if (!found) {
                System.out.println("Nessun prodotto trovato per il punto vendita con ID: " + puntoVenditaId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionaTuttiProdotti() {
        String query = "SELECT * FROM prodotto";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Prezzo: " + rs.getFloat("prezzo"));
                System.out.println("Codice a Barre: " + rs.getString("codiceABarre"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

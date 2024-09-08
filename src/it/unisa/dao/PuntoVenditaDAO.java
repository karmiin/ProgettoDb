package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PuntoVenditaDAO {

    public void inserirePuntoVendita(String provincia, String citta, String via, String civico, int numeroDipendenti) {
        String query = "INSERT INTO puntoVendita (provincia, citta, via, civico, numeroDipendenti) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, provincia);
            pst.setString(2, citta);
            pst.setString(3, via);
            pst.setString(4, civico);
            pst.setInt(5, numeroDipendenti);
            pst.executeUpdate();
            System.out.println("Punto vendita inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionarePuntiVenditaConTitolari() {
        String query = "SELECT puntoVendita.*, titolare.nome, titolare.cognome FROM puntoVendita " +
                "JOIN titolare ON puntoVendita.id = titolare.puntoVendita";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Punto Vendita ID: " + rs.getInt("id"));
                System.out.println("Provincia: " + rs.getString("provincia"));
                System.out.println("Città: " + rs.getString("citta"));
                System.out.println("Via: " + rs.getString("via"));
                System.out.println("Civico: " + rs.getString("civico"));
                System.out.println("Numero Dipendenti: " + rs.getInt("numeroDipendenti"));
                System.out.println("Titolare: " + rs.getString("nome") + " " + rs.getString("cognome"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareProdottiNonDisponibiliPerPuntoVendita(int puntoVenditaId) {
        String query = "SELECT p.nome, p.prezzo, p.codiceABarre " +
                "FROM prodotto p " +
                "WHERE p.codiceABarre NOT IN (SELECT v.prodotto FROM vende v WHERE v.puntoVendita = ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, puntoVenditaId);
            ResultSet rs = ps.executeQuery();

            System.out.println("Prodotti non disponibili nel punto vendita con ID " + puntoVenditaId + ":");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Prezzo: " + rs.getFloat("prezzo"));
                System.out.println("Codice a Barre: " + rs.getString("codiceABarre"));
                System.out.println("---------------------------------");
            }

            if (!found) {
                System.out.println("Tutti i prodotti sono disponibili per il punto vendita con ID: " + puntoVenditaId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
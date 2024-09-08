package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DipendenteDAO {

    public void inserireDipendente(String dipendenteId, String nome, String cognome, java.sql.Date dataDiNascita, int oreSettimanali, int puntoVenditaId) {
        String query = "INSERT INTO dipendente (id, nome, cognome, dataDiNascita, oreSettimanali, puntoVendita) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, dipendenteId);
            pst.setString(2, nome);
            pst.setString(3, cognome);
            pst.setDate(4, dataDiNascita);
            pst.setInt(5, oreSettimanali);
            pst.setInt(6, puntoVenditaId);
            pst.executeUpdate();
            System.out.println("Dipendente inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rimuovereDipendente(int id) {
        String query = "DELETE FROM dipendente WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Dipendente rimosso con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareDipendentiPerOreLavorate() {
        String query = "SELECT * FROM dipendente ORDER BY oreSettimanali DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Cognome: " + rs.getString("cognome"));
                System.out.println("Ore Settimanali: " + rs.getInt("oreSettimanali"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareDipendentiPerPuntoVendita(int puntoVenditaId) {
        String query = "SELECT * FROM dipendente WHERE puntoVendita = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, puntoVenditaId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("ID Dipendente: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Cognome: " + rs.getString("cognome"));
                System.out.println("Data di Nascita: " + rs.getDate("dataDiNascita"));
                System.out.println("Ore settimanali: " + rs.getInt("oreSettimanali"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void inserireCliente(String codiceFiscale, String nome, String cognome, java.sql.Date dataDiNascita) {
        String query = "INSERT INTO cliente (codiceFiscale, nome, cognome, dataDiNascita) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, codiceFiscale);
            pst.setString(2, nome);
            pst.setString(3, cognome);
            pst.setDate(4, dataDiNascita);
            pst.executeUpdate();
            System.out.println("Cliente inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rimuovereCliente(String codiceFiscale) {
        String query = "DELETE FROM cliente WHERE codiceFiscale = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, codiceFiscale);
            pst.executeUpdate();
            System.out.println("Cliente rimosso con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareCliente(String codiceFiscale) {
        String query = "SELECT * FROM cliente WHERE codiceFiscale = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, codiceFiscale);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Codice Fiscale: " + rs.getString("codiceFiscale"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Cognome: " + rs.getString("cognome"));
                System.out.println("Data di Nascita: " + rs.getDate("dataDiNascita"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

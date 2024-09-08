package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsoleDAO {

    public void selezionaTutteConsole() {
        String query = "SELECT * FROM console";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            System.out.println("Console disponibili:");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Anno di rilascio: " + rs.getInt("annoDiRilascio"));
                System.out.println("Codice a Barre: " + rs.getString("prodotto"));
                System.out.println("---------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inserireConsole(String nome, int annoDiRilascio, String codiceABarre) {
        String query = "INSERT INTO console (nome, annoDiRilascio, prodotto) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            pst.setInt(2, annoDiRilascio);
            pst.setString(3, codiceABarre);
            pst.executeUpdate();
            System.out.println("Console inserita con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


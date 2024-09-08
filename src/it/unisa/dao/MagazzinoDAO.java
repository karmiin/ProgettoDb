package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MagazzinoDAO {

    public void aggiungereMagazzino(String provincia, String citta, String via, String civico) {
        String query = "INSERT INTO magazzino (provincia, citta, via, civico) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, provincia);
            pst.setString(2, citta);
            pst.setString(3, via);
            pst.setString(4, civico);
            pst.executeUpdate();
            System.out.println("Magazzino aggiunto con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

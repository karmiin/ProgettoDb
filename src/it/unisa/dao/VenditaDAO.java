package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VenditaDAO {

    public void inserireVendita(String codiceABarreProdotto, int puntoVenditaId, int quantita) {
        String query = "INSERT INTO vende (puntoVendita, prodotto, quantita) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, puntoVenditaId);
            pst.setString(2, codiceABarreProdotto);
            pst.setInt(3, quantita);
            pst.executeUpdate();
            System.out.println("Vendita inserita con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

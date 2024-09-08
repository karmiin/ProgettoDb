package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TitolareDAO {

    public void selezionareTitolarePerPuntoVendita(int puntoVenditaId) {
        String query = "SELECT nome, cognome, dataDiNascita, codiceFiscale " +
                "FROM titolare " +
                "WHERE puntoVendita = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, puntoVenditaId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Cognome: " + rs.getString("cognome"));
                System.out.println("Data di Nascita: " + rs.getDate("dataDiNascita"));
                System.out.println("Codice Fiscale: " + rs.getString("codiceFiscale"));
            } else {
                System.out.println("Nessun titolare trovato per il punto vendita con ID: " + puntoVenditaId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


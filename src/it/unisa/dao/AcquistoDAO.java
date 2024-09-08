package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcquistoDAO {

    public void selezionareAcquistiPerTotaleMaggiore(float totale) {
        String query = "SELECT * FROM acquisto WHERE totale > ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setFloat(1, totale);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Numero Ordine: " + rs.getString("numeroOrdine"));
                System.out.println("Data Acquisto: " + rs.getDate("dataAcquisto"));
                System.out.println("Totale: " + rs.getFloat("totale"));
                System.out.println("Indirizzo Spedizione: " + rs.getString("indirizzoSpedizione"));
                System.out.println("Stato: " + rs.getString("stato"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareOrdiniConsegnati() {
        String query = "SELECT * FROM acquisto WHERE stato = 'consegnato'";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Numero Ordine: " + rs.getString("numeroOrdine"));
                System.out.println("Data Acquisto: " + rs.getDate("dataAcquisto"));
                System.out.println("Totale: " + rs.getFloat("totale"));
                System.out.println("Indirizzo Spedizione: " + rs.getString("indirizzoSpedizione"));
                System.out.println("Stato: " + rs.getString("stato"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


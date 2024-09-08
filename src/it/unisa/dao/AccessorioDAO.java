package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessorioDAO {

    public void inserireAccessorio(String nome, String codiceABarreConsole) {
        String query = "INSERT INTO accessorio (nome, console) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nome);
            pst.setString(2, codiceABarreConsole);
            pst.executeUpdate();
            System.out.println("Accessorio inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


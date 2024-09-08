package it.unisa.dao;

import it.unisa.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideogameDAO {

    public void inserireVideogame(String nome, String piattaforma, java.sql.Date dataDiUscita, String condizione, String codiceABarre) {
        String query = "INSERT INTO videogame (piattaforma, dataDiUscita, condizione, prodotto) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, piattaforma);
            pst.setDate(2, dataDiUscita);
            pst.setString(3, condizione);
            pst.setString(4, codiceABarre);
            pst.executeUpdate();
            System.out.println("Videogame inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selezionareVideogamesPerAnno(int anno) {
        String query = "SELECT videogame.*, prodotto.nome FROM videogame " +
                "JOIN prodotto ON videogame.prodotto = prodotto.codiceABarre " +
                "WHERE YEAR(videogame.dataDiUscita) = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, anno);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Nome Videogame: " + rs.getString("nome"));
                System.out.println("Piattaforma: " + rs.getString("piattaforma"));
                System.out.println("Data di Uscita: " + rs.getDate("dataDiUscita"));
                System.out.println("Condizione: " + rs.getString("condizione"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AB Computers
 */
public class DB {
    // Déclaration de la connexion

    private static Connection conn = null;

    // Paramètres de connexion
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_person?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Driver MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Méthode pour obtenir une connexion à la base de données
     *
     * @return Connection (objet de connexion à MySQL)
     */
    public static Connection getConnection() {
        try {
            // Charger le driver
            Class.forName(DRIVER);

            // Vérifier si la connexion n'est pas déjà ouverte
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion à la base de données réussie !");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL non trouvé : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à MySQL : " + e.getMessage());
        }

        return conn;
    }

    /**
     * Méthode pour fermer proprement la connexion
     */
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connexion fermée avec succès.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }
    }
}

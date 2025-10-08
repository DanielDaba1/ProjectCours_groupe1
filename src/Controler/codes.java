/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import View.Home;
import ConDB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import org.mindrot.jbcrypt.BCrypt;

public class codes {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public codes() {
        try {
            conn = DB.getConnection();
        } catch (Exception e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }

    /**
     * Méthode pour connecter l'utilisateur avec email et mot de passe
     */
    public void login(JTextField emailField, JPasswordField passField, JFrame loginFrame, JLabel lblMessage) {
        String email = emailField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        if (email.isEmpty() || password.isEmpty()) {
            lblMessage.setText("Remplissez tous les champs svp !");
            return;
        }

        String sql = "SELECT * FROM person WHERE email = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                // Vérifier le mot de passe avec BCrypt
                if (BCrypt.checkpw(password, hashedPassword)) {
                    lblMessage.setText("Connexion réussie !");
                    new Home().setVisible(true);
                    loginFrame.dispose();
                    System.out.println("Utilisateur connecté : " + email);
                } else {
                    lblMessage.setText("Mot de passe incorrect !");
                }
            } else {
                lblMessage.setText("Email introuvable !");
            }

        } catch (SQLException e) {
            lblMessage.setText("Erreur lors de la connexion !");
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour hasher un mot de passe avant l'enregistrement dans la base
     */
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}

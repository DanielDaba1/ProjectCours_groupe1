/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import ConDB.DB;
import Model.Loginc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author AB Computers
 */
public class LoginImplementeDAO implements DAO<Loginc> {

    @Override
    public void ajouter(Loginc entite) {
        String sql = "INSERT INTO person(firstname, lastname, age, email, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            if (conn != null) {
                System.out.println("[INFO] Connexion à la base de données réussie !");
            } else {
                System.out.println("[ERREUR] Connexion à la base de données échouée !");
                return;
            }

            // Hachage du mot de passe avant enregistrement
            String hashedPassword = BCrypt.hashpw(entite.getPassword(), BCrypt.gensalt());
            System.out.println("[INFO] Mot de passe haché avant l’insertion.");

            st.setString(1, entite.getFirstname());
            st.setString(2, entite.getLastname());
            st.setInt(3, entite.getAge());
            st.setString(4, entite.getEmail());
            st.setString(5, hashedPassword);

            int result = st.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès !");
                System.out.println("[SUCCÈS] Nouvel utilisateur ajouté : "
                        + entite.getFirstname() + " " + entite.getLastname()
                        + " | E-mail : " + entite.getEmail());
            } else {
                JOptionPane.showMessageDialog(null, " L’utilisateur n’a pas été ajouté !");
                System.out.println("[TEST] Aucun enregistrement inséré dans la base.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur d’ajout : " + e.getMessage());
            System.out.println("[ERREUR SQL] " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("[EXCEPTION] " + ex.getMessage());
        }
    }

    @Override
    public void modifier(Loginc entite) {
        String sql = "UPDATE person SET firstname=?, lastname=?, age=?, email=?, password=? WHERE id=?";

        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            if (conn != null) {
                System.out.println("[INFO] Connexion à la base de données réussie pour modification !");
            }

            // Hachage du mot de passe avant modification
            String hashedPassword = BCrypt.hashpw(entite.getPassword(), BCrypt.gensalt());
            System.out.println("[INFO] Mot de passe haché avant la mise à jour.");

            st.setString(1, entite.getFirstname());
            st.setString(2, entite.getLastname());
            st.setInt(3, entite.getAge());
            st.setString(4, entite.getEmail());
            st.setString(5, hashedPassword);
            st.setInt(6, entite.getId());

            int rowsUpdated = st.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Utilisateur modifié avec succès !");
                System.out.println("[SUCCÈS] Utilisateur mis à jour : ID " + entite.getId()
                        + " | " + entite.getFirstname() + " " + entite.getLastname());
            } else {
                JOptionPane.showMessageDialog(null, " Aucune modification détectée !");
                System.out.println("[TEST] Aucun enregistrement modifié dans la base.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de modification : " + e.getMessage());
            System.out.println("[ERREUR SQL] " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("[EXCEPTION] " + ex.getMessage());
        }
    }

   @Override
public void supprimer(Loginc entite) {
    String sql = "DELETE FROM person WHERE id=?";
    try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

        if (conn != null) {
            System.out.println("[INFO] Connexion à la base de données réussie pour suppression !");
        } else {
            System.out.println("[ERREUR] Impossible d’établir la connexion à la base !");
            return;
        }

        st.setInt(1, entite.getId());
        System.out.println("[INFO] Tentative de suppression de l'utilisateur avec ID : " + entite.getId());

        int rowsDeleted = st.executeUpdate();

        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès !");
            System.out.println("[SUCCÈS] L'utilisateur ID " + entite.getId() + " a été supprimé de la base.");
        } else {
            JOptionPane.showMessageDialog(null, "Aucun utilisateur trouvé avec cet ID !");
            System.out.println("[TEST] Aucun enregistrement supprimé (ID inexistant).");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur de suppression : " + e.getMessage());
        System.out.println("[ERREUR SQL] " + e.getMessage());
    } catch (Exception ex) {
        System.out.println("[EXCEPTION] " + ex.getMessage());
    }
}


    @Override
    public List<Loginc> list() {
        List<Loginc> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM person";
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Loginc u = new Loginc();
                u.setId(rs.getInt("id"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setAge(rs.getInt("age"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                utilisateurs.add(u);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors du chargement : " + e.getMessage());
        }
        return utilisateurs;
    }

    @Override
    public Loginc get(int id) {
        Loginc u = null;
        String sql = "SELECT * FROM person WHERE id=?";
        try (Connection conn = DB.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                u = new Loginc();
                u.setId(rs.getInt("id"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setAge(rs.getInt("age"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération : " + e.getMessage());
        }
        return u;
    }

    @Override
    public void imprimer(Loginc entite) {
        JOptionPane.showMessageDialog(null,
                "Utilisateur : " + entite.getFirstname() + " " + entite.getLastname()
                + "\nEmail : " + entite.getEmail()
                + "\nÂge : " + entite.getAge());
    }

    @Override
    public void annuler(Loginc entite) {
        JOptionPane.showMessageDialog(null, "Action annulée pour : " + entite.getFirstname());
    }
}

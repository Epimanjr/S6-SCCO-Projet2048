/*
 * Permet la connexion à la base de données.
 */
package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marine ANGELONI
 */
public class Connexion {

    /**
     * Vrai si la connexion a été initialisé.
     */
    public static Connection connexion;

    /**
     * Récupère la connexion à la base de données.
     * 
     * @return Objet Connection
     */
    public static Connection getConnection() {
        if (connexion == null) {
            // On créer une nouvelle connexion à la base
            try {
                Class.forName("com.mysql.jdbc.Driver");
                //Création du path
                String dbPath = String.format(
                        "jdbc:%s:%s/%s?user=%s&password=%s&characterEncoding=utf-8&"
                        + "useUnicode=true", "mysql", "//localhost", "projet2048", "root", "");
                //Initiatialisation de la connection
                Connexion.connexion = java.sql.DriverManager.getConnection(dbPath);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Connexion.connexion;
    }
}

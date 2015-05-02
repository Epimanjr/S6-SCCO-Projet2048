/*
 * Pour simplification, un utilisateur n'est représenté qu'uniquement par son nom.
 */
package base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marine ANGELONI
 */
public class Utilisateur {

    /**
     * Nom (ou pseudo) de l'utilisateur.
     */
    private String nom;

    /**
     * Créer un utilisateur en fonction de son nom.
     *
     * @param name Nom de l'utilisateur.
     */
    public Utilisateur(String name) {
        this.nom = name;
    }

    public static Object[][] afficherClassement() {
        // Initialisation du résultat
        Object[][] obj = new Object[10][3];
        // On récupère le classement dans la BDD
        String query = "";
        try {
            // Création de la requête
            query = "SELECT * FROM utilisateur ORDER BY score DESC LIMIT 10";
            System.out.println(query + " ... ");
            // Exécution de la requête
            Statement statement = Connexion.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            int it = 0;
            // Interprétation du résultat
            while (result.next()) {
                // Récupération du nom d'utilisteur
                String nom = result.getString("nom");
                // Récupération de son score
                int score = result.getInt("score");
                // Ajout dans l'objet
                obj[it][0] = it + 1;
                obj[it][1] = nom;
                obj[it][2] = score;
                it++;
                // Affichage dans la console
                System.out.println(nom + ": " + score);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException pour : " + query);
        }
        return obj;
    }

    /**
     * On insère un nouveau score pour cet utilisateur.
     *
     * @param score Score
     */
    public void insertionScore(int score) {
        // On récupère le meilleur score actuel de l'utilisateur
        String query = "";
        int scoreMax;
        try {
            // Création de la requête
            query = "SELECT score FROM utilisateur WHERE nom='" + this.nom + "'";
            System.out.println(query + " ... ");
            // Exécution de la requête
            Statement statement = Connexion.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            // Interprétation du résultat
            if (result.next()) {
                scoreMax = result.getInt("score");
                if (score > scoreMax) {
                    // Insertion du nouveau score dans la base
                    query = "UPDATE utilisateur SET score=" + score + " WHERE nom='" + this.nom + "'";
                    System.out.println(query + " ... ");
                    // Exécution de la requête d'insertion
                    statement = Connexion.getConnection().createStatement();
                    statement.executeUpdate(query);
                } else {
                    System.out.println("Vous n'avez pas battu votre meilleur score");
                }
            } else {
                // Insertion du nouveau score dans la base
                query = "INSERT INTO utilisateur(nom, score) VALUES('" + this.nom + "', '" + score + "')";
                System.out.println(query + " ... ");
                // Exécution de la requête d'insertion
                statement = Connexion.getConnection().createStatement();
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException pour : " + query);
        }
    }

    /* GETTER / SETTER */
    
    /**
     * 
     * @return Renvoie le nom de l'utilisateur.
     */
    public String getName() {
        return nom;
    }

    public void setName(String name) {
        this.nom = name;
    }

}

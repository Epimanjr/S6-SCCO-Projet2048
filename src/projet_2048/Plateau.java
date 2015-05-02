/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_2048;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elodie
 */
public class Plateau {

    /**
     * Tableau pour décrire le tableau de jeu.
     */
    public int nb[][] = new int[4][4];
    
    /**
     * Compteur actuel lorqu'on joue.
     */
    public int score;

    public Plateau() {
        this.score = 0;
        int t[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int cpt = 0;
        while (cpt < 2) {
            //Min + (int)(Math.random() * ((Max - Min) + 1));
            int colonne = 0 + (int) (Math.random() * ((3 - 0) + 1));
            int ligne = 0 + (int) (Math.random() * ((3 - 0) + 1));
            int al = 1 + (int) (Math.random() * ((4 - 1) + 1));
            if (al == 1) {
                al = 2;
            }
            if (al == 3) {
                al = 4;
            }
            if (t[colonne][ligne] == 0) {
                t[colonne][ligne] = al;
                cpt = cpt + 1;
            }

        }
        this.nb = t;
    }

    //nb[colonne][ligne]
    public String toString() {
        String affiche = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                affiche = affiche + this.nb[i][j] + " ";
            }
            String Newligne = System.getProperty("line.separator");
            affiche = affiche + Newligne;
        }
        return affiche;
    }

    public boolean testDep() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.nb[i][j] == this.nb[i][j + 1] || this.nb[i][j] == 0 || this.nb[i][j + 1] == 0) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.nb[j][i] == this.nb[j + 1][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean testVictoire() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.nb[i][j] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public void newChiffre() {
        boolean fin = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.nb[i][j] == 0) {
                    fin = true;
                }
            }
        }
        while (fin) {
            //Min + (int)(Math.random() * ((Max - Min) + 1));
            int colonne = 0 + (int) (Math.random() * ((3 - 0) + 1));
            int ligne = 0 + (int) (Math.random() * ((3 - 0) + 1));
            int al = 1 + (int) (Math.random() * ((4 - 1) + 1));
            if (al == 1) {
                al = 2;
            }
            if (al == 3) {
                al = 4;
            }
            if (this.nb[colonne][ligne] == 0) {
                this.nb[colonne][ligne] = al;
                fin = false;
            }
        }
    }

    public void depHaut() {
        for (int cpt = 0; cpt < 3; cpt++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.nb[j][i] == 0) {
                        this.nb[j][i] = this.nb[j + 1][i];
                        this.nb[j + 1][i] = 0;
                    } else if (this.nb[j][i] == this.nb[j + 1][i]) {
                        this.nb[j][i] = this.nb[j][i] * 2;
                        this.score = this.score + this.nb[j][i];
                        this.nb[j + 1][i] = 0;
                    }
                }
            }
        }
        this.newChiffre();
    }

    public void depBas() {
        for (int cpt = 0; cpt < 3; cpt++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (this.nb[j][i] == 0) {
                        this.nb[j][i] = this.nb[j - 1][i];
                        this.nb[j - 1][i] = 0;
                    } else if (this.nb[j][i] == this.nb[j - 1][i]) {
                        this.nb[j][i] = this.nb[j][i] * 2;
                        this.score = this.score + this.nb[j][i];
                        this.nb[j - 1][i] = 0;
                    }
                }
            }
        }
        this.newChiffre();
    }

    public void depGauche() {
        for (int cpt = 0; cpt < 3; cpt++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.nb[i][j] == 0) {
                        this.nb[i][j] = this.nb[i][j + 1];
                        this.nb[i][j + 1] = 0;
                    } else if (this.nb[i][j] == this.nb[i][j + 1]) {
                        this.nb[i][j] = this.nb[i][j] * 2;
                        this.score = this.score + this.nb[i][j];
                        this.nb[i][j + 1] = 0;
                    }
                }
            }
        }
        this.newChiffre();
    }

    public void depDroit() {
        for (int cpt = 0; cpt < 3; cpt++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (this.nb[i][j] == 0) {
                        this.nb[i][j] = this.nb[i][j - 1];
                        this.nb[i][j - 1] = 0;
                    } else if (this.nb[i][j] == this.nb[i][j - 1]) {
                        this.nb[i][j] = this.nb[i][j] * 2;
                        this.score = this.score + this.nb[i][j];
                        this.nb[i][j - 1] = 0;
                    }
                }
            }
        }
        this.newChiffre();
    }

    /**
     * Intelligence artificielle, donne le prochain coup.
     *
     * @return le prochain coup
     */
    public String iaNext() {
        // TODO
        return ("TODO");
    }

    /**
     * Sauvegarde du plateau pour relancer la partie plus tard.
     */
    public void sauvegarder() {
        try {
            // Ecriture dans le fichier
            try ( // Objet pour écrire
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("partieSauvegarde.txt"))) {
                // Ecriture dans le fichier
                oos.writeObject(this.nb);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * On recharge le plateau préalabement sauvegardé.
     *
     * @return vrai si on a bien rechargé la partie
     */
    public boolean recharger() {
        try {
            try ( // Object pour lire
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("partieSauvegarde.txt"))) {
                // Lecture du plateau
                this.nb = (int[][]) ois.readObject();
                return true;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

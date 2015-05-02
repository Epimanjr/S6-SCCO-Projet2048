/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interphace_2048;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextField;

/**
 *
 * @author Elodie
 */
public class vue extends JPanel {

    public static controleur control;
    public static javax.swing.JPanel p;
    public static javax.swing.JLabel label;

    public vue() {
        control = new controleur();
        addKeyListener(control);
    }

    public void ajouteAuCadre(Container conteneur) {
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.Y_AXIS));
        conteneur.add(this);
        label = new JLabel(
                "Taper N pour une nouvelle partie, S pour servir"
                + " ou Q pour quitter");
        conteneur.add(label);
    }

    public static void main(String[] args) {
        // Crée une instance du cadre
        vue v = new vue();
        JFrame monCadre = new JFrame("Table verte de ping-pong");
        monCadre.setBounds(50, 50, 60, 60);
        monCadre.setSize(300, 200);
        monCadre.add(v.control.t.getJ());
        monCadre.setVisible(true);
    }
}

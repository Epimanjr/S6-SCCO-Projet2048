/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author marine
 */
public class Controleur implements KeyListener {

    MainFrame panel;

    public Controleur(MainFrame panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("Touche pressé");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print("Touche préssé: ");
        actionCode(e.getKeyCode());
    }

    public void actionCode(int code) {
        switch (code) {
            case KeyEvent.VK_UP:
                // Si flèche du haut
                System.out.println("UP");
                MainFrame.plateau.depHaut();
                break;
            case KeyEvent.VK_DOWN:
                // Si flèche du bas
                System.out.println("DOWN");
                MainFrame.plateau.depBas();
                break;
            case KeyEvent.VK_LEFT:
                // Si flèche de gauche
                System.out.println("LEFT");
                MainFrame.plateau.depGauche();
                break;
            case KeyEvent.VK_RIGHT:
                // Si flèche de droite
                System.out.println("RIGHT");
                MainFrame.plateau.depDroit();
                break;
        }
        // Sauvegarde du plateau
        MainFrame.plateau.sauvegarder();
        // Dessin
        panel.repaint();
        // Test si l'utilisateur a perdu
        if (!MainFrame.plateau.testDep()) {
            JOptionPane.showMessageDialog(null, "Vous avez perdu!!", "Lost", JOptionPane.INFORMATION_MESSAGE);
        }
        // Test si l'utilisateur a gagné
        if (MainFrame.plateau.testVictoire()) {
            JOptionPane.showMessageDialog(null, "Vous avez gagné!!", "Win", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // System.out.println("Touche pressé");

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

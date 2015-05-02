package graphic;

// Tous les imports nécessaires
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import projet_2048.Plateau;

/**
 * Panel qui gère le rectangle principale, c'est dans celui-là que seront
 * dessinés les autres petits rectangles
 */
public class Panel extends JPanel {

    /**
     * Paramètres de configuration
     */
    public static int preferredWidth = 400, preferredHeight = 400;
    public static int marge = 5;

    /**
     * Constructeur qui initialise le panel avec les attributs statiques
     */
    public Panel() {
        super();
        // Personnalisation des dimensions
        this.setPreferredSize(new Dimension(preferredWidth + 2 * marge, preferredHeight + 2 * marge));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessin du rectangle principal

        System.out.println(MainFrame.plateau);
        g.drawRect(marge, marge, preferredWidth, preferredHeight);
        // Parcours (double) pour les sous-rectangles
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Dessiner
                int nb = MainFrame.plateau.nb[i][j];
                // System.out.println(i + ";" + j + ":" + nb);
                // Dessin du rectangle
                g.setColor(Config.listeCouleurs.get(nb));
                g.fillRect(marge + j * (preferredWidth / 4), marge + i * (preferredHeight / 4), preferredWidth / 4, preferredHeight / 4);
                // Dessin de la bordure
                g.setColor(Color.BLACK);
                g.drawRect(marge + j * (preferredWidth / 4), marge + i * (preferredHeight / 4), preferredWidth / 4, preferredHeight / 4);

                // Dessin du nombre
                if (nb != 0) {
                    g.setColor(Color.BLACK);
                    Font font = new Font("Courier", Font.BOLD, 20);
                    g.setFont(font);
                    g.drawString("" + nb, marge + j * (preferredWidth / 4) + 50, marge + i * (preferredHeight / 4) + 50);

                }
            }
        }
    }

    /**
     * Méthode principale, qui créer une fenêtre avec un Panel puis la lance
     */
    public static void main(String[] args) {
        if (args.length == 3) {
            // Conversion en entier
            try {
                // 
                Integer i1 = new Integer(args[0]);
                Integer i2 = new Integer(args[1]);
                Integer i3 = new Integer(args[2]);
                // OK
                Panel.preferredWidth = i1;
                Panel.preferredHeight = i2;
                Panel.marge = i3;
                initFrame();
            } catch (Exception e) {
                System.out.println("Erreur: il faut des nombres ...");
            }
        } else if (args.length == 0) {
            initFrame();
        } else {
            System.out.println("Usage : Java Panel <NB1> <NB2> <NB3>");
        }
    }

    public static void initFrame() {
        // Initialisation fenêtre
        JFrame fenetre = new JFrame("Test 2048 rectangles");
        // Initialisation panel
        Panel panel = new Panel();
        fenetre.setContentPane(panel);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack();
        fenetre.setVisible(true);

        // Dessin
        panel.repaint();
    }
}

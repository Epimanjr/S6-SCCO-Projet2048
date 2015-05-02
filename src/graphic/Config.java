package graphic;

import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author marine
 */
public class Config {

    /**
     * Liste des couleurs pour les tuiles.
     */
    public static HashMap<Integer, Color> listeCouleurs = new HashMap<>();

    /**
     * Initialisation des variables nécessaires.
     */
    public static void init() {
        listeCouleurs.put(0, new Color(255, 255, 255));
        listeCouleurs.put(2, new Color(255, 226, 115));
        listeCouleurs.put(4, new Color(232, 109, 12));
        listeCouleurs.put(8, new Color(255, 226, 115));
        listeCouleurs.put(16, new Color(232, 109, 12));
        listeCouleurs.put(32, new Color(255, 226, 115));
        listeCouleurs.put(64, new Color(232, 109, 12));
        listeCouleurs.put(128, new Color(255, 226, 115));
        listeCouleurs.put(256, new Color(232, 109, 12));
        listeCouleurs.put(512, new Color(255, 226, 115));
        listeCouleurs.put(1024, new Color(232, 109, 12));
        listeCouleurs.put(2048, new Color(255, 226, 115));
    }
}

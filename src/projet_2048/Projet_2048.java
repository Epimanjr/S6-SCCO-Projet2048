/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_2048;

import java.util.Scanner;

/**
 *
 * @author Elodie
 */
public class Projet_2048 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Plateau a = new Plateau();
        System.out.print(a.toString());

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel déplacement souhaitez-vous ?");
        String s = sc.nextLine();
        while (!s.equals("stop")) {
            if (s.equals("h") || s.equals("8")) {
                System.out.println("Déplacement vers le haut");
                a.depHaut();
                System.out.println(a.toString());
            }
            if (s.equals("b") || s.equals("2")) {
                System.out.println("Déplacement vers le bas");
                a.depBas();
                System.out.println(a.toString());
            }
            if (s.equals("g") || s.equals("4")) {
                System.out.println("Déplacement vers la gauche");
                a.depGauche();
                System.out.println(a.toString());
            }
            if (s.equals("d") || s.equals("6")) {
                System.out.println("Déplacement vers la droite");
                a.depDroit();
                System.out.println(a.toString());
            }
            if (!a.testVictoire()) {
                if (a.testDep()) {
                    System.out.println("Votre score est de : " + a.score);
                    System.out.println("Quel déplacement souhaitez-vous ?");
                    s = sc.nextLine();
                } else {
                    System.out.println("PERDU !!!!!");
                    break;
                }
            } else {
                System.out.println("VICTOIRE");
                break;
            }

        }
    }
}

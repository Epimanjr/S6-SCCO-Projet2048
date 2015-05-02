/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
new int2048().setVisible(true);
                tuile t = new tuile();
                bigPanel.add(t.getJ());
 */
package interphace_2048;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Elodie
 */
public class tuile {
    private static int x;
    private static int y;
    private static int val;
    private static javax.swing.JPanel j;
           
    public tuile(){
        x=50;
        y=50;
        j= new JPanel();
        j.setSize(40, 40);
        javax.swing.JLabel l = new JLabel("1"); 
        j.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        j.setLocation(x, y);  
        j.add(l);
    }
    public void setX(int i){
        x=i;
    }
    public void setY(int i){
        y=i;
    }
    public void setVal(int i){
        val=i;
    }
    public void setJ(javax.swing.JPanel i){
        j=i;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getVal(){
        return val;
    }
    public javax.swing.JPanel getJ(){
        return j;
    }
}

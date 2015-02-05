package key;
import java.awt.event.ActionEvent;
import javax.swing.*;

import jlatexmath.*;
import javax.swing.plaf.ActionMapUIResource;
import Jmp.JmpView;
public class KeyButton  {
    public KeyButton (JmpView o,char ke){
        owner=o;
        frase=java.lang.Character.toString(ke);
        gbp=new Keyinputdetails(this,ke);
        button=new javax.swing.JButton();
        button.setText(java.lang.Character.toString(ke));
        keyMap = new ComponentInputMap(button);
        button.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(
                    java.awt.event.ActionEvent evt) {
                draw();
            }  });
        setAccelerator(ke);
        button.setFocusable(false);
        button.setHorizontalTextPosition(
                javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(
                javax.swing.SwingConstants.BOTTOM); 
        SwingUtilities.replaceUIInputMap(button,
                JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
    }
    public KeyButton(JmpView o, String g, String t, char ke,
            javax.swing.KeyStroke kes) {
        owner = o;
        button=new javax.swing.JButton();
        button.setFont(new java.awt.Font(null, 0, 24));
        button.setText(t);
        gbp=new Keyinputdetails(this,g,t,ke); 
        frase=g;
        current=ke;
        keyMap = new ComponentInputMap(button);
         keyMap.put(kes, "action");
       ActionMapUIResource  actionMap = new ActionMapUIResource();
        actionMap.put("action", this.action);
        SwingUtilities.replaceUIActionMap(button, actionMap);
        
        SwingUtilities.replaceUIInputMap(button,
                JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
        button.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(
                    java.awt.event.ActionEvent evt) {
                draw();
            }  });

        button.setFocusable(false);
        button.setHorizontalTextPosition(
                javax.swing.SwingConstants.CENTER);
        button.setVerticalTextPosition(
                javax.swing.SwingConstants.BOTTOM);
        
    }
    public void setAccelerator(char ke) {
        keyMap.remove(javax.swing.KeyStroke.getKeyStroke(current)); 
        keyMap.put(javax.swing.KeyStroke.getKeyStroke(ke), "action");
       ActionMapUIResource  actionMap = new ActionMapUIResource();
        actionMap.put("action", this.action);
        SwingUtilities.replaceUIActionMap(button, actionMap);
        current=ke;
    }
    private Action action = new AbstractAction("Action Name") {

        public void actionPerformed(ActionEvent evt) {
           draw();
           
        }
    };
    public void update(String g, String b){
        if (20>g.length()&g.length()>2){
        TeXFormula formula=new  TeXFormula (g);
        button.setText(null);
        button.setIcon(formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20));
        } else {
            button.setIcon(null);
            button.setText(b);
        }
        frase=g;
        gbp.generator.setText(g);
        gbp.button.setText(b);
    } 
    public void draw(){
        owner.getcurrent().getMPicture1().draw(frase);
    }
    
        
    public JmpView owner;
    public Keyinputdetails gbp;
    public String frase;
    public javax.swing.JButton button;
    private char current;
    private InputMap keyMap;
}
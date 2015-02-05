/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package key;

import java.io.File;
import javax.swing.JMenuItem;
import Jmp.JmpView;

/**
 *
 * @author jenniferschofield
 */
public class Keyfile {
public Keyfile(File n, boolean os, JmpView o,int i){
    name=n;
    owner=o;
    opensave=os;
    fileoption=new javax.swing.JMenuItem(name.getName());
    if (opensave){
            fileoption.setAccelerator(
                    javax.swing.KeyStroke.getKeyStroke(
                    i, java.awt.event.InputEvent.CTRL_MASK));

    }else {
     fileoption.setAccelerator(
             javax.swing.KeyStroke.getKeyStroke(
             i, java.awt.event.InputEvent.ALT_MASK));

    }
      fileoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (opensave){
                    owner.editkb(name);
                }else{
                    owner.changekeyb(name);
                }
            }
        });
}
private javax.swing.JMenuItem fileoption;

    public JMenuItem getFileoption() {
        return fileoption;
    }
private File name;

    public File getName() {
        return name;
    }
private JmpView owner;
private boolean opensave;
}

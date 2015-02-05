/*
 * Keyboard.java
 *
 * Created on March 28, 2010, 12:16 AM
 */
package key;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Jmp.JmpView;
/**
 *
 * @author  jenniferschofield
 */
public class Keyboard {
    KeyButton [] kbs;
    public JmpView owner;
    public javax.swing.JFrame kbdefind;
    /** Creates new form Keyboard */
    public Keyboard(JmpView o) {
        owner=o;
        Keyboardsetup();
    }
    public Keyboard(){
        Keyboardsetup();
    }

    public Keyboard(File n){
        name=n;
        Keyboardsetup();
         try {
            java.io.DataInputStream inputstream;
            inputstream = new DataInputStream(
                    new FileInputStream(name));
             for (int i = 0; i < 96; i++) {
                kbs[i].update(inputstream.readUTF(),
                        inputstream.readUTF());
            }
            inputstream.close();
        } catch (IOException ex) {
            Logger.getLogger("global").
                    log(Level.SEVERE, null, ex);
        }


    }
    public void  Keyboardsetup (){
        initComponents();
        String keys="1234567890";                                  
        String keys2="qwertyuiop";                                  
        String keys3="asdfghjkl";                                  
        String keys4="zxcvbnm";
        String keyS="!@#$%^&*()";
        String keyS2="QWERTYUIOP";
        String keyS3="ASDFGHJKL";
        String keyS4="ZXCVBNM";
        int l=keys.length();
        int start=0;

        kbs=new KeyButton[97];
        newkey(82,'`',"`", 1);
        newkey(83,'~',"~", 1);
        for (int i=0;i<l;i++){
            kbs[2*i]=new KeyButton(owner,keys.charAt(i));
            jPanel1.add(kbs[2*i+start].gbp);
            jToolBar1.add(kbs[2*i].button);
            kbs[2*i+1]=new KeyButton(owner,keyS.charAt(i));
            jPanel1.add(kbs[2*i+1+start].gbp);
            jToolBar1.add(kbs[2*i+1+start].button);
        }
        newkey(84,'-',"-", 1);
        newkey(85,'_',"_", 1);
        newkey(81,'=',"=", 1);
        newkey(80,'+',"+", 1);
        start=l*2;
         kbs[96]=new KeyButton(owner,"tab","tab", '\t',
                  javax.swing.KeyStroke.getKeyStroke(9, 0));
            jPanel1.add(kbs[96].gbp);
            jToolBar2.add(kbs[96].button);
        l=keys2.length();

           for (int i=0;i<l;i++){
            kbs[2*i+start]=new KeyButton(owner,keys2.charAt(i));
            jPanel1.add(kbs[2*i+start].gbp);
            jToolBar2.add(kbs[2*i+start].button);
            kbs[2*i+1+start]=new KeyButton(owner,keyS2.charAt(i));
            jPanel1.add(kbs[2*i+1+start].gbp);
            jToolBar2.add(kbs[2*i+1+start].button);
        }

        newkey(77,'[',"[", 2);
        newkey(86,'{',"{", 2);
        newkey(78,']',"]", 2);
        newkey(87,'}',"}", 2);
        newkey(88,'\\',"\\", 2);
        newkey(89,'|',"|", 2);
        start=l*2+start;
        l=keys3.length();
        for (int i=0;i<l;i++){
            kbs[2*i+start]=new KeyButton(owner,keys3.charAt(i));
            jPanel1.add(kbs[2*i+start].gbp);
            jToolBar3.add(kbs[2*i+start].button);
            kbs[2*i+1+start]=new KeyButton(owner,keyS3.charAt(i));
            jPanel1.add(kbs[2*i+1+start].gbp);
            jToolBar3.add(kbs[2*i+1+start].button);
        }
        newkey(76,';',";", 3);
        newkey(79,':',":", 3);
        newkey(90,'\'',"\'", 3);
        newkey(91,'\"'," ", 3);
        start=l*2+start;
        l=keys4.length();
        for (int i=0;i<l;i++){
            kbs[2*i+start]=new KeyButton(owner,keys4.charAt(i));
            jPanel1.add(kbs[2*i+start].gbp);
            jToolBar4.add(kbs[2*i+start].button);
            kbs[2*i+start+1]=new KeyButton(owner,keyS4.charAt(i));
            jPanel1.add(kbs[2*i+start+1].gbp);
            jToolBar4.add(kbs[2*i+1+start].button);
        }

        newkey(74,',',",", 4);
        newkey(92,'<',"<", 4);
        newkey(75,'.',".", 4);
        newkey(93,'>',">", 4);
        newkey(94,'/',"/", 4);
        newkey(95,'?',"?", 4);
        newkey(72,' '," ", 4);
        kbs[73]=new KeyButton(owner,"return","return", '\n',
                  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
            jPanel1.add(kbs[73].gbp);
            jToolBar3.add(kbs[73].button);

       //reset();
    }
    public void newkey(int index, char c, String s, int tb){
           kbs[index]=new KeyButton(owner, c);
           kbs[index].update(s, s);
            jPanel1.add(kbs[index].gbp);
            switch (tb){
                case 1:
                    jToolBar1.add(kbs[index].button);
                    break;
                case 2:
                    jToolBar2.add(kbs[index].button);
                    break;
                case 3:
                    jToolBar3.add(kbs[index].button);
                    break;
                case 4:
                    jToolBar4.add(kbs[index].button);
                   break;
            }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar2 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        jToolBar4 = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenusave = new javax.swing.JMenuItem();
        jMenuopen = new javax.swing.JMenuItem();
        jMenureset = new javax.swing.JMenuItem();
        kbdefind=new javax.swing.JFrame();

        kbdefind.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        kbdefind.setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(50, 2));
        jScrollPane1.setViewportView(jPanel1);

        jButton1.setName("jButton1"); // NOI18N
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update();

            }
        });

        jButton2.setName("jButton2"); // NOI18N
        jButton2.setText("Cancel");
        jPanel2.setName("jPanel2"); // NOI18N

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        jToolBar2.setRollover(true);
        jToolBar2.setName("jToolBar2"); // NOI18N

        jToolBar3.setRollover(true);
        jToolBar3.setName("jToolBar3"); // NOI18N

        jToolBar4.setRollover(true);
        jToolBar4.setName("jToolBar4"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .add(jToolBar2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .add(jToolBar3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .add(jToolBar4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("File"); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenusave.setText("Save"); // NOI18N
        jMenusave.setName("jMenusave"); // NOI18N
        jMenusave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save();
            }
        });
        jMenu1.add(jMenusave);

        jMenuopen.setText("open"); // NOI18N
        jMenuopen.setName("jMenuopen"); // NOI18N
        jMenuopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open();
            }
        });
        jMenu1.add(jMenuopen);

        jMenureset.setText(("Reset")); // NOI18N
      
        jMenu1.add(jMenureset);

        jMenuBar1.add(jMenu1);

        kbdefind.setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(kbdefind.getContentPane());
        kbdefind.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .add(jButton1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButton2))
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(jButton1)))
        );

        kbdefind.pack();
    }// </editor-fold>
    public void update(){
         try {
            java.io.DataOutputStream outputstream;
            outputstream = new DataOutputStream(
                    new FileOutputStream(name));
            for (int i = 0; i < 96; i++) {
                outputstream.writeUTF(
                        kbs[i].gbp.generator.getText());
                outputstream.writeUTF(
                        kbs[i].gbp.button.getText());
            }
            outputstream.close();
        } catch (IOException ex) {
            Logger.getLogger(
                    Keyboard.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
         this.kbdefind.setVisible(false);


    }
public void save() {                                          
        try {
            javax.swing.JFileChooser saveas = 
                    new javax.swing.JFileChooser();
            if (saveas.showSaveDialog(kbdefind) ==
                    javax.swing.JFileChooser.APPROVE_OPTION) {
                java.io.File file = saveas.getSelectedFile();
                   name = file;
                  file.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger("global").log(Level.SEVERE,
                    null, ex);
        }
        try {
            java.io.DataOutputStream outputstream;
            outputstream = new DataOutputStream(
                    new FileOutputStream(name));
            for (int i = 0; i < 96; i++) {
                outputstream.writeUTF(
                        kbs[i].gbp.generator.getText());
                outputstream.writeUTF(
                        kbs[i].gbp.button.getText());
            }
            outputstream.close();
        } catch (IOException ex) {
            Logger.getLogger(
                    Keyboard.class.getName()).log(Level.SEVERE, 
                    null, ex);
        } 
    
}                                         
public void open() {                                          
    try {
            javax.swing.JFileChooser open =
                    new javax.swing.JFileChooser();
            if (open.showOpenDialog(kbdefind) ==
                    javax.swing.JFileChooser.APPROVE_OPTION) {
                java.io.File file = open.getSelectedFile();
            name = file;
            java.io.DataInputStream inputstream;
            inputstream = new DataInputStream(
                    new FileInputStream(name));
             for (int i = 0; i < 96; i++) {
                kbs[i].update(inputstream.readUTF(),
                        inputstream.readUTF());
            }
            inputstream.close();
        }} catch (IOException ex) {
            Logger.getLogger("global").
                    log(Level.SEVERE, null, ex);
        }
}

public void open(File n) {
    name=n;
    try {

            java.io.DataInputStream inputstream;
            inputstream = new DataInputStream(
                    new FileInputStream(name));
             for (int i = 0; i < 96; i++) {
               
                kbs[i].update(inputstream.readUTF(),
                        inputstream.readUTF());
            }
            inputstream.close();
        } catch (IOException ex) {
            Logger.getLogger("global").
                    log(Level.SEVERE, null, ex);
        }
}

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuopen;
    private javax.swing.JMenuItem jMenureset;
    private javax.swing.JMenuItem jMenusave;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JToolBar jToolBar1;
    public javax.swing.JToolBar jToolBar2;
    public javax.swing.JToolBar jToolBar3;
    public javax.swing.JToolBar jToolBar4;
    // End of variables declaration                   
    private File name;

    public void setName(File name) {
        this.name = name;
    }
    public static void main (String[] args){
        Keyboard makenew=new Keyboard ();
        makenew.kbdefind.setVisible(true);
    }
}
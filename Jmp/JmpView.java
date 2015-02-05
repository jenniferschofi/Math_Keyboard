/*
 * JmpView.java
 */

package Jmp;

import key.Keyfile;
import key.Keyboard;
import java.beans.PropertyVetoException;
import java.io.*;
import java.util.Vector;
import java.util.logging.*;
/**
 * The application's main frame.
 */
public class JmpView extends javax.swing.JFrame {
   // Variables declaration - do not modify
    private javax.swing.JDesktopPane app;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel jPanel1;
    private Vector <Keyfile> jmenueEitems;
    private Vector <Keyfile> jmenuechangeitems;
    private javax.swing.JMenu jMenucjhange;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenuedit;
    private javax.swing.JMenu jMenukb;
    private javax.swing.JMenu jMenueditkb;
    private javax.swing.JMenu jMenuFs;
    private javax.swing.JMenu jMenufsk;
    private javax.swing.JMenu jMenufsm;
    private javax.swing.JMenuItem jMenunew;
    private javax.swing.JMenuItem jMenunkb;
    private javax.swing.JMenuItem jMenuopen;
    private javax.swing.JMenuItem jMenuread;
    private javax.swing.JMenuItem jMenusave;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem jMenundo;
    private javax.swing.JMenuItem jMenucut;
    private javax.swing.JMenuItem jMenucoppt;
    private javax.swing.JMenuItem jMenupaste;
    private javax.swing.JMenuItem jMenuItemadd;
    private javax.swing.JMenuItem jMenuItemfkl;
    private javax.swing.JMenuItem jMenuItemfk2;
    private javax.swing.JMenuItem jMenuItemfk3;
    private javax.swing.JMenuItem jMenufm6;
    private javax.swing.JMenuItem jMenufm5;
    private javax.swing.JMenuItem jMenufm4;
    private javax.swing.JMenuItem jMenufm1;
    private javax.swing.JMenuItem jMenufm2;
    private javax.swing.JMenuItem jMenufm3;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration
    private Keyboard mathkeyboard;
    private Keyboard mathkeyboard1;
    private Mfilenode files;
    private int numnewfiles;
    private int depth=25;

    public static void main(String[] args) {
          JmpView j=new JmpView();
    }
    public JmpView()  {
        numnewfiles=0;
        mathkeyboard=new Keyboard();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        app = new javax.swing.JDesktopPane();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenunew = new javax.swing.JMenuItem();
        jMenuread = new javax.swing.JMenuItem();
        jMenuopen = new javax.swing.JMenuItem();
        jMenusave = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuedit = new javax.swing.JMenu();
        jMenucut = new javax.swing.JMenuItem();
        jMenucoppt = new javax.swing.JMenuItem();
        jMenupaste = new javax.swing.JMenuItem();
        jMenundo = new javax.swing.JMenuItem();
        printMenuItem = new javax.swing.JMenuItem();
        jMenukb = new javax.swing.JMenu();
        jMenunkb = new javax.swing.JMenuItem();
        jMenucjhange = new javax.swing.JMenu();
        jMenueditkb = new javax.swing.JMenu();
        jMenuItemadd = new javax.swing.JMenuItem();
        jMenuFs = new javax.swing.JMenu();
        jMenufsk = new javax.swing.JMenu();
        jMenuItemfkl = new javax.swing.JMenuItem();
        jMenuItemfk2 = new javax.swing.JMenuItem();
        jMenuItemfk3 = new javax.swing.JMenuItem();
        jMenufsm = new javax.swing.JMenu();
        jMenufm1 = new javax.swing.JMenuItem();
        jMenufm2 = new javax.swing.JMenuItem();
        jMenufm3 = new javax.swing.JMenuItem();
        jMenufm4 = new javax.swing.JMenuItem();
        jMenufm5 = new javax.swing.JMenuItem();
        jMenufm6 = new javax.swing.JMenuItem();
        setFocusTraversalKeysEnabled(false);

        mainPanel.setName("mainPanel"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel1.setName("jPanel1"); // NOI18N

        try {
            newfile(false);
        } catch (IOException ex) {
            Logger.getLogger(JmpView.class.getName()).log(Level.SEVERE, null, ex);
        }
        mathkeyboard=new Keyboard(this);
        mathkeyboard1=new Keyboard(this);
        changelayout();;
        app.setName("app"); // NOI18N
        menuBar.setName("menuBar"); // NOI18N
        fileMenu.setText(("File")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N
        jMenunew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_N,
                java.awt.event.InputEvent.META_MASK));
        jMenunew.setText(("New")); // NOI18N
        jMenunew.setName("jMenunew"); // NOI18N
        jMenunew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAp(evt);
            }
        });
        fileMenu.add(jMenunew);

        jMenuopen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.META_MASK));
        jMenuopen.setText(("Open")); // NOI18N
        jMenuopen.setName("jMenuopen"); // NOI18N
        jMenuopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAp(evt);
            }
        });
        fileMenu.add(jMenuopen);

        jMenuread.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_R,
                java.awt.event.InputEvent.META_MASK));
        jMenuread.setText(("Read")); // NOI18N
        jMenuread.setName("jMenusave"); // NOI18N
        jMenuread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    read();
                } catch (IOException ex) {
                    Logger.getLogger(JmpView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        fileMenu.add(jMenuread);


        jMenusave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.META_MASK));
        jMenusave.setText(("Save")); // NOI18N
        jMenusave.setName("jMenusave"); // NOI18N
        jMenusave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAp(evt);
            }
        });
        fileMenu.add(jMenusave);

        printMenuItem.setText("Print");
        printMenuItem.addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(
                    java.awt.event.ActionEvent evt) {
                printMenuItemActionPerformed();
            }
        });
        fileMenu.add(printMenuItem);

        exitMenuItem.setName("Exit"); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitAp(evt);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        jMenuedit.setText(("Edit")); // NOI18N
        jMenuedit.setName("jMenuedit"); // NOI18N

        jMenucut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_X,
                java.awt.event.InputEvent.META_MASK));
        jMenucut.setText(("cut")); // NOI18N
        jMenucut.setName("jMenucut"); // NOI18N
        jMenucut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenucutActionPerformed(evt);
            }
        });
        jMenuedit.add(jMenucut);

        jMenucoppt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));
        jMenucoppt.setText(("Copy")); // NOI18N
        jMenucoppt.setName("jMenucoppt"); // NOI18N
        jMenucoppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenucopptActionPerformed(evt);
            }
        });
        jMenuedit.add(jMenucoppt);

        jMenupaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.META_MASK));
        jMenupaste.setText( ("Paste")); // NOI18N
        jMenupaste.setName("jMenupaste"); // NOI18N
        jMenupaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenupasteActionPerformed(evt);
            }
        });
        jMenuedit.add(jMenupaste);

        jMenundo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, 0));
        jMenundo.setText( ("Unfo")); // NOI18N
        jMenundo.setName("jMenundo"); // NOI18N
        jMenundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenundoActionPerformed(evt);
            }
        });
        jMenuedit.add(jMenundo);

        menuBar.add(jMenuedit);

        jMenukb.setText( ("Keyboard")); // NOI18N
        jMenukb.setName("jMenukb"); // NOI18N

        jMenunkb.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.META_MASK));
        jMenunkb.setText( ("New keyboard")); // NOI18N
        jMenunkb.setName("jMenunkb"); // NOI18N
        jMenunkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenunkbActionPerformed(evt);
            }
        });
        jMenukb.add(jMenunkb);

        jmenueEitems=new Vector();
        jmenuechangeitems=new Vector();
        jMenucjhange.setText( ("Change Keyboard")); // NOI18N
        jMenucjhange.setName("jMenucjhange"); // NOI18N
        jMenukb.add(jMenucjhange);

        jMenueditkb.setText( ("Edit keyboardt")); // NOI18N
        jMenueditkb.setName("jMenueditkb"); // NOI18N
        jMenukb.add(jMenueditkb);

        jMenuItemadd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.META_MASK));
        jMenuItemadd.setText( ("jAdd Keyboard")); // NOI18N
        jMenuItemadd.setName("jMenuItemadd"); // NOI18N
        jMenuItemadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKbAp(evt);
            }
        });
        jMenukb.add(jMenuItemadd);
        menuBar.add(jMenukb);
        jMenuFs.setText("Font sizes");

        jMenufsk.setText("Keyboard");
        jMenuItemfkl.setText("Large");
        jMenuItemfkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depth=50;
                changelayout();
            }
        });
        jMenufsk.add(jMenuItemfkl);
        jMenuItemfk2.setText("Regular");
        jMenuItemfk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depth=25;

                changelayout();
            }
        });
        jMenufsk.add(jMenuItemfk2);

        jMenuItemfk3.setText("Small");
        jMenuItemfk3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depth=5;
                changelayout();
        

            }
        });
        jMenufsk.add(jMenuItemfk3);

       
        jMenuFs.add(jMenufsk);

        jMenufsm.setText("Mathtype");
        jMenufm1.setText("10 point");
        jMenufm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                getcurrent().getMPicture1().setFontsize(10);
            }
        });
        jMenufsm.add(jMenufm1);

        jMenufm2.setText("20 point");
        jMenufm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getcurrent().getMPicture1().setFontsize(20);
            }
        });
        jMenufsm.add(jMenufm2);

        jMenufm3.setText("30 point");
        jMenufm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getcurrent().getMPicture1().setFontsize(30);
            }
        });
        jMenufsm.add(jMenufm3);
        jMenufm4.setText("40 point");
        jMenufm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                getcurrent().getMPicture1().setFontsize(40);
            }
        });
        jMenufsm.add(jMenufm4);

        jMenufm5.setText("50 point");
        jMenufm5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getcurrent().getMPicture1().setFontsize(50);
            }
        });
        jMenufsm.add(jMenufm5);

        jMenufm6.setText("60 point");
        jMenufm6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getcurrent().getMPicture1().setFontsize(60);
            }
        });
        jMenufsm.add(jMenufm6);
        jMenuFs.add(jMenufsm);
        menuBar.add(jMenuFs);
        setJMenuBar(menuBar);
        add(mainPanel);
        this.setVisible(true);
        this.setSize(575, 800);
    }
    //  File functions
    private void newAp(java.awt.event.ActionEvent evt) {
            try {
                newfile(false);
            } catch (IOException ex) {
                Logger.getLogger(JmpView.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void newfile (boolean open) throws IOException{
            try {
                numnewfiles++;
                Mfile temp = new Mfile(this, open, "Mathtype " +
                        java.lang.Integer.
                        toString(numnewfiles));
                temp.setVisible(true);

                app.add(temp, javax.swing.
                        JLayeredPane.DEFAULT_LAYER);
                files = new Mfilenode(temp, files);
                app.setSelectedFrame(temp);
                temp.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger("global").
                        log(Level.SEVERE, null, ex);
            }


    }
    private void openAp(java.awt.event.ActionEvent evt) {
            try {
                newfile(true);
            } catch (IOException ex) {
                Logger.getLogger(JmpView.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void read ()throws IOException{
                     try {
                numnewfiles++;
                Mfile temp = new Mfile(this);
                temp.setVisible(true);

                app.add(temp, javax.swing.
                        JLayeredPane.DEFAULT_LAYER);
                files = new Mfilenode(temp, files);
                app.setSelectedFrame(temp);
                temp.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger("global").
                        log(Level.SEVERE, null, ex);
            }
    }
    private void saveAp(java.awt.event.ActionEvent evt) {
            try {
                this.getcurrent().save();
            } catch (IOException ex) {
                Logger.getLogger(JmpView.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void exitAp(java.awt.event.ActionEvent evt) {
        savecurentkeyboards();
    }
    private void printMenuItemActionPerformed() {
            PrintUtilities.printComponent(
                    this.getcurrent().getMPicture1());
        }
    public Mfile getcurrent() {

            return (Mfile) app.getSelectedFrame();
        }

    // Edit functions
    private void jMenundoActionPerformed(java.awt.event.ActionEvent evt) {
        getcurrent().getMPicture1().undo();
    }
    private void jMenucutActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void jMenucopptActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    }
    private void jMenupasteActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    }
    //Keyboards fuctions
    private void addKbAp(java.awt.event.ActionEvent evt) {

                javax.swing.JFileChooser open =
                        new javax.swing.JFileChooser("./");
                if (open.showOpenDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                    java.io.File file = open.getSelectedFile();
                    addkeyboard(file);
            }

    }
    private void addkeyboard (File file){
        char c=file.getName().charAt(0);
        int n= (int)Character.toUpperCase(c);

               this.jmenueEitems.add(new Keyfile(file,true,this,n));
               this.jmenuechangeitems.add(new Keyfile(file,false,this,n));
               this.jMenueditkb.add(((Keyfile)jmenueEitems.lastElement()).getFileoption());
               this.jMenucjhange.add(((Keyfile)jmenuechangeitems.lastElement()).getFileoption());
    }
    public void getcurentkeyboards(){
        try{
            java.io.File file;
            javax.swing.JFileChooser open =
                        new javax.swing.JFileChooser();
                if (open.showOpenDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                     file = open.getSelectedFile();


                java.io.DataInputStream inputstream;
                inputstream = new DataInputStream(new FileInputStream(file));
                int num=inputstream.readInt();
                 for (int i = 0; i < num; i++) {
                    this.addkeyboard(new java.io.File(inputstream.readUTF()));
                }}

              } catch (IOException ex) {
                Logger.getLogger(
                        Keyboard.class.getName()).log(Level.SEVERE,
                        null, ex);
              }
        }
    private void jMenunkbActionPerformed(java.awt.event.ActionEvent evt) {

            javax.swing.JFileChooser open =
                        new javax.swing.JFileChooser("./");

                if (open.showSaveDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                    java.io.File file = open.getSelectedFile();

                    mathkeyboard1=new Keyboard ();
                    mathkeyboard1.setName(file);
                    mathkeyboard1.kbdefind.setVisible(true);
                    addkeyboard(file);
                }
    }
    public void savecurentkeyboards(){
         java.io.File file;
          javax.swing.JFileChooser open =
                        new javax.swing.JFileChooser();
                if (open.showSaveDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                     file = open.getSelectedFile();



              try {
                java.io.DataOutputStream outputstream;
                outputstream = new DataOutputStream(
                        new FileOutputStream(file));
                outputstream.writeInt(this.jmenueEitems.size());
                for (int i = 0; i < this.jmenueEitems.size(); i++) {
                    outputstream.writeUTF(((Keyfile)jmenueEitems.get(i)).getName().getPath());
                }
                outputstream.close();
            } catch (IOException ex) {
                Logger.getLogger(
                        Keyboard.class.getName()).log(Level.SEVERE,
                        null, ex);
            } }

    }
    public void editkb(File n){
        mathkeyboard1=new Keyboard (n);
        mathkeyboard1.kbdefind.setVisible(true);

    }
    public void changekeyb(File n){
        mathkeyboard.open(n);

    }
    public void changelayout (){
                 org.jdesktop.layout.GroupLayout
            jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add( mathkeyboard.jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .add(mathkeyboard.jToolBar2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .add(mathkeyboard.jToolBar3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .add(mathkeyboard.jToolBar4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel2Layout.createSequentialGroup()
                    .add(mathkeyboard.jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, depth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(mathkeyboard.jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, depth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(mathkeyboard.jToolBar3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, depth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(mathkeyboard.jToolBar4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, depth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            );


              org.jdesktop.layout.GroupLayout layout =
                    new org.jdesktop.layout.
                    GroupLayout(mainPanel);
            mainPanel.setLayout(layout);
            layout.setHorizontalGroup(layout.
                    createParallelGroup(
                    org.jdesktop.layout.
                    GroupLayout.LEADING).add(jPanel1,
                    org.jdesktop.layout.
                    GroupLayout.PREFERRED_SIZE, 900,
                    Short.MAX_VALUE).add(app,org.jdesktop.layout.
                    GroupLayout.DEFAULT_SIZE, 900,
                    Short.MAX_VALUE));
            layout.setVerticalGroup(layout.
                    createParallelGroup(
                    org.jdesktop.layout.
                    GroupLayout.LEADING)
                    .add(layout.createSequentialGroup().
                    add(jPanel1,
                    org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                    org.jdesktop.layout. GroupLayout.DEFAULT_SIZE,
                    org.jdesktop.layout.GroupLayout.
                    PREFERRED_SIZE).addPreferredGap(
                    org.jdesktop.layout.LayoutStyle.
                    RELATED).add(app,org.jdesktop.layout.
                    GroupLayout.DEFAULT_SIZE, 900,
                    Short.MAX_VALUE)));
    }
    //help functions
    public void showAboutBox() {
    }
}

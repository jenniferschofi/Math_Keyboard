package Jmp;
import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import jlatexmath.*;

/**
 * Gfile.java
 * @author jenniferschofield */
public class Mfile extends javax.swing.JInternalFrame {
    // This is the pannel where all the drawing gose
    private MPicture mPicture1;
    // This is the name of the file of the internal frame
    private File name;
    private JmpView owner;

    public Mfile(JmpView p,boolean open, String n) throws IOException {
        owner=p;
        initComponents();
        name = null;
        if (open){
            open();
        }else {
            this.setTitle(n);
        }
    }
        public Mfile(JmpView p) throws IOException {
        owner=p;
        initComponents();
        read();


    }
    @SuppressWarnings("unchecked")
    public void open() throws IOException {
          try {
                javax.swing.JFileChooser saveas =
                        new javax.swing.JFileChooser();
                if (saveas.showOpenDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                    java.io.File file = saveas.getSelectedFile();
                       name = file;
                      file.createNewFile();
                      this.setTitle(name.getName());
                }
            } catch (IOException ex) {
                Logger.getLogger("global").log(Level.SEVERE,
                        null, ex);
            }
        int t=0;
        int b;
        Vector <String> filelines=new Vector();
        try {

            initComponents();
            java.io.DataInputStream inputstream;
            inputstream = new DataInputStream(new FileInputStream(name));

            String temp=" ";
            //System.out.println(t);
            while (inputstream.available()>0){
               temp=inputstream.readLine();
                filelines.add(temp);
            }
            inputstream.close();
            this.setTitle(name.getName());
           // this.mPicture1.setLine(temp);
            this.mPicture1.setFilelines(filelines);
        } catch (FileNotFoundException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }

    public void read() throws IOException {
          try {
                javax.swing.JFileChooser saveas =
                        new javax.swing.JFileChooser();
                if (saveas.showOpenDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                    java.io.File file = saveas.getSelectedFile();
                       name = file;
                      file.createNewFile();
                      this.setTitle(name.getName());
                }
            } catch (IOException ex) {
                Logger.getLogger("global").log(Level.SEVERE,
                        null, ex);
            }
        int t=0;
        int b;
        Vector <Box> filelines=new Vector();

        TeXFormula formula;
        formula = new TeXFormula("");
        try {

            initComponents();
            java.io.DataInputStream inputstream;
            inputstream = new DataInputStream(new FileInputStream(name));

            String temp=" ";
            //System.out.println(t);
            while (inputstream.available()>0){
               temp=inputstream.readLine();

                formula.setLaTeX(temp);
                filelines.add(formula.createBox( new TeXEnvironment(TeXConstants.STYLE_DISPLAY, new DefaultTeXFont(20))));
            }
            inputstream.close();
            this.setTitle(name.getName());
           // this.mPicture1.setLine(temp);
            this.mPicture1.setLines(filelines);
        } catch (FileNotFoundException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }
    
    private void initComponents() {
        mPicture1 = new MPicture();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        this.mPicture1.setOpaque(true);
        this.setContentPane(this.mPicture1);
        pack();
    }    
    public void save() throws IOException {
        if (name == null){
             try {
                javax.swing.JFileChooser saveas =
                        new javax.swing.JFileChooser();
                if (saveas.showSaveDialog(this) ==
                        javax.swing.JFileChooser.APPROVE_OPTION) {
                    java.io.File file = saveas.getSelectedFile();
                       name = file;
                      file.createNewFile();
                      this.setTitle(name.getName());
                }
            } catch (IOException ex) {
                Logger.getLogger("global").log(Level.SEVERE,
                        null, ex);
            }
        }
       try {
            java.io.DataOutputStream outputstream;
            outputstream = new DataOutputStream(new FileOutputStream(name));
            outputstream.writeChars(mPicture1.text);
            outputstream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }
    public void saveas(File n) throws IOException {
        name = n;
        n.createNewFile();
        this.setTitle(name.getName());
        this.save();
    }
    public File getname() {
        return name;
    }
    public void setname(File name) {
        this.name = name;
    }
    public MPicture getMPicture1() {
        return mPicture1;
    }

    public void setGPicture1(MPicture gPicture1) {
        this.mPicture1 = gPicture1;
    }
}

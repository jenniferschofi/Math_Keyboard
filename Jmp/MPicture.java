package Jmp;
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;
import jlatexmath.*;
import javax.swing.JScrollPane;

import java.awt.print.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class MPicture extends JPanel {
    
    public static float magFactor = 0;
    TeXFormula formula;
    public Box box;
    Vector<Box> lines;
    int linescount;
    private String line;
    public String text;
    private Stack ws;
    private  Vector<String> filelines;
    private int flc=0;
    private float h=0;
    public float fontsize=20;

    public Insets insets = new Insets(20, 20, 20, 20);

    private Color fg = new Color(0, 0, 0);
    private float pages=2;
    public boolean isColored = false;
    private Matrix matrix;
//    public javax.swing.JTextField tf=new javax.swing.JTextField();
//    public javax.swing.JButton cb=new javax.swing.JButton("Change");
    private Dimension area;
    DrawingPane panel;
    public String getLine() {
        return line;
    }
    public void setLine(String line) {
        this.line = line;
       ws.push(line);
    }
    public Vector<String> getFilelines() {
        return filelines;
    }
    public void setFilelines(Vector <String> filelines) {
        this.filelines = filelines;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public float getFontsize() {
        return fontsize;
    }
    public void setFontsize(float fontsize) {
        this.fontsize = fontsize;
        repaint();
    }
    public float getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public Box getBox() {
        return box;
    }
    public void setBox(Box box) {
        this.box = box;
    }
    public Vector<Box> getLines() {
        return lines;
    }
    public void setLines(Vector<Box> lines) {
        this.lines = lines;
        this.linescount=lines.size();
    }


    public MPicture() {
        super(new BorderLayout());
//            cb.setEnabled(false);
//           cb.addActionListener(new java.awt.event.ActionListener() {

//            public void actionPerformed(
//                    java.awt.event.ActionEvent evt) {
//                line=tf.getText();
//                formula.setLaTeX(line);
//                box=formula.createBox( new TeXEnvironment(TeXConstants.STYLE_DISPLAY, new DefaultTeXFont(fontsize)));
//                panel.repaint();
//                ws.push(line);
//                tf.setEnabled(false);
//                cb.setEnabled(false);
//            }  });

        line="?";
//        tf.setText(line);
//        tf.setEnabled(false);
//        tf.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                tf.setEnabled(true);
//                cb.setEnabled(true);
//            }
//        });
        area = new Dimension(550, 1800);
        formula = new TeXFormula(line);
        lines=new Vector<Box> ();
        linescount=0;
        text="";
        matrix=new Matrix();
        formula.setLaTeX(line);
        box=formula.createBox( new TeXEnvironment(TeXConstants.STYLE_DISPLAY, new DefaultTeXFont(fontsize)));
        panel=new DrawingPane();
        panel.setBackground(Color.white);
        JScrollPane scroller = new JScrollPane(panel);
        panel.setPreferredSize( new Dimension(800, 1800));
        
        add(scroller, BorderLayout.CENTER);
       
        ws=new Stack();
        ws.push(line);

    }
    public void draw(String s){
       if (s.compareTo(" ")==0){
           line= line.substring(0,line.indexOf("?"))+line.substring(line.indexOf("?")+1);
       }else if(s.compareTo("return")==0){
            lines.add(box);
            linescount+=1;
            text=text+"\n"+line;
            line="?";
            ws=new Stack();
            ws.push(line);
       }else if (s.compareTo("matrix1")==0){

           line= line.substring(0,line.indexOf("?"))+matrix.showmatrix()+line.substring(line.indexOf("?"));
       }else if (s.compareTo("read")==0){
           if (this.filelines!=null){
           if (flc<this.filelines.size())
           line= line.substring(0,line.indexOf("?"))+this.filelines.elementAt(flc).toString()+line.substring(line.indexOf("?"));
           flc+=1;
       }}
           else {
           line= line.substring(0,line.indexOf("?"))+s+line.substring(line.indexOf("?"));
        }

        formula.setLaTeX(line);
        box=formula.createBox( new TeXEnvironment(TeXConstants.STYLE_DISPLAY, new DefaultTeXFont(fontsize)));
        panel.repaint();
        ws.push(line);

    }
    public void undo(){
           ws.pop();
           line=ws.peek().toString();

        formula.setLaTeX(line);
        box=formula.createBox( new TeXEnvironment(TeXConstants.STYLE_DISPLAY, new DefaultTeXFont(fontsize)));
        panel.repaint();
    }

    public void printpict (Graphics g,PageFormat pageFormat, int pageIndex){
        System.out.println();
        g.setColor(Color.BLACK);
            Graphics2D g2 = (Graphics2D) g;
        g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	// copy graphics settings
	RenderingHints oldHints = g2.getRenderingHints();
	AffineTransform oldAt = g2.getTransform();
	Color oldColor = g2.getColor();

	// new settings
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setRenderingHint(RenderingHints.KEY_RENDERING,
			    RenderingHints.VALUE_RENDER_QUALITY);
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
			    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.scale(fontsize,fontsize); // the point size
        float ph=0;
	// draw formula box9
        for (int i = 0; i < linescount; i++) {
            ph+=lines.get(i).getHeight();
            if (( insets.top) / fontsize+ph-700/fontsize*pageIndex<700/fontsize){
                 lines.get(i).draw(g2, ( insets.left) / fontsize,
                    ( insets.top) / fontsize+ph-700/fontsize*pageIndex);
            }
         else {

            System.out.println(i);
               ph=700/fontsize*(pageIndex+1)+lines.get(i).getHeight()+ ( insets.top) / fontsize;
            }
            
            ph+=lines.get(i).getHeight();
        }
	box.draw(g2, ( insets.left) / fontsize, 
           ( insets.top) / fontsize+ph+ box.getHeight()-700/fontsize*pageIndex);
           pages=( ( insets.top) / fontsize+ph+ box.getHeight())*fontsize/700;
           
	// restore graphics settings
	g2.setRenderingHints(oldHints);
	g2.setTransform(oldAt);
	g2.setColor(oldColor);


    }


    public class DrawingPane extends javax.swing.JPanel {

        public DrawingPane() {

        setFocusTraversalKeysEnabled(false);
        }

         @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);

            Graphics2D g2 = (Graphics2D) g;
	// copy graphics settings
	RenderingHints oldHints = g2.getRenderingHints();
	AffineTransform oldAt = g2.getTransform();
	Color oldColor = g2.getColor();
	// new settings
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setRenderingHint(RenderingHints.KEY_RENDERING,
			    RenderingHints.VALUE_RENDER_QUALITY);
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
			    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.scale(fontsize,fontsize); // the point size
        h=0;
	// draw formula box9
        for (int i = 0; i < linescount; i++) {
            h+=lines.get(i).getHeight();
            lines.get(i).draw(g2, ( insets.left) / fontsize, ( insets.top) / fontsize+h);;
            h+=lines.get(i).getHeight();
        }
	box.draw(g2, ( insets.left) / fontsize, ( insets.top) / fontsize+h+ box.getHeight());

	// restore graphics settings
	g2.setRenderingHints(oldHints);
	g2.setTransform(oldAt);
	g2.setColor(oldColor);

        }
    }
}

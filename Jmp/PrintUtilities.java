package Jmp;

import java.awt.*;
import java.awt.print.*;
import java.awt.geom.AffineTransform;

/**
 * 
 * @author Jennifer Schofield
 */
public class PrintUtilities implements Printable {
  private MPicture mPicture;

  /**
   * The begining of the process to print
   * @param c is the pricture
   * that will be printed
   */
  public static void printComponent(MPicture c) {
    new PrintUtilities(c).print();
  }
  
  /**
   * 
   * @param gpicture
   */
  public PrintUtilities(MPicture gpicture) {
    this.mPicture = gpicture;
  }
  
  /**
   * Brings up the print dialog so that print features can be chosen
   */
  public void print() {
    PrinterJob printJob = PrinterJob.getPrinterJob();
    printJob.setPrintable(this);
    if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException pe) {
               
            }
        }
  }

  /**
   * This function describes how to print 1 page oof the mpricture
   * @param g   is the graphics set to the printer to be printed
   * @param pageFormat  
   * @param pageIndex   tells what page you are on
   * @return
   */
  public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
       if (pageIndex > this.mPicture.getPages()) {
         return(NO_SUCH_PAGE);
       }
      else {

           mPicture.printpict(g, pageFormat,  pageIndex);
        return(PAGE_EXISTS);
        }}
  
}
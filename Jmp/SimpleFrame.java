package Jmp;
import java.awt.Frame;

import java.awt.Event;

public class SimpleFrame extends Frame
{


	public boolean keyDown( Event e , int key ) {

		System.out.println( "Key pressed = " + java.awt.event.KeyEvent.VK_TAB );

		return true;

	}


	public static void main( String args[] ) throws InterruptedException
{

    SimpleFrame frame=new SimpleFrame();
    frame.setFocusTraversalKeysEnabled(false);
    frame.setVisible(true);

	}

}
/*
 * PinSetterView/.java
 *
 * Version:
 *   $Id$
 *
 * Revision:
 *   $Log$
 */

/**
 *  constructs a prototype PinSetter GUI
 *
 */

import java.awt.*;
import java.awt.event.*;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import java.util.Vector;


public class PinSetterView implements PinsetterObserver {


    private Vector pinVect = new Vector ( );
    private JPanel firstRoll;
    private JPanel secondRoll;

    /**
     * Constructs a Pin Setter GUI displaying which roll it is with
     * yellow boxes along the top (1 box for first roll, 2 boxes for second)
     * and displays the pins as numbers in this format:
     *
     *                7   8   9   10
     *                  4   5   6
     *                    2   3
     *                      1
     *
     */
    

	private JFrame frame;
    
    public PinSetterView ( int laneNum ) {
	
	frame = new JFrame ( "Lane " + laneNum + ":" );
	
	Container cpanel = frame.getContentPane ( );
	
	JPanel pins = new JPanel ( );
	
	pins.setLayout ( new GridLayout ( 4, 7 ) );
	
	//********************Top of GUI indicates first or second roll
	
	JPanel top = new JPanel ( );
	
	firstRoll = new JPanel ( );
	firstRoll.setBackground( Color.yellow );
	
	secondRoll = new JPanel ( );
	secondRoll.setBackground ( Color.black );
	
	top.add ( firstRoll, BorderLayout.WEST );
	
	top.add ( secondRoll, BorderLayout.EAST );

	// NEW CODE
	pinVect = setUpPinGrid();

	setUpPins(pinVect, pins);

	// END NEW

	top.setBackground ( Color.black );
	
	cpanel.add ( top, BorderLayout.NORTH );
	
	pins.setBackground ( Color.black );
	pins.setForeground ( Color.yellow );
	
	cpanel.add ( pins, BorderLayout.CENTER );
	
	frame.pack();
	
	
//	frame.show();
    }
    
    
    /**
     * This method receives a pinsetter event.  The event is the current
     * state of the PinSetter and the method changes how the GUI looks
     * accordingly.  When pins are "knocked down" the corresponding label
     * is grayed out.  When it is the second roll, it is indicated by the
     * appearance of a second yellow box at the top.
     *
     * @param pe    The state of the pinsetter is sent in this event.
     */
    

    public void receivePinsetterEvent(PinsetterEvent pe){
	if ( !(pe.isFoulCommited()) ) {
	    	JLabel tempPin = new JLabel ( );
	    	for ( int c = 0; c < 10; c++ ) {
				boolean pin = pe.pinKnockedDown ( c );
				tempPin = (JLabel)pinVect.get ( c );
				if ( pin ) {
		    		tempPin.setForeground ( Color.lightGray );
				}
	    	}
    	}
		if ( pe.getThrowNumber() == 1 ) {
	   		 secondRoll.setBackground ( Color.yellow );
		}
	if ( pe.pinsDownOnThisThrow() == -1) {
		for ( int i = 0; i != 10; i++){
			((JLabel)pinVect.get(i)).setForeground(Color.black);
		}
		secondRoll.setBackground( Color.black);
	}
    }
    
    public void show() {
    	frame.show();
    }

    public void hide() {
    	frame.hide();
    }
    
    public static void main ( String args [ ] ) {
		PinSetterView pg = new PinSetterView ( 1 );
    }

    private Vector setUpPinGrid() {
    	Vector pinVect = new Vector();
    	for (int i = 1; i <= 10; i++) {
    		pinVect.add(new JLabel(String.valueOf(i)));
			}
    	return pinVect;
		}

		private void setUpPins(Vector pinVect, JPanel pins) {
    	String[][] layout = new String[][] {
					{"7", "jp", "8", "jp", "9", "jp", "10"},
					{"jp", "4", "jp", "5", "jp", "6", "jp"},
					{"jp", "jp", "2", "jp", "3", "jp", "jp"},
					{"jp", "jp", "jp", "1", "jp", "jp", "jp"}
			};

    	for (String[] row: layout) {
    		for (String item: row) {
    			if (item.equals("jp")) {
    				pins.add(new JPanel());
					} else {
    				JLabel current = (JLabel) pinVect.get(Integer.valueOf(item) - 1);
    				JPanel panel = new JPanel();
    				panel.add(current);
    				pins.add(panel);
					}
				}
			}

		}
    
}

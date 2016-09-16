package main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends javax.swing.JFrame {
	
    /**
	 IDK what this does eclipse told me to put it in for some reason
	 */
	private static final long serialVersionUID = 1L;
	ArduinoMain comm = null;
    
    public GUI() {
        initComponents();
        createObjects();
        comm.initialize();
    }
	
    private void createObjects()
    {
        comm = new ArduinoMain(this);
    }
    
    //Initializes gui componenets
    private void initComponents() {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setResizable(false);

    }
    
    //creates GUI and sets to visable
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
           }
        });
    }
		
}

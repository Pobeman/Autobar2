package main;

import java.awt.*;
import java.util.ArrayList;

public class GUI extends javax.swing.JFrame {
	
    /**
	 IDK what this does eclipse told me to put it in for some reason
	 */
	private static final long serialVersionUID = 1L;
	Communication comm = null;
    
    public GUI() {
        initComponents();
        createObjects();
    	//comm.initialize();
    }
	
    private void createObjects()
    {
        //comm = new Communication(this);
    }
    
    //Initializes gui componenets
    private void initComponents() {
    	
		setSize(455,356);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		ArrayList<Drink> drinks=ImportFiles.drinkImport();
		        
		int totalDrinks = drinks.size();
		    
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
			
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.weighty = 2;
		c.weightx = 0;
		c.gridwidth = 1;
		c.ipady = 20;
		c.ipadx = 20;
		c.insets = new Insets(0,10,0,10);
			
		for (int i=0; i<totalDrinks; i++) {
			c.gridy = i;
		    this.add(drinks.get(i).drinkSelection, c);
		}
			
		c.gridx = 1;
		c.weightx = 2;
		c.gridwidth = 1;
		c.ipady = 20;
		c.insets = new Insets(0,0,0,0);
			
		for (int i=0; i<totalDrinks; i++) {
			c.gridy = i;
		    this.add(drinks.get(i).drinkTextArea(), c);
		}
		    
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

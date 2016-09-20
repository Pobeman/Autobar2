package main;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

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
    	
		setSize(455,356);
		setLocationRelativeTo(null);
		setResizable(false);
		
		GroupLayout layout = new GroupLayout(this);
		//setLayout(layout);
		
		//buttonLayout.setVgap(50);
		layout.setAutoCreateGaps(true);
		
		
		String buttonText[] = {
				"Margarita",
				"Vodka and cranberry",
				"Moscow Mule",
				"Mojito",
				"Martini",
				"Set valves"
		};
		
		JButton buttons[] ={
				new JButton("Margarita"),
				new JButton(),
				new JButton(),
				new JButton(),
				new JButton(),
				new JButton(),
		};
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addComponent(buttons[1],GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
				.addComponent(buttons[2])
				.addComponent(buttons[3])
				.addComponent(buttons[4])
		);
		//for (int i = 0; i<6;i++) {
			//buttonLayout.addLayoutComponent(buttonText[i], buttons[i]);
		//}
		
		
		
		//add(buttonLayout);
		
    	/*		
    	JButton btnNewButton = new JButton();
   		btnNewButton.setBounds(10, 10, 123, 44);
   		btnNewButton.setText("Margarita");
   		add(btnNewButton);
    			
   		JButton btnVodkaAndCranberry = new JButton();
    	btnVodkaAndCranberry.setText("Vodka and cranberry");
    	btnVodkaAndCranberry.setBounds(10, 63, 123, 44);
    	add(btnVodkaAndCranberry);
    			
    	JButton btnMoscowMule = new JButton();
    	btnMoscowMule.setText("Moscow Mule");
    	btnMoscowMule.setBounds(10, 116, 123, 44);
    	add(btnMoscowMule);
    	
    	JButton btnMojito = new JButton();
    	btnMojito.setText("Mojito");
    	btnMojito.setBounds(10, 169, 123, 44);
    	add(btnMojito);
    			
    	JButton btnMartini = new JButton();
    	btnMartini.setText("Martini");
    	btnMartini.setBounds(10, 222, 123, 44);
    	add(btnMartini);
    			
    	JButton btnSetValves = new JButton();
    	btnSetValves.setText("Set valves");
    	btnSetValves.setBounds(10, 275, 123, 44);
    	add(btnSetValves);
    	*/
		/*
    	JTextArea marg = new JTextArea();
    	JTextArea vodkaCran = new JTextArea();
    	JTextArea moscowMule = new JTextArea();
    	JTextArea mojito = new JTextArea();
    	JTextArea martini = new JTextArea();
    	JTextArea settings = new JTextArea();
    	
    	JTextArea txtAreas[] = {
    			marg,
    			vodkaCran,
    			moscowMule,
    			mojito,
    			martini,
    			settings
    	};
    	
    	String label[] = {
    		"50 mL Tequila,25 mL lime juice, 25 mL TripleSec, 100 mL Simple Syrup",
    		"50 mL Vodka, 100 mL cranberry juice",
    		"50 mL Vodka, 15 mL Lime juice, 125 mL ginger beer",
    		"50 mL rum, 125 mL club soda",
    		"30 mL Vermouth, 120 mL Gin",
    		"Bring up the menu to set which valve each drink is located at"
    	};
    	
    	//x,y,width,height
    	int pos[][] = {
    		{139,10,301,44},
    		{139,63,301,44},
    		{139,116,301,44},
    		{139,169,301,44},
    		{139,222,301,44},
    		{139,275,301,44}
    	};
    	
    	addTextLabels(txtAreas,label,pos,this,6);
    	    			
    	//JTextArea txtVodkaAndCranberry = new JTextArea();
    	txtVodkaAndCranberry.setLineWrap(true);
    	txtVodkaAndCranberry.setBorder(border);
    	txtVodkaAndCranberry.setText("50 mL Vodka, 100 mL cranberry juice");
    	//txtVodkaAndCranberry.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
    	txtVodkaAndCranberry.setLocation(139, 44);
    	txtVodkaAndCranberry.setSize(139, 63);
    	add(txtVodkaAndCranberry);
    	*/
    }
    
    //creates GUI and sets to visable
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
           }
        });
    }
    public static void addTextLabels(JTextArea textAreas[],String text[], int bounds[][],GUI gui,int amount) {
    	
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
    	for (int i=0; i<amount; i++) {
    		textAreas[i].setLineWrap(true);
    		textAreas[i].setBorder(border);
    		textAreas[i].setText(text[i]);
    		textAreas[i].setBounds(bounds[i][0],bounds[i][1],bounds[i][2],bounds[i][3]);
        	gui.add(textAreas[i]);
    		
    	}        	
    }
}

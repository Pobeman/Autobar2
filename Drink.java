package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Drink implements ActionListener{
	int amount;
	String name,description;
	String alcoholTypes[] = new String[amount];
	int alcoholAmounts[] = new int[amount];
	int valves[] = new int[amount];
	JButton drinkButton = new JButton(name);
	public JTextArea drinkDesc = new JTextArea(description);
	public JPanel drinkSelection = new JPanel();
	
	public Drink () {
		this.amount = 0;
		this.name = "";
		this.description = "";
		this.alcoholTypes= null;
		this.alcoholAmounts= null;
		this.valves = null;
		this.drinkButton.setText("");
		this.drinkDesc.setText("");
		this.drinkDesc.setLineWrap(true);
		this.drinkButton.addActionListener(this);
		this.drinkSelection.setBackground(Color.BLACK);
	}
	
	public String drinkName() {
		return(this.name);
	}
	
	public String drinkDesc() {
		return(this.description);
	}
	
	public String[] alcoholTypes() {
		return(this.alcoholTypes);
	}
	
	public String alcoholTypes(int index) {
		return(this.alcoholTypes[index]);
	}
	
	public int[] drinkAmounts() {
		return(this.alcoholAmounts);
	}
	
	public int drinkAmounts(int index) {
		return(this.alcoholAmounts[index]);
	}
	
	public int drinkAmount() {
		return(this.amount);
	}
	
	public JButton drinkButton() {
		return(this.drinkButton);
	}
	
	public JTextArea drinkTextArea() {
		return(this.drinkDesc);
	}
	
	public void setButtonText(String name) {
		this.drinkButton.setText(name);
	}
	
	public void setDescText(String desc) {
		this.drinkDesc.setText(desc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			//System.out.println(this.alcoholAmounts[i]);
		if (Communication.inputByte == 0) {
			try {
				Communication.output.write(this.amount);
				for (int i = 0;i<this.amount;i++) {
					Communication.output.write(this.valves[i]);
					Communication.output.write(this.alcoholAmounts[i]);
				}
			} catch (IOException e1) {
				//TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
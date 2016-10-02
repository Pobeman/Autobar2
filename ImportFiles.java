package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportFiles {
	
	public static ArrayList<Drink> drinkImport() {
		
		String file = "C:\\Users\\dorci\\workspace\\Autobar\\src\\drinkFiles.csv";
	
		//variables used by the file processor
		BufferedReader br = null;
		String cvsSplitBy = ",";
		String line = "";
		String[] data;
		int i,drinkSize,drinkPos = 0;
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		Drink drink;		
		
		try {

			br = new BufferedReader(new FileReader(file));
			
			//Reads first line which only contains headers
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
					
			// use comma as separator
            data = line.split(cvsSplitBy);
            
            //set the name and description of the drink from the first two columns or the row
            drink = new Drink();
    		int[] drinkAmounts = new int[10];
    		String[] drinkTypes = new String[10];
    		
    		//sets name and desc for drink type from first two columns
            drink.name = data[0];
            drink.setButtonText(drink.name);
            drink.description = data[1];
            drink.setDescText(drink.description);
            
            //determines the number of entries in the row for determining how many types of alcohol are used in this drink
            drinkSize = data.length;
           
            //Initializes tracking indices for loop
            i = 3;
            drinkPos = 0;
            while (i<drinkSize+1) {
            	//assumes that mL values are on even indices of the line, adds them to the variables
            	if (i%2 == 0) {
            		drinkAmounts[drinkPos]=Integer.parseInt(data[i-1]);
            		drinkPos++;
            	} else {
            		drinkTypes[drinkPos] = data[i-1];
            	}
            	i++;
            }
            
            //stores rest of the data to the drink object
            drink.amount = drinkPos--;
            drink.alcoholTypes=drinkTypes;
            drink.alcoholAmounts=drinkAmounts;
            
            //adds current drink to array
            drinks.add(drink);
            
            //resets drink info storing variables, allows variables to be deleted later
            drink = null;
            drinkTypes = null;
            drinkAmounts = null;
        }
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		valveImport(drinks);
		return(drinks);
	}
	
	public static void valveImport(ArrayList<Drink> drinks) {
		
		String file = "C:\\Users\\dorci\\workspace\\Autobar\\src\\valveList.csv";

		//variables used by file processor
		BufferedReader br = null;
		String cvsSplitBy = ",";
		String line = "";
		String[] data;
		String[] drinkList = new String[18];
		int total = drinks.size();
		int i=0; 

		try {
			
			br = new BufferedReader(new FileReader(file));
			
			//Reads first line which only contains headers
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
					
				// use comma as separator
				data = line.split(cvsSplitBy);
            
				if (data.length>1) {
					drinkList[i] = data[1];
				}
				
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		for (i = 0;i<total;i++) {
			int drinkSize = drinks.get(i).amount;
			int[] valve = new int[drinkSize];
			System.out.println();
			for (int j = 0;j<drinkSize;j++) {
				for (int k = 0; k<18;k++) {
					if (drinks.get(i).alcoholTypes[j].equals(drinkList[k])) {
						valve[j]=k;
					}
				}
			}
			drinks.get(i).valves=valve;
			valve = null;
		}
	}
}

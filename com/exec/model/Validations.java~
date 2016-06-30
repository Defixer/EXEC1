package com.exec.model;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Validations{

	private Scanner sc = new Scanner(System.in);

	public int isInputMismatch(String excepFlag, String flagId){
		int integerValue = 0;
		boolean inputMismatch = false;
		
		if(excepFlag.equalsIgnoreCase("rows") | excepFlag.equalsIgnoreCase("cols") 
		| excepFlag.equalsIgnoreCase("rowIndex") | excepFlag.equalsIgnoreCase("colIndex")){
		
			do{
				inputMismatch = false;
				
				if(flagId.equalsIgnoreCase("rows")){
					System.out.print("\tNumber of rows\t : ");
				}
				else if(flagId.equalsIgnoreCase("cols")){
					System.out.print("\tNumber of columns: ");
				}
				else if(flagId.equalsIgnoreCase("rowIndex")){
					System.out.print("Input row index : ");
				}
				else if(flagId.equalsIgnoreCase("colIndex")){
					System.out.print("Input column index : ");
				}
				try{
					int tempIntegerValue = sc.nextInt();
					integerValue = tempIntegerValue;			
				}
				catch(InputMismatchException ime){
					System.out.println("Invalid Input Format\n");
					sc.nextLine();
					inputMismatch = true;
				}
			}while(inputMismatch);			
		}
		else if(excepFlag.equalsIgnoreCase("menu")){
			do{
				inputMismatch = false;
				try{
					System.out.print("Enter choice: ");
					int tempIntegerValue = sc.nextInt();
					integerValue = tempIntegerValue;		
				}
				catch(InputMismatchException ime){
					System.out.println("Invalid Input Format\n");
					sc.nextLine();
					inputMismatch = true;		
					continue;			
				}
				if(integerValue<=0 && integerValue>5){
					System.out.println("Invalid Menu Input\n");
					inputMismatch = true;
				}					
			}while(inputMismatch);					
		}
		
		return integerValue;
		
	}
	
	public boolean isInvalid(String excepFlag, String tempStr){
		if(excepFlag.equalsIgnoreCase("search")){
			if(tempStr.length()<=0 || tempStr.length()>3){
				System.out.println("Input not within range\n");
				return true;			
			}
			return false;
		}
		else if(excepFlag.equalsIgnoreCase("edit")){
			if(tempStr.length()!=3){
				System.out.println("Input not within range\n");
				return true;
			
			}
		}
		return false;		
	}
	
	public boolean isInvalid(String excepFlag, int excepValue){
		
		if(excepFlag.equalsIgnoreCase("menu") & excepValue==0){
			if(excepValue<1 || excepValue>5){
				System.out.println("Invalid Menu Input\n");
				return true;
			}		
		}
		else if(excepFlag.equalsIgnoreCase("rows")){
			if(excepValue<=0){
				System.out.println("\tInvalid Row Input\n");
				return true;
			}
		}
		else if(excepFlag.equalsIgnoreCase("cols")){
			if(excepValue<=0){
				System.out.println("\tInvalid Column Input\n");
				return true;
			}
		}
		return false;		
	}
	
	public boolean isInvalid(String excepFlag, int excepValue,int rows, int cols){
		if(excepFlag.equalsIgnoreCase("rowIndex")){
			if(excepValue>rows-1){
				System.out.println("Invalid row Index. Max row index is "+(rows-1)+"\n");
				return true;
			}
			
			else if(excepValue<0){
				System.out.println("Invalid row Index. Min row index is 0\n");
				return true;
			}		
		}
		
		else if(excepFlag.equalsIgnoreCase("colIndex")){
			if(excepValue>cols-1){
				System.out.println("Invalid column Index. Max column index is "+(cols-1)+"\n");
				return true;
			}
			
			else if(excepValue<0){
				System.out.println("Invalid column Index. Min column index is 0\n");
				return true;
			}
		}		
		
		return false;
	}	
}

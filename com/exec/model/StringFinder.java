package com.exec.model;

import java.util.Scanner;
import com.exec.model.Validations;
import java.util.Random;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
public class StringFinder{

	private static Scanner sc = new Scanner(System.in);
		
	public int inputDimensions(String dimensionType, String dimensionID, Validations val, int rows, int cols){
		boolean indexInputInvalid = false;
		int dimensionValue = 0;
		
		do{
			indexInputInvalid = false;
			
			dimensionValue = val.isInputMismatch(dimensionType,dimensionID);
			if(dimensionType.equalsIgnoreCase("rows") | dimensionType.equalsIgnoreCase("cols")){
				indexInputInvalid = val.isInvalid(dimensionType,dimensionValue);				
			}
			else if(dimensionType.equalsIgnoreCase("rowIndex") | dimensionType.equalsIgnoreCase("colIndex")){
				indexInputInvalid = val.isInvalid(dimensionType,dimensionValue,rows,cols);				
			}
			
		}while(indexInputInvalid);
		
		return dimensionValue;
	}

	public void menuChoices(int rows, int cols){
		System.out.print("\nRows: "+rows+"\tColumns: "+cols);
		System.out.println("\n====================================== ");
		System.out.println("[1] search");
		System.out.println("[2] edit");
		System.out.println("[3] print");
		System.out.println("[4] reset");
		System.out.println("[5] Exit");

	}

	public void menu(int rows,int cols,String[][] randStrArr,Validations val){
		boolean menuInput = false, switchInput = true;	
		int menuChoice = 0;
		
		String[][] newRandStrArr = new String[rows][cols];

		menuChoices(rows,cols);		
		
		//OOP
		do{
			do{
				menuInput = false;
			
				int tempMenuChoice = val.isInputMismatch("menu","menu");			
			
				menuInput = val.isInvalid("menu",tempMenuChoice);
			
				menuChoice = tempMenuChoice;
			}while(menuInput);
			
			switch(menuChoice){
			case 1: //SearCh	
				search(rows,cols,randStrArr,val);
				display(rows,cols,randStrArr);
				break;
			case 2: //edit
				randStrArr = edit(rows,cols,randStrArr,val);
				display(rows,cols,randStrArr);
				break;
			case 3:	//print
				display(rows,cols,randStrArr);
				break;
			case 4: //reset
				randStrArr = reset(rows,cols);
				display(rows,cols,randStrArr);
				break;
			case 5: //Exit
				switchInput = false;
				break;
			default:
				break;
			}						
			System.out.println();	
		}while(switchInput);
	}
	
	public void display(int rows, int cols, String[][] randStrArr){
		print(rows,cols,randStrArr);
		menuChoices(rows,cols);	
	}

	public void search(int rows,int cols,String[][] randStrArr, Validations val){
		String searchStr = "";
		boolean searchInput = false;
		int fromIndex=0, searchStrCtr=0, searchStrOccur = 0;
				
		//OOP
		do{
			searchInput = false;
			System.out.print("Enter string to be searched: ");
			String tempSearchStr = sc.nextLine();
			searchInput = val.isInvalid("search",tempSearchStr);		
			searchStr = tempSearchStr;
		}while(searchInput);
		
		System.out.println("Occurrence/s of '"+searchStr+"' \n\tfound at:");
		for(int rowCtr=0; rowCtr<rows; rowCtr++){
			for(int colCtr=0; colCtr<cols; colCtr++){
				fromIndex = 0;
				searchStrCtr = 0;

				while(fromIndex!=-1){
					
					fromIndex = randStrArr[rowCtr][colCtr].indexOf(searchStr,fromIndex);
					
					if(fromIndex!=-1){
						searchStrCtr++;
						fromIndex += searchStr.length();
						searchStrOccur++;
					}					
				}
				
				if(searchStrCtr>0){
					System.out.println("\t\t["+rowCtr+","+colCtr+"]");
				}
			}
		}
		System.out.println("Total occurence:  "+searchStrOccur);		
	}

	public String[][] edit(int rows, int cols, String[][] randStrArr, Validations val){
		boolean rowValue = false,colValue = false, editInput = false;
		int rowIndex=0, colIndex=0;
		String updateStr = "";
	
		//OOP
		rowIndex = inputDimensions("rowIndex","rowIndex",val,rows,cols);
		colIndex = inputDimensions("colIndex","colIndex",val,rows,cols);

		do{
			editInput = false;

			System.out.print("Enter String to be inputted in index ["+rowIndex+","+colIndex+"]: ");
			String tempUpdateStr = sc.next();
			editInput = val.isInvalid("edit",tempUpdateStr);
			updateStr = tempUpdateStr;
		}while(editInput);		
		
		System.out.println("String at ["+rowIndex+","+colIndex+"] \""+randStrArr[rowIndex][colIndex]+"\" -> \""+updateStr+"\"");
		randStrArr[rowIndex][colIndex] = updateStr;

		return randStrArr;
	}

	public void print(int rows, int cols, String[][] randStrArr){
		
			for(int colCtr = 0; colCtr<cols; colCtr++){
				if(colCtr==0){
					System.out.print("\n     "+colCtr+" "+" | ");
					continue;
				}
				
				if(colCtr<cols-1){
					if(colCtr>9){
						System.out.print(" "+colCtr+" | ");
					}
					
					else{
						System.out.print(" "+colCtr+" "+" | ");
					}				
				}
				
				else{
				
					System.out.print(" "+colCtr+" ");
				}	
			
			}

		System.out.println();		

		for(int rowCtr = 0; rowCtr<rows; rowCtr++){
			if(rowCtr<10){
				System.out.print(rowCtr+"   ");
			}
			
			else{
				System.out.print(rowCtr+"  ");
			}

			for(int colCtr = 0; colCtr<cols; colCtr++){			
				if(rowCtr<rows){
					System.out.print(randStrArr[rowCtr][colCtr]);
				}
				
				if(colCtr<cols-1){
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}
	
	public String[][] reset(int rows, int cols){
		
		final int ASCII_MIN = 32, ASCII_MAX = 126;
		int randNum = 0;
		char ch = 0;

		String[][] randStrArr  =  new String[rows][cols];
		Random rand  =  new Random();
		
		for(int rowCtr = 0; rowCtr<rows; rowCtr++){			
			for(int colCtr = 0; colCtr<cols; colCtr++){
				StringBuilder sb = new StringBuilder();
				int charCtr = 3;

				while(charCtr>0 & charCtr<=3){
				
					randNum = rand.nextInt((ASCII_MAX - ASCII_MIN)+1)+ASCII_MIN;

					ch = (char)randNum;				
					sb.append(ch);
					charCtr--;	
				}
				String randString = sb.toString();
				randStrArr[rowCtr][colCtr] = randString;	
			}
		}

		return randStrArr;
	}	
}

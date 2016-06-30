package com.exec.runtime;
import com.exec.model.StringFinder;
import com.exec.model.Validations;
public class StringFinderMain{
	public static void main(String[] args){
		int rows = 0,cols = 0;
		
		Validations val = new Validations();
		StringFinder sf = new StringFinder();

		System.out.println("\n/*Program generates a 2-D Array (Table Form) with 3 random ASCII Characters per cell customizable by menu options*/");
		System.out.println("\nTable Dimension Input");
		
		//OOP
		rows = sf.inputDimensions("rows","rows",val,rows,cols);
		cols = sf.inputDimensions("cols","cols",val,rows,cols);
			
		String[][] randStrArr = sf.reset(rows,cols);
		sf.menu(rows,cols,randStrArr,val);	
	}
}

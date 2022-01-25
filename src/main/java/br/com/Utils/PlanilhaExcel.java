package br.com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;





public class PlanilhaExcel {

	public PlanilhaExcel() {}
	
	 protected static int contTest;
	 private static final String fileName = System.getProperty("user.dir")+Driver.leitorProperties.getValor("planilhaMassa");
	 private static HSSFWorkbook workbook;
	 private static FileInputStream fileinput;
	 private static FileOutputStream fileOut;
	 private  static HSSFSheet mySheet;
	 private static  String[][] _Array;
	 private static Row row;
     private static Cell cell;
	 private static int celula= 0;
	 private static int linha= 0;
	 
	 public static int getContTest() {
		return contTest;
	 }
	 
	 public static void setContTest(int num) {
		contTest = num;
	 }
	 
	 private static Row getRow(int linha) {
		return row = mySheet.getRow(linha);	
	 }
	
	 private static Cell getCell(int celula) {
		return cell = row.getCell(celula);
	 }
	 
	 public static void  _CarregarPlanilhaExcel()  {
		 
		try {
			fileinput = new FileInputStream(new File(fileName));
             workbook = new HSSFWorkbook(fileinput);
             mySheet = workbook.getSheetAt(0);
             alimentarArrayExcel();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Erro ao criar objeto do Excel !!");

		} catch (IOException e) {
			throw new RuntimeException("Erro ao criar objeto Sheet Excel !!");
		} 
		fecharExcel();
		
	 }
	 
	 private static void fecharExcel() {
		 try {
			 fileinput.close();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao fechar o Excel !!");
		}
	 }
	 	
	 public static String  _lerExcelCelula(int linha, int celula) {

		 getRow(linha);
		 try {
			 getCell(celula);
					return cell.getStringCellValue();
				} catch (java.lang.NullPointerException e) {
					return null;
		}
			
	


	 }
	
     public static String _lerArrayExcel(int linha,int celula ) {
		
    	try {
    		 return  _Array[linha][celula];
		} catch (java.lang.ArrayIndexOutOfBoundsException  a) {
			throw new RuntimeException("Posição do ***_Array *** INVALIDA: "+a);
		}
		 
	 }
	     
     private static void alimentarArrayExcel()throws IOException {
		
    	 getRow(0);
    	 //monta array de string com a qtd de linhas e celulas da planilha
        _Array= new String[mySheet.getLastRowNum()+1][row.getLastCellNum()];
		
       //retorna todas as linhas preenchidas da planilha 
         java.util.Iterator<Row> rowIterator = mySheet.iterator();
       //varre todas as linhas preenchidas da planilha 
         while (rowIterator.hasNext()) {
        	//recebe cada linha preenchida da planilha
             Row row = rowIterator.next();
         
             //pegamos todas as celulas preenchidas desta linha
             java.util.Iterator<Cell> cellIterator = row.cellIterator();
	           //varremos todas as celulas da linha atual
             int cont=0;
             while (cont<row.getLastCellNum()) {
	            	
	            	 /// alimentar o array de 2 posições - com a String lida do excel            	
	            	try {
	            		_Array[linha][celula] = row.getCell(celula).toString(); //linha celula
	            		cell = cellIterator.next();
					} catch (Exception c) {
							//celula vazia = null
					}
	
	                 celula++;
	                 cont++;
	           }
	            linha++;
	            celula=0;
         }    
    }
	 
     public static void _escreverExcelCelula(int linha, int celula, String setTxt) {
    	 try {
    	  getRow(linha);
       	  getCell(celula);
    	 } catch (java.lang.NullPointerException ex) {
				throw new RuntimeException("***EXCEL*** ((Linha "+linha+ " = null))");
		 }
    	  

         if (!(cell == null)) {
        	 cell.setCellValue(setTxt);
         }else {
        	 cell = row.createCell(celula);
        	 cell.setCellValue(setTxt);
         }
         
 			try {
				fileOut = new FileOutputStream(fileName);
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException ex) {
				throw new RuntimeException("Erro ao Escrever no Excel !!");
			}
 		     
     }
     
     
     public static int _totalLinhasExcel() {
    	 return mySheet.getLastRowNum();
     }


}

package com.gointegro.Util;

import java.io.File;
import java.io.IOException;

import com.gointegro.Helpers.ConfigElementsRegistration;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WorkbookUtils {
	
	String nombre, apellido, mail, fechanac, documento,id;

	/**
	 * Obtener el nombre
	 * 
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtener el apellido
	 * 
	 * @return String
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Obtener el email
	 * 
	 * @return String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Obtener la fn
	 * 
	 * @return String
	 */
	public String getFechanac() {
		return fechanac;
	}

	/**
	 * Obtener el documento
	 * 
	 * @return String
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * Obtener el usernameid
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Leer el workbook
	 * 
	 * @param numRow
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readWorkbook(int numRow) throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File(ConfigElementsRegistration.getLocationXls()));
		Sheet sheet = workbook.getSheet(0);
	    int cols=sheet.getColumns();
	    for (int i = 0; i < cols; i++) {
	    	if(i == 0)
        		nombre = sheet.getCell(i,numRow).getContents();
        	else if (i==1)
        		apellido = sheet.getCell(i,numRow).getContents();
        	else if (i==2)
        		mail = sheet.getCell(i,numRow).getContents();
        	else if (i==3)
        		fechanac = sheet.getCell(i,numRow).getContents();
        	else if (i==4)
        		documento = sheet.getCell(i,numRow).getContents();
        	else if (i==5)
        		id = sheet.getCell(i,numRow).getContents();
		}
	}

}

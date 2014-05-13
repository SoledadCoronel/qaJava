package com.gointegro.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que contiene todos los metodos de manejo de fechas o que involucren Date o Calendar.
 * 
 * @author gustavomoreira
 *
 */
public class DateTool {
	
	/**
	 * Convierte un string de date con formato yyyy-MM-dd a formato dd/MM/yyyy
	 * 
	 * @param TodayViewDate
	 * @return String date in format dd/MM/yyyy
	 */
	public static String TimeFormatTodayViewDate(String TodayViewDate) {
		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "dd/MM/yyyy";
		
		String oldDataString = TodayViewDate;
		String newDateString;
		
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = null;
		try {
			d = sdf.parse(oldDataString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		return newDateString;
	}
	
	/**
	 * Obtiene el texto con el mes dependiendo el numero de mes
	 * Funciona en español
	 * 
	 * @param StringDate
	 * @return String
	 */
	public static String getMonthText(String StringDate) {
		
		String date = StringDate;
		String monthstr = date.split("/")[1];

		int month = Integer.parseInt(monthstr);
		String monthString = null;
		
		switch (month) {
			case 1:  monthString = "Enero";
			break;
			case 2:  monthString = "Febrero";
			break;
			case 3:  monthString = "Marzo";
			break;
			case 4:  monthString = "Abril";
			break;
			case 5:  monthString = "Mayo";
			break;
			case 6:  monthString = "Junio";
			break;
			case 7:  monthString = "Julio";
			break;
			case 8:  monthString = "Agosto";
			break;
			case 9:  monthString = "Septiembre";
			break;
			case 10: monthString = "Octubre";
			break;
			case 11: monthString = "Noviembre";
			break;
			case 12: monthString = "Diciembre";
			break;
			default: monthString = "Invalid month";
			break; 
		}
		return monthString;
	}
	
	/**
	 * Obtener el dia de un string
	 * 
	 * @param StringDate
	 * @return String
	 */
	public static String getDayText(String StringDate) {
		String date = StringDate;
		String daystr = date.split("/")[0];
		return daystr;
	}
	
	/**
	 * Obtener el año de un string
	 * 
	 * @param StringDate
	 * @return String
	 */
	public static String getYearText(String StringDate) {
		String date = StringDate;
		String yearstr = date.split("/")[2];
		return yearstr;
	}

}

package com.gointegro.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	/**
	 * Obtener la fecha de -3 dias
	 * 
	 * @return String
	 */
	public static String getYesterday() {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		cal.add(Calendar.DATE, -3);
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * Obtener la fecha actual -2 mes
	 * 
	 * @return String
	 */
	public static String setLastMonth() {
		int previousMonthInt = 0;
		int previousYearInt = 0;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String StringDate = dateFormat.format(cal.getTime());
		String date = StringDate;
		String daystr = date.split("/")[0];
		String monthstr = date.split("/")[1];
		String yearstr = date.split("/")[2];
		int month = Integer.parseInt(monthstr);
		previousMonthInt = month;
		previousYearInt = Integer.parseInt(yearstr);
		if (month == 01){
			previousMonthInt = 11;
			previousYearInt--;
		}
		else if (month == 02) {
			previousMonthInt = 12;
			previousYearInt--;
		}
		else
			previousMonthInt = previousMonthInt -2;
		
		String DatePast = daystr+"/"+Integer.toString(addZerosInt(previousMonthInt))+"/"+Integer.toString(previousYearInt);
		return DatePast;
		
	}
	
	/**
	 * Obtener la fecha actual -1 mes
	 * 
	 * @return
	 */
	public static String setPreviousMonth() {
		int previousMonthInt = 0;
		int previousYearInt = 0;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String StringDate = dateFormat.format(cal.getTime());
		String date = StringDate;
		String daystr = date.split("/")[0];
		String monthstr = date.split("/")[1];
		String yearstr = date.split("/")[2];
		int month = Integer.parseInt(monthstr);
		previousMonthInt = month;
		previousYearInt = Integer.parseInt(yearstr);
		if (month == 01){
			previousMonthInt = 11;
			previousYearInt--;
		}
		else
			previousMonthInt--;
		
		String DatePast = daystr+"/"+Integer.toString(addZerosInt(previousMonthInt))+"/"+Integer.toString(previousYearInt);
		return DatePast;
		
	}
	
	/**
	 * Agrega zeros a la izquierda para los meses de una sola cifra
	 * 
	 * @param num
	 * @return Int
	 */
	private static int addZerosInt(int num) {
		if (num < 10) {
			 String padded = String.format("%01d" , num);
			 return Integer.parseInt(padded);
		}
		else
			return num;
	}
	
	/**
	 * Devuelve una fecha en el formato "22 de Octubre de 2015"
	 * Toma como parametro una fecha en el formato dd/mm/yyyy
	 * 
	 * @param date
	 * @return String
	 */
	public static String getDateAsText(String date) {
		String day = removeZeroInt(date.split("/")[0]);
		String month = getMonthText(date);
		String year = date.split("/")[2];
		
		String dateText = day + " de " + month + " de " + year;
		
		return dateText;
	}
	
	/**
	 * Remueve el zero a la izquierda de numeros menor a 10
	 * 
	 * @param String
	 * @return String
	 */
	public static String removeZeroInt(String number) {
		int num = Integer.parseInt(number);
		
		if(num < 10) {
			return String.format("%-1d" , num);
		} else {
			return number;
		}
	}

}

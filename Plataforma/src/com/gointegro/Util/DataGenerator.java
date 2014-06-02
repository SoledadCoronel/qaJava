package com.gointegro.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DataGenerator {
	
	/**
	 * Crea un string de caracteres aleatorios de 20 caracteres
	 * 
	 * @return String
	 */
	
	public static String nombreFile() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String nombre = sb.toString();
		return nombre;
	}
	
	/**
	 * Devuelve la hora actual en formato HH:mm:ss dd/MM/yyyy
	 * 
	 * @return String
	 */

	public static String horaactual() {
		String hora = null;
		Date date = new Date();
		SimpleDateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		hora = hourdateFormat.format(date);
		return hora;
	}
	
	/**
	 * Devuelve la fecha actual en formato dd/MM/yyyy
	 * 
	 * @return String
	 */
	public static String fechaactual() {
		String fecha = null;
		Date date = new Date();
		SimpleDateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fecha = hourdateFormat.format(date);
		return fecha;
	}
	
	/**
	 * Devuelve la fecha actual en formato dd/MM/yyyy
	 * 
	 * @return String
	 */
	public static String fechamanana() {
		String fecha = null;
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		SimpleDateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fecha = hourdateFormat.format(cal.getTime());
		return fecha;
	}
	
}

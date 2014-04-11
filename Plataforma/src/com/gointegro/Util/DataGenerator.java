package com.gointegro.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataGenerator {
	
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

	public static String horaactual() {
		String hora = null;
		Date date = new Date();
		SimpleDateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		hora = hourdateFormat.format(date);
		return hora;
	}
}

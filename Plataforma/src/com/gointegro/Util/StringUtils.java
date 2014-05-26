package com.gointegro.Util;

public class StringUtils {
	
	/**
	 * Recorta el texto "Ver mas" de social
	 * 
	 * @param textooriginal
	 * @return
	 */
	
	public static String RecortarTextoVerMas(String textooriginal) {
		String textorecortado = null;
		int inicio = textooriginal.indexOf("...");
		String textorecortado1 = textooriginal.substring(0, inicio);
		textorecortado = textorecortado1.replaceAll("[\n\r]", "");
		return textorecortado;
	}
	
	/**
	 * Devuelve un texto extenso, para pruebas de caracteres
	 * 
	 * @return String 1500 characters
	 */
	
	public static String getTextoLargo() {
		return "Una mañana, tras un sueño intranquilo, Gregorio Samsa se despertó convertido en un monstruoso insecto. Estaba echado de espaldas sobre un duro caparazón y, al alzar la cabeza, vio su vientre convexo y oscuro, surcado por curvadas callosidades, sobre el que casi no se aguantaba la colcha, que estaba a punto de escurrirse hasta el suelo. Numerosas patas, penosamente delgadas en comparación con el grosor normal de sus piernas, se agitaban sin concierto. - ¿Qué me ha ocurrido? No estaba soñando. Su habitación, una habitación normal, aunque muy pequeña, tenía el aspecto habitual. Sobre la mesa había desparramado un muestrario de paños - Samsa era viajante de comercio-, y de la pared colgaba una estampa recientemente recortada de una revista ilustrada y puesta en un marco dorado. La estampa mostraba a una mujer tocada con un gorro de pieles, envuelta en una estola también de pieles, y que, muy erguida, esgrimía un amplio manguito, asimismo de piel, que ocultaba todo su antebrazo. Gregorio miró hacia la ventana; estaba nublado, y sobre el cinc del alféizar repiqueteaban las gotas de lluvia, lo que le hizo sentir una gran melancolía. «Bueno -pensó-; ¿y si siguiese durmiendo un rato y me olvidase de todas estas locuras?» Pero no era posible, pues Gregorio tenía la costumbre de dormir sobre el lado derecho, y su actual estado no le permitía adoptar tal postura. Por más que se esforzara volvía a quedar de espaldas. Intentó en vano esta operación numerosas veces; cerró los ojos para no t";
	}
	
	
	public static String getCaracteresEspeciales() {
		return "São Paulo é você áéëíóôõúç";
	}

}

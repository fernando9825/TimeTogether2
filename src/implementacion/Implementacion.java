package implementacion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import logica.ElTiempo;

public class Implementacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ElTiempo tiempo = new ElTiempo(
				"GMT-6"
				, 27 /*dia*/
				, 7 /*mes*/
				, 2017 /*a�o*/
				, 12 /*hora*/
				, 45 /*minutos*/
				, 15 /*segundos*/);
		System.out.println("Dia del a�o actual: " + tiempo.getFechaActual().get(Calendar.DAY_OF_YEAR));
		System.out.println("Dia del a�o cuando comenzo la relaci�n: " + tiempo.getFechaRelacion().get(Calendar.DAY_OF_YEAR));
		System.out.println("Los dias de relaci�n son: " + tiempo.tiempoEnDiasConHora());
		
		System.out.println("\n\n\nFECHA HUMANIZADA\n\n");
		tiempo.fechaHumanizada();
	}

}

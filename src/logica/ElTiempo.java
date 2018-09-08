package logica;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.TimeZone;

public class ElTiempo {

	public ElTiempo(String husoHorario, int diaRelacion, int mesRelacion, int anhioRelacion, int horaRelacion,
			int minutosRelacion, int segundosRelacion) {

		setFechaActual(husoHorario);
		setFechaRelacion(diaRelacion, mesRelacion, anhioRelacion, horaRelacion, minutosRelacion, segundosRelacion);

	}

	// Métodos setters

	public void setFechaActual(String husoHorario) {

		// Fecha y hora actual, según la el huso horario proporcionado
		fechaActual = new GregorianCalendar(TimeZone.getTimeZone(TimeZone.getTimeZone(husoHorario).getID()));
	}

	public void setFechaRelacion(int diaRelacion, int mesRelacion, int anhioRelacion, int horaRelacion,
			int minutosRelacion, int segundosRelacion) {

		// Fecha y hora actual, según la el huso horario predeterminado
		fechaRelacion = new GregorianCalendar(anhioRelacion, mesRelacion - 1, diaRelacion, horaRelacion,
				minutosRelacion, segundosRelacion);
	}

	// Métodos getters

	public GregorianCalendar getFechaActual() {
		return fechaActual;
	}

	public GregorianCalendar getFechaRelacion() {
		return fechaRelacion;
	}

	// Métodos de funcionamiento

	public int tiempoEnDias() {

		double diasActual, diasRelacion;

		System.out.println("Año relacion: " + fechaRelacion.get(Calendar.YEAR));
		System.out.println("Mes relacion: " + (fechaRelacion.get(Calendar.MONTH) + 1));
		System.out.println("Dia relacion: " + fechaRelacion.get(Calendar.DAY_OF_MONTH));

		System.out.println("");// Salto de linea

		System.out.println("Año actual: " + fechaActual.get(Calendar.YEAR));
		System.out.println("Mes actual: " + (fechaActual.get(Calendar.MONTH) + 1));
		System.out.println("Dia actual: " + fechaActual.get(Calendar.DAY_OF_MONTH));

		diasRelacion = ((fechaRelacion.get(Calendar.YEAR)) * (365))
				+ (((fechaRelacion.get(Calendar.MONTH) + 1)) * (DURACIONMESES))
				+ fechaRelacion.get(Calendar.DAY_OF_MONTH);

		diasActual = ((fechaActual.get(Calendar.YEAR)) * (365))
				+ (((fechaActual.get(Calendar.MONTH) + 1)) * (DURACIONMESES)) + fechaActual.get(Calendar.DAY_OF_MONTH);

		int diferenciaDias = (int) (diasActual - diasRelacion);

		System.out.println(fechaRelacion.get(Calendar.HOUR_OF_DAY));
		System.out.println(fechaRelacion.get(Calendar.MINUTE));
		System.out.println(fechaRelacion.get(Calendar.SECOND));
		/*
		 * Pruebas System.out.println(diasRelacion);
		 * 
		 * System.out.println(diasRelacion/365);
		 * 
		 * System.out.println((int)(12*((diasRelacion/365)-((int)(diasRelacion/365)))));
		 * System.out.println((12*((diasRelacion/365)-((int)(diasRelacion/365))))-
		 * ((int)(12*((diasRelacion/365)-((int)(diasRelacion/365)))))); double meses =
		 * (12*((diasRelacion/365)-((int)(diasRelacion/365))))-
		 * ((int)(12*((diasRelacion/365)-((int)(diasRelacion/365)))));
		 * System.out.println(Math.round(meses*DURACIONMESES));
		 */
		return diferenciaDias;
	}

	public double tiempoEnDiasConHora() {

		double diasActual, diasRelacion;

		/*
		 * System.out.println("Año relacion: " + fechaRelacion.get(Calendar.YEAR));
		 * System.out.println("Mes relacion: " + (fechaRelacion.get(Calendar.MONTH)+1));
		 * System.out.println("Dia relacion: " +
		 * fechaRelacion.get(Calendar.DAY_OF_MONTH));
		 * 
		 * System.out.println("");//Salto de linea
		 * 
		 * System.out.println("Año actual: " + fechaActual.get(Calendar.YEAR));
		 * System.out.println("Mes actual: " + (fechaActual.get(Calendar.MONTH)+1));
		 * System.out.println("Dia actual: " + fechaActual.get(Calendar.DAY_OF_MONTH));
		 */
		diasRelacion = ((fechaRelacion.get(Calendar.YEAR)) * (365))
				+ (((fechaRelacion.get(Calendar.MONTH) + 1)) * (DURACIONMESES))
				+ fechaRelacion.get(Calendar.DAY_OF_MONTH) + ((fechaRelacion.get(Calendar.HOUR_OF_DAY)) / 24.0)
				+ ((fechaRelacion.get(Calendar.MINUTE) / 60.0) / 24.0);

		diasActual = ((fechaActual.get(Calendar.YEAR)) * (365))
				+ (((fechaActual.get(Calendar.MONTH) + 1)) * (DURACIONMESES)) + fechaActual.get(Calendar.DAY_OF_MONTH)
				+ ((fechaActual.get(Calendar.HOUR_OF_DAY)) / 24.0) + ((fechaActual.get(Calendar.MINUTE) / 60.0) / 24.0);

		double diferenciaDias = (diasActual - diasRelacion);
		

		/*
		 * //CConversiones necesarias
		 * System.out.println(((fechaRelacion.get(Calendar.HOUR_OF_DAY))/24.0));
		 * System.out.println(((fechaRelacion.get(Calendar.MINUTE)/60.0)/24.0));
		 * System.out.println(((fechaRelacion.get(Calendar.SECOND)/60.0)/60.0)/24.0);
		 */

		
		return Math.round(diferenciaDias);
	}

	public String fechaHumanizada() {
		String[] diasCadena = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };

		String[] mesesCadena = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
				"octubre", "noviembre", "diciembre" };
		
		String hoy = diasCadena[fechaActual.get(Calendar.DAY_OF_WEEK)-1] + ", " 
				+fechaActual.get(Calendar.DAY_OF_MONTH) + " de " 
				+ mesesCadena[fechaActual.get(Calendar.MONTH)] + " de " + fechaActual.get(Calendar.YEAR);

		double diferenciaTiempo = tiempoEnDiasConHora();

		// Primero convertir de dias a años...
		double anhios = diferenciaTiempo / 365;

		// Resto de años a meses
		double meses = (anhios - (int) anhios) * 12;

		// Resto de dias de los meses
		double dias = (meses - (int) meses) * DURACIONMESES;

		// Semanas...
		int semanas = (int) dias / 7;
		if (semanas >= 1) {
			dias = dias - (semanas * 7);
		}

		///// Mostrar la información/////////

		/*
		System.out.println("aaaa: " + anhios);
		System.out.println("mm: " + meses);
		System.out.println("semanas:" + semanas);
		System.out.println("dd: " + dias);

		 */
		// Realizar cadena de diferencia

		String fecha, a = "", s = "", m = "", d = "";
		// años
		if ((int) anhios >= 1) {
			if ((int) anhios == 1) {
				a = "un año";
			} else {
				a = (int) anhios + " años";
			}
		}

		// meses
		if ((int) meses >= 1) {
			if ((int) meses == 1) {
				m = "un mes";
			} else {
				m = (int) meses + " meses";
			}
		}

		// Semanas
		if (semanas >= 1) {
			if (semanas == 1) {
				s = "una semana";
			} else {
				s = semanas + " semanas";
			}
		}

		// dias
		if ((int) dias >= 1) {
			if ((int) dias == 1) {
				d = "un día.";
			} else {
				d = (int) dias + " días.";
			}
		}

		/*
		if (a != null) {
			if (m != null) {

				if (s != null) {
					if (d != null) {
						fecha = m + "; " + s + " " + d;
					}else {
						fecha = m + "; " + s + " " + d;
					}
				}
			}
			
		}

		*/
		
		if(!m.isEmpty() && !a.isEmpty()) {
			m = "; " + m;
		}
		
		if(!s.isEmpty()) {
			s = "; " + s;
		}
		
		if((semanas != 0) || (!d.isEmpty())) {
			d = "; " + d;
		}
		fecha = hoy + "\n";
		fecha += a + m + s + d;
		fecha += "\n"+(int)diferenciaTiempo + " días.";
		fecha.trim();
		
		if(anhios == (int)anhios) {
			System.out.println("¡Feliz aniversario mi amor,\neres lo mejor que me ha pasado en la vida,"
					+ "\nte amoooooooooooo :3!\n");
		}
		
		//Imprimir la fecha actual
		System.out.println(fecha);
		return fecha;
	}

	private GregorianCalendar fechaActual, fechaRelacion;
	private final double DURACIONMESES = 30.4167;// dias

}

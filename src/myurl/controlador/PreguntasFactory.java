package myurl.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import myurl.modelo.Fraccion;
import myurl.modelo.Operacion;
import myurl.modelo.PreguntaFracciones;

public class PreguntasFactory {
	/**
	 * Metodo que genera una pregunta con Fracciones. Recibe el rango de los numeros
	 * de los fraccionarios con el fin de generar un numero aleatorio. Tambien
	 * recibe la operacion que la relaciona.
	 * 
	 * @param rangoIni  limite inferior para generar el numero aleatorio del
	 *                  numerador y denominador de las fracciones
	 * @param rangoFin  limite superior para generar el numero aleatorio del
	 *                  numerador y denominador de las fracciones
	 * @param operacion operador
	 * @return la pregunta fraccionario generada
	 */
	public PreguntaFracciones generarFraccionesRdmConOperador(int rangoIni, int rangoFin, Operacion operacion) {
		PreguntaFracciones pf;
		Long ini = generarNumeroAleatorio(rangoIni, rangoFin);
		Long fin = generarNumeroAleatorio(rangoIni, rangoFin);
		Fraccion fraccion1 = new Fraccion(ini, fin);
		ini = generarNumeroAleatorio(rangoIni, rangoFin);
		fin = generarNumeroAleatorio(rangoIni, rangoFin);
		Fraccion fraccion2 = new Fraccion(ini, fin);
		Fraccion respuesta = generarRespuesta(fraccion1, fraccion2, operacion);
		pf = new PreguntaFracciones(fraccion1, fraccion2, operacion, respuesta);
		return pf;
	}

	/**
	 * Metodo que genera una pregunta con Fracciones. Recibe el rango de los numeros
	 * de los fraccionarios con el fin de generar un numero aleatorio. Tambien
	 * genera la operacion aleatoriamente.
	 * 
	 * @param rangoIni limite inferior para generar el numero aleatorio del
	 *                 numerador y denominador de las fracciones
	 * @param rangoFin limite superior para generar el numero aleatorio del
	 *                 numerador y denominador de las fracciones
	 * 
	 * @return la pregunta fraccionario generada
	 */

	public PreguntaFracciones generarFraccionesRdm(int rangoIni, int rangoFin) {
		PreguntaFracciones pf;
		Long ini = generarNumeroAleatorio(rangoIni, rangoFin);
		Long fin = generarNumeroAleatorio(rangoIni, rangoFin);
		Operacion op = generarOperadorRdm();
		Fraccion fraccion1 = new Fraccion(ini, fin);
		ini = generarNumeroAleatorio(rangoIni, rangoFin);
		fin = generarNumeroAleatorio(rangoIni, rangoFin);
		Fraccion fraccion2 = new Fraccion(ini, fin);
		Fraccion respuesta = generarRespuesta(fraccion1, fraccion2, op);
		pf = new PreguntaFracciones(fraccion1, fraccion2, op, respuesta);
		return pf;
	}

	/**
	 * Metodo que genera una lista de preguntas Fracciones. Los numeros y las
	 * operacione son generadas aleatoriamente.
	 * 
	 * @param rangoIni limite inferior para generar el numero aleatorio del
	 *                 numerador y denominador de las fracciones
	 * @param rangoFin limite superiosr para generar el numero aleatorio del
	 *                 numerador y denominador de las fracciones
	 * @param cantidad cantidad de elementos de la lista
	 * 
	 * @return la lista de preguntas fracciones
	 */

	public List<PreguntaFracciones> generarListaPreguntasFraccionesRmd(int rangoIni, int rangoFin, int cantidad) {
		List<PreguntaFracciones> lstPreguntas = new ArrayList<PreguntaFracciones>();
		for (int i = 0; i < cantidad; i++) {
			PreguntaFracciones pf = generarFraccionesRdm(rangoIni, rangoFin);
			lstPreguntas.add(pf);
		}
		return lstPreguntas;
	}

	/**
	 * Metodo que genera un numero aleatorio dado un rango.
	 * 
	 * @param rangoIni delimitacion inferior
	 * @param rangoFin delimitacion superior
	 * @return el numero aleatorio tipo Long
	 */
	public Long generarNumeroAleatorio(int rangoIni, int rangoFin) {
		Long valor = (long) Math.floor(Math.random() * rangoFin + rangoIni);
		return valor;
	}

	public Operacion generarOperadorRdm() {
		List<Operacion> valores = Collections.unmodifiableList(Arrays.asList(Operacion.values()));
		int size = valores.size();
		int rdm = (int) Math.floor(Math.random() * size);
		return valores.get(rdm);
	}

	/**
	 * Metodo que genera una respuesta tipo fraccion de acuerdo con la operacion que
	 * las relacione
	 * 
	 * @param fraccion1 primera fraccion
	 * @param fraccion2 segunda fraccion
	 * @param oper      operacion que las relaciona
	 * @return
	 */
	public Fraccion generarRespuesta(Fraccion fraccion1, Fraccion fraccion2, Operacion oper) {

		Long numResp = null;
		Long denResp = null;
		Fraccion resp;

		switch (oper.getDescripcion()) {
		case "multiplicacion":
			numResp = fraccion1.getNumerador() * fraccion2.getNumerador();
			denResp = fraccion1.getDenominador() * fraccion2.getDenominador();
			break;
		case "division":
			numResp = fraccion1.getNumerador() * fraccion2.getDenominador();
			denResp = fraccion1.getDenominador() * fraccion2.getNumerador();
			break;
		case "suma":
			numResp = fraccion1.getNumerador() * fraccion2.getDenominador()
					+ fraccion1.getDenominador() * fraccion2.getNumerador();
			denResp = fraccion1.getDenominador() * fraccion2.getDenominador();
			break;
		case "resta":
			numResp = fraccion1.getNumerador() * fraccion2.getDenominador()
					- fraccion1.getDenominador() * fraccion2.getNumerador();
			denResp = fraccion1.getDenominador() * fraccion2.getDenominador();
			break;
		}

		resp = new Fraccion(numResp, denResp);
		return resp;
	}

}

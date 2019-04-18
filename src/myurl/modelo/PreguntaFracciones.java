/**
 * 
 */
package myurl.modelo;

/**
 * @author Secretaria1
 *
 */
public class PreguntaFracciones {
	private Fraccion fraccion1;
	private Fraccion fraccion2;
	private Operacion operacion;
	private Fraccion respuesta;
	private boolean correcta;

	public PreguntaFracciones(Fraccion fraccion1, Fraccion fraccion2, Operacion operacion, Fraccion respuesta) {
		super();
		this.fraccion1 = fraccion1;
		this.fraccion2 = fraccion2;
		this.operacion = operacion;
		this.respuesta = respuesta;
		this.correcta = false;
	}

	/**
	 * @return the fraccion1
	 */
	public Fraccion getFraccion1() {
		return fraccion1;
	}

	/**
	 * @param fraccion1 the fraccion1 to set
	 */
	public void setFraccion1(Fraccion fraccion1) {
		this.fraccion1 = fraccion1;
	}

	/**
	 * @return the fraccion2
	 */
	public Fraccion getFraccion2() {
		return fraccion2;
	}

	/**
	 * @param fraccion2 the fraccion2 to set
	 */
	public void setFraccion2(Fraccion fraccion2) {
		this.fraccion2 = fraccion2;
	}

	/**
	 * @return the operacion
	 */
	public Operacion getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return the respuesta
	 */
	public Fraccion getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Fraccion respuesta) {
		respuesta = respuesta;
	}

	/**
	 * @return the correcta
	 */
	public boolean isCorrecta() {
		return correcta;
	}

	/**
	 * @param correcta the correcta to set
	 */
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}

	@Override
	public String toString() {
		return "PreguntaFracciones [ " + fraccion1 + operacion.getSimbolo() + fraccion2 + " = " + respuesta + "]"
				+ correcta;
	}

	public String toString2() {
		// TODO Auto-generated method stub
		return "[ " + fraccion1 + operacion.getSimbolo() + fraccion2 + " = " + respuesta + "]  (" + correcta + ")";
	}

}

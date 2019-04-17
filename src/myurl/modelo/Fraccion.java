/**
 * 
 */
package myurl.modelo;

/**
 * @author Secretaria1
 *
 */
public class Fraccion {
	private Long numerador;
	private Long denominador;
	
	
	public Fraccion(Long numerador, Long denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}


	/**
	 * @return the numerador
	 */
	public Long getNumerador() {
		return numerador;
	}


	/**
	 * @param numerador the numerador to set
	 */
	public void setNumerador(Long numerador) {
		this.numerador = numerador;
	}


	/**
	 * @return the denominador
	 */
	public Long getDenominador() {
		return denominador;
	}


	/**
	 * @param denominador the denominador to set
	 */
	public void setDenominador(Long denominador) {
		this.denominador = denominador;
	}


	@Override
	public String toString() {
		return "Fraccion [ "+numerador + " / " + denominador + " ]";
	}
	
	

}

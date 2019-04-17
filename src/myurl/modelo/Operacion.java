/**
 * 
 */
package myurl.modelo;

/**
 * @author Secretaria1
 *
 */
public enum Operacion {
	

	PRODUCTO("multiplicacion","×"),
	DIVISION("division","÷"),
	ADICION("suma","+"),
	SUSTRACCION("resta","-");
	
	private final String descripcion;
	private final String simbolo;
	
	private Operacion(String descripcion, String simbolo) {
		this.descripcion = descripcion;
		this.simbolo = simbolo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the simbolo
	 */
	public String getSimbolo() {
		return simbolo;
	}
	
	

}

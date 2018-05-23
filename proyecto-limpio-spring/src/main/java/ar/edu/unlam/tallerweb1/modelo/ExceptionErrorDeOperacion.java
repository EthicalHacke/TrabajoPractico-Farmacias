package ar.edu.unlam.tallerweb1.modelo;

public class ExceptionErrorDeOperacion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ExceptionErrorDeOperacion(String msj) {
	super("no existe la operacion " + msj);
	}
	
}

package ar.edu.unlam.tallerweb1.modelo;

public class OperacionErronea {

	

	public static String comprobarOperacion(String operacion)throws ExceptionErrorDeOperacion {
		
		if(operacion.equals("sumar")) {
			return operacion;
		}
		if(operacion.equals("restar")) {
			return operacion;
		}
		if(operacion.equals("dividir")) {
			return operacion;
		}
		if(operacion.equals("multiplicar")) {
			return operacion;
		}
		
		else {
			throw new ExceptionErrorDeOperacion(operacion);		}
			
	}

}

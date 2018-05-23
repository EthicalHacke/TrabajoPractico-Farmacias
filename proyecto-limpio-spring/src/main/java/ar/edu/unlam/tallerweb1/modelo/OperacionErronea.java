package ar.edu.unlam.tallerweb1.modelo;

public class OperacionErronea{

	

	public static String comprobarOperacion(String operacion) {
		
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
			return operacion="error";
		}
			
	}

}

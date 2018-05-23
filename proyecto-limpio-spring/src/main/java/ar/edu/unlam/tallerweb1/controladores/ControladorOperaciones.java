package ar.edu.unlam.tallerweb1.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.OperacionErronea;




@Controller
public class ControladorOperaciones {

public String pruebaoperacion;
private String datoOperacion;

@RequestMapping(path="{operacion}/{num1}/{num2}")
public ModelAndView hacerOperacion(@PathVariable String operacion, @PathVariable Integer num1, @PathVariable Integer num2 ) throws Exception {
		
		
	    datoOperacion = operacion;
	
	    datoOperacion=OperacionErronea.comprobarOperacion(datoOperacion);
	    Object resultado = null;
		ModelMap modelo = new ModelMap();
		try {
		
		if(datoOperacion.equals("sumar")){
			resultado=num1+num2;
		}
		
		if(datoOperacion.equals("restar")){
			resultado=num1-num2;
		}
		
		if(datoOperacion.equals("dividir")){
			resultado=num1/num2;
		}
		
		
		if(datoOperacion.equals("multiplicar")){
			resultado=num1*num2;
		}
		if(datoOperacion.equals("error")){
			
			
			modelo.put("error", "no existe la funcion "+operacion );
			
			return new ModelAndView("/error", modelo);
		}
		 
		modelo.put("resultado", resultado);
		modelo.put("num1", num1);
		modelo.put("num2", num2);
		modelo.put("operacion", operacion);
		return new ModelAndView("/resultado", modelo);
		
	}
		
		catch (Exception e){
            modelo.put("error",e.getMessage());
            return new ModelAndView("/error", modelo);
        }
		
	}

private Object ExceptionErrorDeOperacion(String datoOperacion2) {
	// TODO Auto-generated method stub
	return null;
}
}


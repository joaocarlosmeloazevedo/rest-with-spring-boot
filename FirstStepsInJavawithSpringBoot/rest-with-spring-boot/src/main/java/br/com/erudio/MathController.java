package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Fornece o mapeamento entre o Path da Request e o método em questão.
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo //Definição das variavéis
			){
		return 1D;
	} 
}

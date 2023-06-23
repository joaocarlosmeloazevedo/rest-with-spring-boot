package br.com.erudio;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Fornece o mapeamento entre o Path da Request e o método em questão.
public class MathController {

//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo) 
			throws Exception{
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	} 
	
	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", "."); //Recebendo vírgula e retornando ponto
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", "."); //Recebendo vírgula e retornando ponto
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //Verificando se o número é negativo ou positivo, inteiro ou quebrado e se vai de 0 a 9.
	}
}

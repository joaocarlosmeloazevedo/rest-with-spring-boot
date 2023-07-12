package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController //Fornece o mapeamento entre o Path da Request e o método em questão.
public class MathController {

//	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo) 
			throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo) 
			throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/times/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double times(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo) 
			throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.times(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo) 
			throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/root/{numberOne}", 
			//Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
			
	public Double root(
			@PathVariable(value = "numberOne") String numberOne)//Definição das variavéis 
			throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return math.root(NumberConverter.convertToDouble(numberOne));
	}
	
	@RequestMapping(value="/medium/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
	
	public Double medium(
			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
			@PathVariable(value = "numberTwo") String numberTwo) 
			throws Exception{
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return math.medium(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

}

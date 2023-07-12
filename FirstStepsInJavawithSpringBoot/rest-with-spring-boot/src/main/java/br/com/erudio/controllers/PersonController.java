package br.com.erudio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;
//import br.com.erudio.math.SimpleMath;

@RestController //Fornece o mapeamento entre o Path da Request e o método em questão.
@RequestMapping("/person")
public class PersonController {

//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();
	
//	private SimpleMath math = new SimpleMath();
	
	@Autowired
	private PersonServices service;
	//private PersonServices = new PersonServices(); <--- Mesma coisa
	
	@RequestMapping(method=RequestMethod.GET,  //Especificando o tipo de requestMethod por boas práticas. PADRÃO GET
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
			method=RequestMethod.GET,  //Especificando o tipo de requestMethod por boas práticas. PADRÃO GET
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id){
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,  
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person){
		return service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT,  
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person){
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.DELETE) //Especificando o tipo de requestMethod por boas práticas. PADRÃO GET

	public void delete(@PathVariable(value = "id") String id){
		service.delete(id);
	}
}


////	
//	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
//			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
//			
//	public Double sum(
//			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
//			@PathVariable(value = "numberTwo") String numberTwo) 
//			throws Exception{
//		
//		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
//			throw new UnsupportedMathOperationException("Please set a numeric value");
//		}
//		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
//	}
//	
//	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
//			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
//			
//	public Double subtraction(
//			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
//			@PathVariable(value = "numberTwo") String numberTwo) 
//			throws Exception{
//		
//		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
//			throw new UnsupportedMathOperationException("Please set a numeric value");
//		}
//		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
//	}
//	
//	@RequestMapping(value="/times/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
//			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
//			
//	public Double times(
//			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
//			@PathVariable(value = "numberTwo") String numberTwo) 
//			throws Exception{
//		
//		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
//			throw new UnsupportedMathOperationException("Please set a numeric value");
//		}
//		return math.times(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
//	}
//	
//	@RequestMapping(value="/division/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
//			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
//			
//	public Double division(
//			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
//			@PathVariable(value = "numberTwo") String numberTwo) 
//			throws Exception{
//		
//		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
//			throw new UnsupportedMathOperationException("Please set a numeric value");
//		}
//		
//		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
//	}
//
//	@RequestMapping(value="/root/{numberOne}", 
//			//Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
//			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
//			
//	public Double root(
//			@PathVariable(value = "numberOne") String numberOne)//Definição das variavéis 
//			throws Exception{
//		
//		if (!NumberConverter.isNumeric(numberOne)) {
//			throw new UnsupportedMathOperationException("Please set a numeric value");
//		}
//		
//		return math.root(NumberConverter.convertToDouble(numberOne));
//	}
//	
//	@RequestMapping(value="/medium/{numberOne}/{numberTwo}", //Essa Annotation utiliza parametros obrigatórios na URL PathParameters. (Por este motivo o value)
//			method=RequestMethod.GET) //Especificando o tipo de requestMethod por boas práticas.
//	
//	public Double medium(
//			@PathVariable(value = "numberOne") String numberOne,//Definição das variavéis
//			@PathVariable(value = "numberTwo") String numberTwo) 
//			throws Exception{
//		
//		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
//			throw new UnsupportedMathOperationException("Please set a numeric value");
//		}
//		return math.medium(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
//	}
//
//}

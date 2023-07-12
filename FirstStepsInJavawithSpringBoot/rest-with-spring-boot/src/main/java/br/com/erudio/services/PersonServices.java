package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service //SpringBoot vai instanciar a classe iés de instancia-la na classe Main;
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
		persons.add(person);
		}
		return persons;
	}

	public Person findById(String id) {
		
		//MOCK -> Estrutura de codigo que sustenta temporariamente o código para que ele funcione, mesmo sem as funcionalidades finais.
		logger.info("Finding new person!");
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("João");
		person.setLastName("Carlos");
		person.setGender("Male");
		person.setAddress("São Paulo - SP");
		
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return person;
	}
	
public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		return person;
	}

public void delete(String id) {
	
	logger.info("Deleting one person!");
}
	

	private Person mockPerson(int i) {
		logger.info("Finding ALL people!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setGender("Male");
		person.setAddress("Some address in Brasil " + i);
		return person;
	}
}

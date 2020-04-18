/*Juliana Campos Degenario Ribeiro
nusp: 11275112*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;

public class Person{	//classe Person

	private final String name;	//variavel para armazenar o nome da pessoa
	private final String country;	//variavel para armazenar o país
	private final LocalDate birthdate;	//variavel para armazenar a data de nascimento
	private int age;	//variavel para armazenar a idade
	private LocalDate currentDate;	//variavel para armazenar a data atual

	//construtor da classe Person
	public Person(String name, String country, String birthdate, int age){

    	this.name = name;
    	this.country = country;
		this.birthdate = LocalDate.parse(birthdate);//transoforma o tipo de birthdate pata LocalDate ao invés de String
		//verifica a data atual para calcular a idade
    	currentDate = LocalDate.now(); 
		Period diff = Period.between(LocalDate.parse(birthdate), currentDate);
		age = diff.getYears();
    	this.age = age;

	}
	
	public String getName() {
    	return name;
  	}

	public String getCountry() {
    	return country;
  	}

	public String getBirthdate() {
    	return birthdate.toString();
  	}

	public int getAge() {
    	return age;
  	}

}
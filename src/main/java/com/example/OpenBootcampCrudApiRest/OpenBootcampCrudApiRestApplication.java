package com.example.OpenBootcampCrudApiRest;

import com.example.OpenBootcampCrudApiRest.Entity.LaptopEntity;
import com.example.OpenBootcampCrudApiRest.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpenBootcampCrudApiRestApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OpenBootcampCrudApiRestApplication.class, args);

		//LaptopRepository repository = context.getBean(LaptopRepository.class);
		//Linea para insertar una laptor de manera anonima.
		//repository.save(new LaptopEntity("zx10", "01/07/1996", "Accer"));
	    //repository.save(new LaptopEntity("Resd58", "25/10/1995", "Hp"));
		//repository.save(new LaptopEntity("TpLinkUB500", "07/05/2021", "Siragón"));


	}

}


/*
Ejercicio 1

Crear un proyecto Spring Boot con las dependencias:

H2

Spring Data JPA

Spring Web

Spring Boot dev tools

Crear una clase HelloController que sea un controlador REST. Dentro de la clase crear un método que retorne un saludo. Probar que retorna el saludo desde el navegador y desde Postman.

Ejercicio 2

Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":

Laptop (entidad)

LaptopRepository (repositorio)

LaptopController (controlador)

Desde LaptopController crear un método que devuelva una lista de objetos Laptop.

Probar que funciona desde Postman.

Los objetos Laptop se pueden insertar desde el método main de la clase principal.

Ejercicio 3

Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.

Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.
*/

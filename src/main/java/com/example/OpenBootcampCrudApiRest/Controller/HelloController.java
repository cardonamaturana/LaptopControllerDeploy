package com.example.OpenBootcampCrudApiRest.Controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//Este es el archivo en el repositorio cardona.maturana
//@RequestMapping("/")
public class HelloController {
    @Value("${myapp.message}")
    public String message;



    @Hidden
    @Operation( summary = "Método saludo 'Hola Mundo' desde SpringBoot", description = "Mediante la peticion Se espera " +
            "obtener un " +
            "mensaje que diga 'Hola mundo desde SpringBoot'" )
    @GetMapping("/")
    public String holaMundo(){
        return "Julio Cesar Cardona Maturana - " + message;
        //Cambio en el main
    }


    }



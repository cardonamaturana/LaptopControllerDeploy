package com.example.OpenBootcampCrudApiRest.Controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class HelloController {


    @ApiOperation(value = "Método saludo 'Hola Mundo' desde SpringBoot", notes = "Mediante la peticion Se espera obtener un mensaje que diga 'Hola mundo desde SpringBoot'" )
    @GetMapping("/")
    public String holaMundo(){
        return "Julio Cesar Cardona Maturana ES LA GAVER";
    }
}

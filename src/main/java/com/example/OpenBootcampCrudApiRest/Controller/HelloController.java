package com.example.OpenBootcampCrudApiRest.Controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;


@RestController
//Este es el archivo en el repositorio cardona.maturana
//@RequestMapping("/")
public class HelloController {

    @ApiIgnore
    @ApiOperation(value = "Método saludo 'Hola Mundo' desde SpringBoot", notes = "Mediante la peticion Se espera obtener un mensaje que diga 'Hola mundo desde SpringBoot'" )
    @GetMapping("/")
    public String holaMundo(){
        return "Julio Cesar Cardona Maturana ";

    }

//    @ApiIgnore
//    @GetMapping("/")
//    public RedirectView redirect() {
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("https://casual-invention-production.up.railway.app/swagger-ui/index.html#/hello-controller/holaMundoUsingGET");
//        return redirectView;
//    }




}

package com.example.OpenBootcampCrudApiRest.Controller;

import com.example.OpenBootcampCrudApiRest.Entity.LaptopEntity;
import com.example.OpenBootcampCrudApiRest.Repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class LaptopController {

    @Autowired
    LaptopRepository repository;

    @ApiOperation(value = "Se realiza una consulta que retorna todos los objetos Laptop registrados en la BD")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Devuelve una lista con todas las laptops registradas en BD"),

            @ApiResponse(code = 204, message = "No hay Laptop registradas en BD")})



/*
    TODO: Pendiente para comentar con wagger
*
**/

















    
    @GetMapping("/laptops")
    public ResponseEntity<LaptopEntity> findAll() {
        ResponseEntity response;
        List<LaptopEntity> laptops = repository.findAll();
        if (laptops.size() == 0) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            response = new ResponseEntity<>(laptops, HttpStatus.OK);
        }

        return response;

    }

    @ApiOperation(value = "Se realiza consulta de Laptop por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Devuelve JSON con la informacion de la laptop encontrad con el ID " +
                    "ingresado"),
            @ApiResponse(code = 404, message = "NOT_FOUND si no hay coincidencias de Laptop con el ID ingresado")})

    @GetMapping("/laptop/{id}")
    public ResponseEntity<LaptopEntity> findById(@PathVariable long id) {
        Optional<LaptopEntity> optional = repository.findById(id);
        return (optional.isPresent()) ? new ResponseEntity<>(optional.get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Método para crear una nueva Laptop, Verifica que la laptop ingresada no sea NULL")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Devuelve el objeto laptop creado."),
            @ApiResponse(code = 400, message = "Bad request, Objeto NULL")})

    @PostMapping("laptop")
    public ResponseEntity<LaptopEntity> create(@RequestBody LaptopEntity laptop) {
        System.out.println("Mostrando laptop --> " + laptop);
        if (isNull(laptop) || repository.existsById(laptop.getId())) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return (new ResponseEntity<LaptopEntity>(repository.save(laptop), HttpStatus.OK));
    }

    @ApiOperation(value = "Actualiza una Laptop existente, Verifica que la laptop ingresada no sea NULL y que exista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Devuelve el objeto laptop modificado."),
            @ApiResponse(code = 400, message = "Laptop NULL o no existe")})

    @PutMapping("laptop")
    public ResponseEntity update(@RequestBody LaptopEntity laptop) {

        if (isNull(laptop) || (!repository.existsById(laptop.getId()))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return (new ResponseEntity<LaptopEntity>(repository.save(laptop), HttpStatus.OK));
    }

    @ApiOperation(value = "Elimina todas las laptops en la BD")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Elimina todas las laptop")})
    @DeleteMapping("laptop")
    public ResponseEntity delete() {
        repository.deleteAll();
        return (new ResponseEntity<LaptopEntity>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Elimina una Laptop existente por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Elimina la laptop con el id ingresado"),
            @ApiResponse(code = 400, message = "Laptop no existe o laptop es NULL")})
    @DeleteMapping("laptop/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        repository.deleteById(id);
        return (new ResponseEntity<LaptopEntity>(HttpStatus.NO_CONTENT));
    }

    public boolean isNull(LaptopEntity laptop) {
        if (laptop.getBrand() == null && laptop.getDate() == null && laptop.getModel() == null) {
            return true;
        }else{
            return false;
        }
    }
}

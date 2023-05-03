package com.example.OpenBootcampCrudApiRest;

import com.example.OpenBootcampCrudApiRest.Entity.LaptopEntity;
import com.example.OpenBootcampCrudApiRest.Repository.LaptopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenBootcampCrudApiRestApplicationTests {
	@Autowired
	LaptopRepository repository;
	@Test
	void contextLoads() {

	}

}

package com.example.OpenBootcampCrudApiRest.Repository;

import com.example.OpenBootcampCrudApiRest.Entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface LaptopRepository extends JpaRepository<LaptopEntity,Long> {

}

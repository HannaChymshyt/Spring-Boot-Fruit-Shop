package com.example.app.SpringBootFruitShop.repository;

import com.example.app.SpringBootFruitShop.entity.Coconut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoconutRepository extends CrudRepository<Coconut, Long> {
    List<Coconut> findAll();
}

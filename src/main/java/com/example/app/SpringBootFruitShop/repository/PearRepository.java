package com.example.app.SpringBootFruitShop.repository;

import com.example.app.SpringBootFruitShop.entity.Pear;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PearRepository extends CrudRepository<Pear, Long> {

}

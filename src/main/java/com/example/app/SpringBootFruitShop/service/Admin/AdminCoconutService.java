package com.example.app.SpringBootFruitShop.service.Admin;

import com.example.app.SpringBootFruitShop.entity.Coconut;
import com.example.app.SpringBootFruitShop.repository.CoconutRepository;
import com.example.app.SpringBootFruitShop.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class AdminCoconutService {

    @Autowired
    CoconutRepository repository;

    public void createCoconut(Coconut coconut) {
        repository.save(coconut);
    }

    public List<Coconut> getAll() {
        Iterable<Coconut> iterable = repository.findAll();
        List<Coconut> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(coconut -> new Coconut(coconut.getId(),
                                Constants.URL_IMAGES_UPLOADS + coconut.getImg(),
                                coconut.getName(),
                                coconut.getArticle(),
                                coconut.getDescr(),
                                coconut.getPrice()))
                        .toList();
        return new ArrayList<>(list);
    }

}

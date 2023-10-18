package com.example.app.SpringBootFruitShop.service.Admin;


import com.example.app.SpringBootFruitShop.entity.Pear;
import com.example.app.SpringBootFruitShop.repository.PearRepository;
import com.example.app.SpringBootFruitShop.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class AdminPearService {

    @Autowired
    PearRepository repository;

    public List<Pear> getAll() {
        Iterable<Pear> iterable = repository.findAll();
        List<Pear> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(pear -> new Pear(pear.getId(),
                                Constants.URL_IMAGES_UPLOADS + pear.getImg(),
                                pear.getName(),
                                pear.getArticle(),
                                pear.getDescr(),
                                pear.getPrice()))
                        .toList();
        return new ArrayList<>(list);
    }

}

package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/workintech/koalas/")
public class KoalaController {
    public Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @GetMapping
    public Map<Integer, Koala> getAllKoala() {
        return koalas;

    }

    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable("id") Integer id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }
        return koalas.get(id);
    }

    @PostMapping
    public Koala getAddKangaroo(@RequestBody Koala koala) {
        return koalas.put(koala.getId(), koala);

    }

    @PutMapping("/{id}")
    public Koala updateKangaroo(@PathVariable Integer id, @RequestBody Koala koala) {

        if (koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }


      return  koalas.put(id, koala);

    }

    @DeleteMapping("/{id}")
    public Koala deleteKangaroo(@PathVariable("id") Integer id) {
        if (koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }
       return koalas.remove(id);
    }
}

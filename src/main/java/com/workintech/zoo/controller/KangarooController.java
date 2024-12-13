package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/workintech/kangaroos")
public class KangarooController {

    public Map<Integer, Kangaroo> kangaroos;


    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();


    }
    @GetMapping
    public Map<Integer, Kangaroo> getAllKangroos(){
      return  kangaroos;

    }
    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable("id") Integer id){
        if(!kangaroos.containsKey(id)){
            throw new ZooException("Kangroo not found", HttpStatus.NOT_FOUND);
        }
        return kangaroos.get(id);
    }
    @PostMapping
    public Kangaroo getAddList(@RequestBody Kangaroo kangaroo){
      return  kangaroos.put(kangaroo.getId(), kangaroo);

    }
    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable Integer id, @RequestBody Kangaroo kangaroo) {
        if (!kangaroos.containsKey(id)) {
         throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);

        }
       return kangaroos.put(id, kangaroo);

    }
    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable("id") Integer id){
        if(!kangaroos.containsKey(id)){
          throw new ZooException("Kangroo not found", HttpStatus.NOT_FOUND);
        }
      return  kangaroos.remove(id);

    }



}

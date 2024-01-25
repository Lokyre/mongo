package com.hg.crud.controllers;

import com.hg.crud.models.ProductDTO;
import com.hg.crud.repositories.IProductDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,
        RequestMethod.DELETE})
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductDAO repository;

    @PostMapping("/product")
    public ProductDTO create(@Valid @RequestBody ProductDTO p){
        return repository.insert(p);
    }
    @GetMapping("/")
    public List<ProductDTO> readAll(){
        return repository.findAll();
    }
    @PutMapping("/product/{id}")
    public ProductDTO update (@PathVariable String id, @Valid @RequestBody ProductDTO p){

        return repository.save(p);
    }
    @DeleteMapping("/product/{id}")
    public void delete (@PathVariable String id){
        repository.deleteById(id);
    }

}

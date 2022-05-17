package com.testcase.Products.Controller;

import com.testcase.Products.Products;
import com.testcase.Products.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/products/")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsRepository productsRepository;

    @GetMapping
    public ResponseEntity<List<Products>> Get(){
        return ResponseEntity.ok(productsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Products> Create(@RequestBody Products products){
        return ResponseEntity.ok(productsRepository.save(products));
    }

    @DeleteMapping("{id}")
    public ResponseEntity Delete(@PathVariable("id") Integer id){
        productsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

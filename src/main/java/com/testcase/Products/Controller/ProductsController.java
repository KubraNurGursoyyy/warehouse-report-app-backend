package com.testcase.Products.Controller;

import com.testcase.Products.Entity.Products;
import com.testcase.Products.Repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/api/products/")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsRepository productsRepository;

    @GetMapping
    public ResponseEntity<List<Products>> Get(){
        return ResponseEntity.ok(productsRepository.findAll());
    }

    @GetMapping("warehouse/{id}")
    public ResponseEntity<List<Products>> GetByWarehouse(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productsRepository.findAllByWarehouseId(id));
    }


    @GetMapping("name/{name}")
    public ResponseEntity<List<Products>> GetByName(@PathVariable("name") String name){
        return ResponseEntity.ok(productsRepository.findAllByProductsContains(name));
    }

    @GetMapping("price/{requestedprice}/{start}/{end}")
    public ResponseEntity<List<Products>> GetByBetweenPrice(@PathVariable("requestedprice") Integer requestedprice,@PathVariable("start") double start,@PathVariable("end") double end){
        if(requestedprice == 1)
            return ResponseEntity.ok(productsRepository.findAllByPurchasePriceBetween(start, end));
        else if(requestedprice == 2)
            return ResponseEntity.ok(productsRepository.findAllByPurchasePriceWithVatBetween(start,end));
        else if(requestedprice == 3)
            return ResponseEntity.ok(productsRepository.findAllBySalePriceBetween(start,end));
        else
            return ResponseEntity.ok(productsRepository.findAllBySalePriceWithVatBetween(start,end));
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

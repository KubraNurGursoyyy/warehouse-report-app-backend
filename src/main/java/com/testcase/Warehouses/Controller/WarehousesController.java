package com.testcase.Warehouses.Controller;

import com.testcase.Warehouses.Entity.Warehouses;
import com.testcase.Warehouses.Repository.WarehousesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/warehouses/")
@RequiredArgsConstructor
public class WarehousesController {

    private final WarehousesRepository warehousesRepository;

    @GetMapping
    public ResponseEntity<List<Warehouses>> Get(){
        return ResponseEntity.ok(warehousesRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Warehouses> Create(@RequestBody Warehouses warehouses){
        return ResponseEntity.ok(warehousesRepository.save(warehouses));
    }

    @DeleteMapping("{id}")
    public ResponseEntity Delete(@PathVariable("id") Integer id){
        warehousesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

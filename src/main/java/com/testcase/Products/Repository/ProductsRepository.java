package com.testcase.Products.Repository;

import com.testcase.Products.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    List<Products> findAllByWarehouseId(Integer id);
    List<Products> findProductsByProductsContains(String products);

}

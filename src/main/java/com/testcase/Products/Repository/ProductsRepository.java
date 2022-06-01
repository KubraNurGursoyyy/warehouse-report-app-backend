package com.testcase.Products.Repository;

import com.testcase.Products.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    List<Products> findAllByWarehouseId(Integer id);

    List<Products> findAllByProductsContains(String name);

    List<Products> findAllByPurchasePriceBetween(double start,double end);
    List<Products> findAllByPurchasePriceWithVatBetween(double start,double end);
    List<Products> findAllBySalePriceBetween(double start,double end);
    List<Products> findAllBySalePriceWithVatBetween(double start,double end);


}

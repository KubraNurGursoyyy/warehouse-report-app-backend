package com.testcase.Products.Repository;

import com.testcase.Products.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    List<Products> findAllByWarehouseId(Integer id);

    @Query(value="select * from  products p where  p.products LIKE '% ?#{#name.toLowerCase()}%' OR p.products LIKE'% ?#{#name.toUpperCase()}%'", nativeQuery = true)
    List<Products> findAllProductsByName(@Param("name") String name);

    List<Products> findAllByPurchasePriceBetween(double start,double end);
    List<Products> findAllByPurchasePriceWithVatBetween(double start,double end);
    List<Products> findAllBySalePriceBetween(double start,double end);
    List<Products> findAllBySalePriceWithVatBetween(double start,double end);


}

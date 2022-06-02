package com.testcase.Products.Repository;

import com.testcase.Products.Entity.Products;
import com.testcase.Products.ProductsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
    List<Products> findAllByWarehouseId(Integer id);
//    @Query(value="select p.products, p.quantity, p.purchase_price , p.sale_price , p.purchase_price_with_vat , p.sale_price_with_vat from  Products p where  p.products LIKE '% ?#{#name.toLowerCase()}%' OR p.products LIKE'% ?#{#name.toUpperCase()}%'")

    @Query(value="select new com.testcase.Products.ProductsDTO(p.products, p.quantity, p.purchasePrice , p.purchasePriceWithVat, p.salePrice , p.salePriceWithVat, p.warehouseId) from  Products p where  p.products LIKE '% ?#{#name.toLowerCase()}%' OR p.products LIKE'% ?#{#name.toUpperCase()}%'")
    List<ProductsDTO> findAllProductsByName(@Param("name") String name);

    List<Products> findAllByPurchasePriceBetween(double start,double end);
    List<Products> findAllByPurchasePriceWithVatBetween(double start,double end);
    List<Products> findAllBySalePriceBetween(double start,double end);
    List<Products> findAllBySalePriceWithVatBetween(double start,double end);


}

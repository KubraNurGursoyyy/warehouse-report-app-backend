package com.testcase.Products.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String products;
    private int quantity;
    private double purchasePrice;
    private double purchasePriceWithVat;
    private double salePrice;
    private double salePriceWithVat;
    private int warehouseId;

}

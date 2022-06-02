package com.testcase.Products;

import lombok.Data;

@Data
public class ProductsDTO {
    private final String products;
    private final int quantity;
    private final double purchasePrice;
    private final double purchasePriceWithVat;
    private final double salePrice;
    private final double salePriceWithVat;
    private final int warehouseId;
}

package com.testcase.Report.Entity;

import lombok.Data;

@Data
public class Report {
    private String warehouseName;
    private int totalRangeOfProducts;
    private int totalProductQuantity;
    private int totalProductValueByPurchasePrice;
    private int totalProductValueBySalePrice;
    private int totalProductValueByPurchasePriceWithVAT;
    private int totalProductValueBySalePriceWithVAT;
}

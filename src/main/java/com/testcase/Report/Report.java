package com.testcase.Report;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

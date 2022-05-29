package com.testcase.Report.Service;

import com.testcase.Products.Entity.Products;
import com.testcase.Products.Repository.ProductsRepository;
import com.testcase.Report.Entity.Report;
import com.testcase.Warehouses.Entity.Warehouses;
import com.testcase.Warehouses.Repository.WarehousesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ProductsRepository productsRepository;
    private final WarehousesRepository warehousesRepository;
    public List<Report> makeReport(){
        System.console().printf("Report Servicedeyim");

        final List<Report> reportList = new ArrayList<>();

        for(Warehouses ws:warehousesRepository.findAll()){
            Report report = new Report();
            report.setWarehouseName(ws.getName());
            report.setTotalRangeOfProducts(0);
            report.setTotalProductQuantity(0);
            report.setTotalProductValueByPurchasePrice(0);
            report.setTotalProductValueBySalePrice(0);
            report.setTotalProductValueByPurchasePriceWithVAT(0);
            report.setTotalProductValueBySalePriceWithVAT(0);
            reportList.add(report);
        }
        for(Products product: productsRepository.findAll()){
            for(Report report:reportList){
                if(report.getWarehouseName().equals(warehousesRepository.getById(product.getWarehouseId()).getName())){
                    report.setTotalRangeOfProducts(report.getTotalRangeOfProducts() + 1);
                    report.setTotalProductQuantity(report.getTotalProductQuantity() + product.getQuantity());
                    report.setTotalProductValueByPurchasePrice((int) (report.getTotalProductValueByPurchasePrice() + (product.getPurchasePrice() * product.getQuantity())));
                    report.setTotalProductValueBySalePrice((int) (report.getTotalProductValueBySalePrice() + (product.getSalePrice() * product.getQuantity())));
                    report.setTotalProductValueByPurchasePriceWithVAT((int) (report.getTotalProductValueByPurchasePriceWithVAT() + (product.getPurchasePriceWithVat() * product.getQuantity())));
                    report.setTotalProductValueBySalePriceWithVAT((int) (report.getTotalProductValueBySalePriceWithVAT() + (product.getSalePriceWithVat() * product.getQuantity())));
                }
            }
        }
        return reportList;
    }
}

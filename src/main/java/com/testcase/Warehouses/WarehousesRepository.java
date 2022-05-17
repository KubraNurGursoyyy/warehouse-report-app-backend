package com.testcase.Warehouses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses,Integer> {
}

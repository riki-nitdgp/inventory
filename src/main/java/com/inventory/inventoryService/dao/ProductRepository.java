package com.inventory.inventoryService.dao;

import com.inventory.inventoryService.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
}

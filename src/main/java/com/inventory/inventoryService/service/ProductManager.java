package com.inventory.inventoryService.service;

import com.inventory.inventoryService.dao.ProductRepository;
import com.inventory.inventoryService.exceptions.NotFoundException;
import com.inventory.inventoryService.models.Paginator;
import com.inventory.inventoryService.models.Products;
import com.inventory.inventoryService.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;


    public Products productById(Integer id) throws NotFoundException {

        Optional <Products> products = productRepository.findById(id);

        if (!products.isPresent()) {
            throw new NotFoundException("Product Not Found");
        }

        return products.get();
    }

    public String deleteProductById(Integer id) throws NotFoundException {

        Products product = productById(id);
        productRepository.delete(product);
        return "Product deleted successfully";
    }

    public Products addNewProduct(Products product) {
        return productRepository.save(product);
    }

    public ResponseEntity<Object> allProducts(int pageNo, int pageSize, String sortBy, String sortDir) throws NotFoundException{
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Products> products = productRepository.findAll(pageable);
        List<Products> listOfProduct = products.getContent();
        Paginator paginator = new Paginator(products.getNumber(), products.getSize(), products.getTotalElements(),
                products.getTotalPages(), products.isLast());

        return ResponseHandler.generateResponse(listOfProduct, paginator);
    }
}

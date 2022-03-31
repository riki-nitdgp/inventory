package com.inventory.inventoryService.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products", indexes = @Index(name = "idx_name", columnList = "name"))
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Product Name is Mandatory")
    @Size(min=3, max=100, message="Name Should be between 2 and 100")
    private String name;

    @Size(min=3, max=1000, message="Name Should be between 2 and 1000")
    private String details;

    @NotNull(message = "Product Price Name is Mandatory")
    private Integer price;

}

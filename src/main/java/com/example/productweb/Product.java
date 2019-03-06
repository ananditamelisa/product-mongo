package com.example.productweb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productID;
    private String name;
    private String category;
    private int stock;
    @JsonProperty("class")
    private String clazz;

}

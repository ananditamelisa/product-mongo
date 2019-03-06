package com.example.productweb.controller;

import com.example.productweb.Product;
import com.example.productweb.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    //    @RequestMapping(
//            value="/",
//    method = RequestMethod.GET,
//    produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public Product product(){
//        return new Product("a01", "rinso", "detergent", 10, "ekonomis");
//    }

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product create (@RequestBody Product product){
        return productService.create(product);
    }

    @RequestMapping(
            value="/products/{idProduct}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findById(@PathVariable("idProduct") String id){
        return productService.findById(id);
    }
    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll(){
        return productService.findAll();
    }
    @RequestMapping(
            value = "/products/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody  Product product){
        return productService.update(product);
    }
    @RequestMapping(
            value = "/deleteProduct/{idProduct}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable("idProduct") String id){
        return productService.delete(id);
    }

}

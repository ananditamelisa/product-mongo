package com.example.productweb.service;

import com.example.productweb.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{
    private ArrayList<Product> list = new ArrayList<>();
    @Override
    public Product create(Product product) {
        if(findById(product.getProductID())==null){
            list.add(product);
            return product;
        }
        return null;
    }

    @Override
    public Product findById(String id) {
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getProductID().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product update(Product product) {
        Product temp = findById(product.getProductID());
        if(temp==null) return null;
        list.set(list.indexOf(temp), product);
        return product;
    }

    @Override
    public Product delete(String id) {
        Product pr = findById(id);
        if(pr==null){
            return null;
        }
        list.remove(findById(id));
        return pr;
    }
}

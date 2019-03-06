package com.example.productweb;

import com.example.productweb.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceImplTest {
    private ProductServiceImpl service;
    @Before
    public void setUp() throws Exception{
        service = new ProductServiceImpl();
    }

    @Test
    public void testCreate(){
        Product product = new Product("1", "rinso", "detergent", 50, "ekonomis");
        service.create(product);
        Assert.assertTrue("Total harus ada 1", service.findAll().size()==1);
        Product temp = service.findById("1");
        Assert.assertTrue("product harus ada", product ==temp);
    }
    @Test
    public void testFindById(){
        ProductServiceImpl service = new ProductServiceImpl();
        Product product = service.findById("kosong");
        Assert.assertTrue("Product harus null", product==null);
        Product temp = service.create(new Product("1", "baju", "fashion", 14,
                "bussiness"));
        product = service.findById("1");
        Assert.assertTrue("product dgn id 1 hrs ada", temp==product);
    }

    public void testUpdateProduct(){
        service.create(new Product("1", "blueband", "cooking", 60, "ekonomis"));
        service.update(new Product("1", "mentega", "cooking", 57, "ekonomis"));
        Product product = service.findById("1");
        Assert.assertTrue(product.getName().equals("mentega"));
    }
    @Test
    public void testDelete(){
        service.create(new Product("1", "blueband", "cooking", 60, "ekonomis"));
        service.create(new Product("2", "rinso", "cleanser", 50, "ekonomis"));
        service.create(new Product("3", "baju", "fashion", 40, "casual"));
        service.create(new Product("4", "kulkas", "electronic", 60, "new arrival"));
        service.delete("3");
        Assert.assertTrue("total product harus 3", service.findAll().size()==3);
        Assert.assertTrue("product baju harusnya gaada", service.findById("3")==null);
    }

}

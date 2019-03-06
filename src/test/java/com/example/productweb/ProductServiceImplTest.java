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
        Product product2 = new Product("1", "sokilin", "detergent",
                50, "ekonomis");
        service.create(product);
        Assert.assertTrue("Total harus ada 1", service.findAll().size()==1);
        Assert.assertTrue("harusnya gabisa bikin product dgn id yg sama",
                service.create(product2)==null );
        Product temp = service.findById("1");
        Assert.assertTrue("product harus ada", product ==temp);
    }
    @Test
    public void testFindById(){
        Product temp = service.create(new Product("1", "baju", "fashion", 14,
                "bussiness"));
        Product product = service.findById("1");
        Assert.assertTrue("product dgn id 1 hrs ada", temp==product);
        service.delete("1");
        Assert.assertTrue("product dgn id 1 harusnya gaketmu", service.findById("1")==null);
    }
    @Test
    public void testFindByIdNotExist(){
        ProductServiceImpl service = new ProductServiceImpl();
        Product product = service.findById("kosong");
        Assert.assertTrue("Product harus null", product==null);
    }

    @Test
    public void testFindAll(){
        Assert.assertTrue("total product harus 0", service.findAll().size()==0);
        service.create(new Product("1", "blueband", "cooking", 60, "ekonomis"));
        service.create(new Product("2", "rinso", "cleanser", 50, "ekonomis"));
        service.create(new Product("3", "baju", "fashion", 40, "casual"));
        service.create(new Product("4", "kulkas", "electronic", 60, "new arrival"));
        Assert.assertTrue("total product harus ada 4", service.findAll().size()==4);
    }

    @Test
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
        Assert.assertTrue("total product harus 4", service.findAll().size()==4);
        service.delete("3");
        Assert.assertTrue("total product harus 3", service.findAll().size()==3);
        Assert.assertTrue("product baju harusnya gaada", service.findById("3")==null);
        Assert.assertTrue("harusnya gabisa delete id 5", service.delete("5")==null);
    }

}

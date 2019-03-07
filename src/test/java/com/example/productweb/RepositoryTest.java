package com.example.productweb;

import com.example.productweb.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product p,p2,p3,create,create2,create3, updated;

    @Before
    public void setUp() throws Exception{
        p = new Product();
        p.setCategory("Electronic");
        p.setClazz("Import");
        p.setName("Sony Refrigerator");
        p.setPrice(1000000);
        p.setStock(500);
        create = productRepository.save(p);

        p2 = new Product();
        p2.setCategory("Fashion");
        p2.setClazz("Import");
        p2.setName("Zara Cardigan");
        p2.setPrice(350000);
        p2.setStock(100);
        create2 = productRepository.save(p2);

        p3 = new Product();
        p3.setCategory("Cooking");
        p3.setClazz("Economic");
        p3.setName("Blueband Butter");
        p3.setPrice(15000);
        p3.setStock(1500);
        create3 = productRepository.save(p3);
    }

    @Test
    public void testFindAll(){
        Assert.assertTrue("harusnya total member ada 3", productRepository.findAll().size()==3);
    }
    @Test
    public void testCreate(){
        Assert.assertTrue("yg di insert harus sama dgn yg di create", p==create);

    }
    @Test
    public void testUpdate(){
        p2 = new Product();
        p2.setProductID(p.getProductID());
        p2.setCategory("Fashion");
        p2.setClazz("Import");
        p2.setName("Zara Coat");
        p2.setPrice(550000);
        p2.setStock(100);
        updated = productRepository.save(p2);

        Assert.assertTrue("member harus terupdate",
                updated.getProductID()==create.getProductID());

    }

    @Test
    public void testFindById(){
        Optional<Product> byId = productRepository.findById(create3.getProductID());
        if(byId.isPresent()){
            Assert.assertTrue("harusnya product p3 bisa ketemu",
                    byId.get().getName().equals("Blueband Butter"));
        }
    }
    @Test
    public void testDelete(){
        productRepository.deleteById(create2.getProductID());

        Boolean checkExists = productRepository.existsById(create2.getProductID());
        Assert.assertTrue("categoryShouldNULL Should Null",checkExists == false);
    }

}

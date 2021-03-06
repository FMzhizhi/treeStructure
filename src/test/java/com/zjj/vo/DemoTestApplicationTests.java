package com.zjj.vo;

import com.zjj.dao.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTestApplicationTests {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void contextLoads() {
        List<Product> allUsers = productMapper.getAll();
        System.out.println(allUsers);
    }

}

package com.sir.springbootdemo;

import com.sir.springbootdemo.Service.SysuserService;
import com.sir.springbootdemo.beans.pojo.Sysuser;
import com.sir.springbootdemo.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootdemoApplicationTests {
    @Autowired
    private SysuserService sysuserService;
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void Test() {
       show(sysuserService.GetList());
    }
    @Test
    public void show( ArrayList<Sysuser> sysuserArrayList){
        for (Sysuser sysuser : sysuserArrayList) {
            System.out.println(sysuser);
        }
    }

    @Test
    public void do5(){
        String k="test:20210308terw";
        System.out.println(redisUtils.get(k));
    }

}

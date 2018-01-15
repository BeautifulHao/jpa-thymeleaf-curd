package com.demo;

import com.demo.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaThymeleafApplication.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("someName", "fuhao");
        Assert.assertEquals("fuhao", stringRedisTemplate.opsForValue().get("someName"));
    }

    @Test
    public void testObj() throws Exception {

        Employee employee = new Employee("fuHao", "123456", 20,"remark","");
        ValueOperations<String, Employee> operations=redisTemplate.opsForValue();
        operations.set("EMP", employee);
        operations.set("EMP.Temp", employee,1, TimeUnit.SECONDS);
        Thread.sleep(1000);

        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("EMP.Temp");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

        Assert.assertEquals("fuHao", operations.get("EMP").getEmployeeName());
    }
}

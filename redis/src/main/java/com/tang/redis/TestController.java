package com.tang.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author tang
 * @Date 2019-03-12 21:25
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "add")
    public void add(){
        redisUtils.set("test", "11111");
    }
}

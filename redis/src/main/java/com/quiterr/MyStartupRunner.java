package com.quiterr;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * Created by huangchen on 2016/5/19.
 */

@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    RedisService redisService;
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);

    @Override
    public void run(String... args) throws Exception {
        redisService.set("test","test");
        logger.info(redisService.get("test"));
    }
}

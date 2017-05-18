package com.quiterr;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Huangchen on 2017/5/18.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}

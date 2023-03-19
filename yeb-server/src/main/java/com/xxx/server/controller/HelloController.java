package com.xxx.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Keafmd
 *
 * @ClassName: HelloController
 * @Description: 测试
 * @author: liuchen
 * @date: 2022/4/12 11:38
 * @Blog:
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

}

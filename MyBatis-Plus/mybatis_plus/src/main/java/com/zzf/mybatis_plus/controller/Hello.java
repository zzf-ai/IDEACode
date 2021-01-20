package com.zzf.mybatis_plus.controller;

/*
 *
 *@author:zzf
 *@time:2021-01-19
 *
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
}

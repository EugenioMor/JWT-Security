package com.application.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestAuthController {

    @GetMapping("/get")
    public String helloGet(){
        return "Hello world - GET";
    }

    @PostMapping("/post")
    public String helloPost(){
        return "Hello world - POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello world - PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello world - DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch(){
        return "Hello world - PATCH";
    }
}

package com.pragra.learning.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/docker")
public class HelloDockerController {

    @GetMapping
    public String getName() { return "Hello Docker!"; }
}

package com.saas.app.toll.orders.controller;


import com.saas.app.toll.orders.model.request.TollOrderRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toll")
public class TollController {

    @PostMapping("/order")
    void createTollOrder(@Valid TollOrderRequest tollOrderRequest){


    }

    @GetMapping("/hello")
    String get(){
        return "Hello World";
    }
}

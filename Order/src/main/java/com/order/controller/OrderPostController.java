package com.order.controller;

import com.order.dto.OrderPostDTO;
import com.order.service.OrderPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderPostController {

    @Autowired
    private OrderPostService orderPostService;

    @PostMapping()
    public ResponseEntity postOrder(@RequestBody OrderPostDTO orderPostDTO){
        orderPostService.createOrder(orderPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

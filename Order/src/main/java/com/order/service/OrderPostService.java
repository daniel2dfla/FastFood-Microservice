package com.order.service;

import com.order.dto.OrderPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderPostService {

    void createOrder(OrderPostDTO orderPostDTO);
}

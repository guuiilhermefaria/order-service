package com.example.order_service.client;

import com.example.order_service.model.dto.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service", url = "http://localhost:8081") // Adjust URL as necessary
public interface ItemClient {
    @GetMapping("/items/{id}")
    ItemDTO getItem(@PathVariable("id") Long id);
}

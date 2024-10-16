package com.example.order_service.service;

import com.example.order_service.client.ItemClient;
import com.example.order_service.model.dto.ItemDTO;
import com.example.order_service.model.dto.OrderDTO;
import com.example.order_service.model.entity.OrderEntity;
import com.example.order_service.model.request.OrderRequest;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.order_service.mapper.OrderRequestMapper.ORDER_REQUEST_MAPPER;
import static com.example.order_service.mapper.OrderResponseMapper.ORDER_ENTITY_TO_ORDER_DTO;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemClient itemClient;

    public OrderDTO createOrder(OrderRequest orderRequest) {
        if (orderRequest.getItemId() == null) {
            return null;
        }

        ItemDTO item = itemClient.getItem(orderRequest.getItemId());
        orderRequest.setItemName(item.getName());

        OrderEntity orderEntity = ORDER_REQUEST_MAPPER.requestToOrder(orderRequest);

        return ORDER_ENTITY_TO_ORDER_DTO.orderEntitiesToOrderDtos(orderRepository.save(orderEntity));
    }

    public OrderDTO updateOrder(Long id, OrderRequest orderRequest) {
        orderRequest.setId(id);
        OrderEntity orderEntity = ORDER_REQUEST_MAPPER.requestToOrder(orderRequest);

        return ORDER_ENTITY_TO_ORDER_DTO.orderEntitiesToOrderDtos(orderRepository.save(orderEntity));
    }

    public List<OrderDTO> getAllOrders() {
        return ORDER_ENTITY_TO_ORDER_DTO.orderEntitiesToOrderDtos(orderRepository.findAll());
    }

    public OrderDTO getOrder(Long id) {
        return ORDER_ENTITY_TO_ORDER_DTO.orderEntitiesToOrderDtos(orderRepository.findById(id).orElse(null));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }

        orderRepository.deleteById(id);
    }
}

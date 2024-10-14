package com.example.order_service.mapper;

import com.example.order_service.model.entity.OrderEntity;
import com.example.order_service.model.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderRequestMapper {
    OrderRequestMapper ORDER_REQUEST_MAPPER = Mappers.getMapper(OrderRequestMapper.class);

    OrderEntity requestToOrder(OrderRequest orderRequest);
}

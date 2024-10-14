package com.example.order_service.mapper;

import com.example.order_service.model.dto.OrderDTO;
import com.example.order_service.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderResponseMapper {
    OrderResponseMapper ORDER_ENTITY_TO_ORDER_DTO = Mappers.getMapper(OrderResponseMapper.class);

    OrderDTO orderEntitiesToOrderDtos(OrderEntity orderEntity);

    List<OrderDTO> orderEntitiesToOrderDtos(List<OrderEntity> orderEntities);
}

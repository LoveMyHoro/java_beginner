package com.horo.mapper;

import com.horo.pojo.Order;

public interface OrderMapper {
  Order queryOrderById(Integer orderId);
}
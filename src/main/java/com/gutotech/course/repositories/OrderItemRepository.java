package com.gutotech.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutotech.course.entities.OrderItem;
import com.gutotech.course.entities.OrderItemId;

public interface OrderItemRepository 
	extends JpaRepository<OrderItem, OrderItemId> {

}

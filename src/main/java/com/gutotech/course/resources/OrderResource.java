package com.gutotech.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.course.entities.Order;
import com.gutotech.course.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> Orders = service.findAll();
		return ResponseEntity.ok(Orders);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

}

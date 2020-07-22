package com.gutotech.course.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gutotech.course.entities.Category;
import com.gutotech.course.entities.Order;
import com.gutotech.course.entities.OrderItem;
import com.gutotech.course.entities.Payment;
import com.gutotech.course.entities.Product;
import com.gutotech.course.entities.User;
import com.gutotech.course.entities.enums.OrderStatus;
import com.gutotech.course.repositories.CategoryRepository;
import com.gutotech.course.repositories.OrderItemRepository;
import com.gutotech.course.repositories.OrderRepository;
import com.gutotech.course.repositories.ProductRepository;
import com.gutotech.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Maria Brown", "maria@gmail.com",
				"988888888", "123456");
		User user2 = new User("Alex Green", "alex@gmail.com",
				"977777777", "123456");
		userRepository.saveAll(List.of(user1, user2));

		Order order1 = new Order(Instant.parse("2019-06-20T19:53:07Z"),
				OrderStatus.PAID, user1);
		Order order2 = new Order(Instant.parse("2019-07-21T03:42:10Z"),
				OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(Instant.parse("2019-07-22T15:21:22Z"),
				OrderStatus.WAITING_PAYMENT, user1);
		orderRepository.saveAll(List.of(order1, order2, order3));
		
		Category cat1 = new Category("Electronics");
		Category cat2 = new Category("Books");
		Category cat3 = new Category("Computers"); 
		categoryRepository.saveAll(List.of(cat1, cat2, cat3));
	
		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		p1.getCategories().add(cat2);
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		productRepository.saveAll(List.of(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(order3, p5, 2, p5.getPrice());
		orderItemRepository.saveAll(List.of(oi1, oi2, oi3, oi4));
	
		Payment pay = new Payment(0, Instant.parse("2019-06-20T21:53:07Z"), order1);
		order1.setPayment(pay);
		orderRepository.save(order1);
	}

}

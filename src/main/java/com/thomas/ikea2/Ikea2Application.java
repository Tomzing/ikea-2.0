package com.thomas.ikea2;

import com.thomas.ikea2.model.*;
import com.thomas.ikea2.repository.CategoryFoodRepository;
import com.thomas.ikea2.repository.CategoryFurnitureRepository;
import com.thomas.ikea2.repository.CategoryTextilesRepository;
import com.thomas.ikea2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ikea2Application implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Ikea2Application.class, args);
	}

	@Autowired
	CategoryFoodRepository foodRepository;

	@Autowired
	CategoryFurnitureRepository furnitureRepository;

	@Autowired
	CategoryTextilesRepository textilesRepository;

	@Autowired
	OrderRepository orderRepository;



	@Override
	public void run(String... args) throws Exception {

		CategoryFood productHotdog1 = new CategoryFood("Chili", new Product("Chili dog","A chili flavored hotdog", 20));
		foodRepository.save(productHotdog1);
		CategoryFood productHotdog2 = new CategoryFood("Cheese", new Product("Cheesy dog","A cheese flavored hotdog", 25));
		foodRepository.save(productHotdog2);

		CategoryFurniture productFurniture1 = new CategoryFurniture(1, 2.51F, new Product("Cat shaped shelf", "For all your feline needs", 200));
		furnitureRepository.save(productFurniture1);

		CategoryTextiles productTextile1 = new CategoryTextiles(444,"black", new Product("Night rug","A pitch black rug, beware black cats on it", 100));
		textilesRepository.save(productTextile1);
		
		Order order1 = new Order();
		order1.getProductSet().add(productHotdog1.getProduct());
		order1.setOrderTotal(productHotdog1.getProduct().getPrice());
		orderRepository.save(order1);

		Order order2 = new Order();
		order2.getProductSet().add(productFurniture1.getProduct());
		order2.setOrderTotal(productFurniture1.getProduct().getPrice());
		orderRepository.save(order2);

	}
}

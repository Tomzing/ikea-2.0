package com.thomas.ikea2;

import com.thomas.ikea2.model.CategoryFood;
import com.thomas.ikea2.model.CategoryFurniture;
import com.thomas.ikea2.model.CategoryTextiles;
import com.thomas.ikea2.model.Product;
import com.thomas.ikea2.repository.CategoryFoodRepository;
import com.thomas.ikea2.repository.CategoryFurnitureRepository;
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

	//@Autowired
	//CategoryTextiles textilesRepository;

	@Override
	public void run(String... args) throws Exception {

		CategoryFood productHotdog1 = new CategoryFood("Chili", new Product("Chili dog","A chili flavored hotdog", 20));
		foodRepository.save(productHotdog1);
		CategoryFood productHotdog2 = new CategoryFood("Cheese", new Product("Cheesy dog","A cheese flavored hotdog", 25));
		foodRepository.save(productHotdog2);

		CategoryFurniture productFurniture1 = new CategoryFurniture(1, 2.51F, new Product("Cat shaped shelf", "For all your feline needs", 200));
		furnitureRepository.save(productFurniture1);

	}
}

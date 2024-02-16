package com.pcbuilder.pcbuilder.products;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PcbuilderProductsApplication {

	public static void main(String[] args) {

		SpringApplication.run(PcbuilderProductsApplication.class, args);
		MongoClient client = MongoClients.create("mongodb://localhost:27017");
	}

}

package com.pcbuilder.pcbuilder.products.repository;


import com.pcbuilder.pcbuilder.products.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

}

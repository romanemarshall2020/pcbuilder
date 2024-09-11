package com.pcbuilder.pcbuilder.products.service;

import com.pcbuilder.pcbuilder.products.exceptions.ConflictException;
import com.pcbuilder.pcbuilder.products.exceptions.UserException;
import com.pcbuilder.pcbuilder.products.models.Category;
import com.pcbuilder.pcbuilder.products.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    // CRUD
    @Autowired
    private CategoryRepository repo;

    // Create update
    public Category save(Category toSave) {
        List<Category> existingCategories = repo.findAll();
        boolean duplicateExists = existingCategories.stream().anyMatch(existingCat -> existingCat.getName().equalsIgnoreCase(toSave.getName()));

        if (duplicateExists) {
            throw new ConflictException("Category already exists");
        }
        if(toSave == null){
            throw new UserException("Entry is null");
        }
        if (toSave.getName() == null){
            throw  new UserException("Category name is null");
        }
        if (toSave.getName().isBlank()){
            throw  new UserException("Category name is blank");
        }

        Category saved = repo.save(toSave);

        return saved;
    }

    public List<Category> list() { 

        return repo.findAll();
    }

    public  Optional<Category> get(String id) {
        if(id == null){
            throw new UserException("Entry is null");
        }
        if(id == "") {
            throw new UserException("Entry is blank");
        }
        Optional<Category> returnedCategory = repo.findById(id);
        return returnedCategory;
    }






}

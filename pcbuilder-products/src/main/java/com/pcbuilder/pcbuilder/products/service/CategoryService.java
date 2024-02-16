package com.pcbuilder.pcbuilder.products.service;

import com.pcbuilder.pcbuilder.products.models.Category;
import com.pcbuilder.pcbuilder.products.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    // CRUD
    @Autowired
    private CategoryRepository repo;

    // Create update
    public Category save(Category toSave) {
        return null;
    }

    public List<Category> list() {
        return null;
    }

    public  Category get(String id) {
        return null;
    }






}

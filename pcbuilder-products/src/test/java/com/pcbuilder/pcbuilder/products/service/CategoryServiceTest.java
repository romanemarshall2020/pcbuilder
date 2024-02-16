package com.pcbuilder.pcbuilder.products.service;

import com.pcbuilder.pcbuilder.products.models.Category;
import com.pcbuilder.pcbuilder.products.repository.CategoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    @InjectMocks
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository repo;

    // will need spy on repo
    public void testSave() throws Exception {
        // step one: set up given data
        List<Category> existingCats; // create a list of categories

        when(repo.findAll()).thenReturn(existingCats);

        // step two: set up any expected data


        // step three: set up your input data

        // step four: call the service

        // step five: test the output

        // step six: test any state change

        // step seven: clean up


            }

}

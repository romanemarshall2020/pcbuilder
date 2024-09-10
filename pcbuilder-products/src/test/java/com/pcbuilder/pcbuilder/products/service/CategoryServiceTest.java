package com.pcbuilder.pcbuilder.products.service;

import com.pcbuilder.pcbuilder.products.exceptions.ConflictException;
import com.pcbuilder.pcbuilder.products.exceptions.UserException;
import com.pcbuilder.pcbuilder.products.models.Category;
import com.pcbuilder.pcbuilder.products.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    @InjectMocks
    private CategoryService categoryService;

    // will need spy on repo
    @MockBean
    @SpyBean
    private CategoryRepository repo;



    @Test
    public void testCreate() throws Exception {

        // step one: set up given data
        Category outputCat = new Category();
        outputCat.setId("1");
        outputCat.setName("GPU");

        when(repo.save(any(Category.class))).thenReturn(outputCat);

        // step two: set up any expected data
        Category expectedCat = new Category();
        expectedCat.setId("1");
        expectedCat.setName("GPU");


        // step three: set up your input data
        Category inputCat = new Category();
        inputCat.setName("GPU");

        // step four: call the service
        Category actualCat = categoryService.save(inputCat);

        // step five: test the output
        assertEquals(expectedCat.getId(), actualCat.getId());
        assertEquals(expectedCat.getName(), actualCat.getName());

        // step six: test any state change
        verify(repo, times(1)).save(any());

        // step seven: clean up


    }



    // what happens if we save null
    @Test
    public void testSavedNull() {
        // step two: set up expectations
        String expectedMessage = "Entry is null";

//        step 3:
        Category inputCat = null;

        //step 4
        try {
            categoryService.save(inputCat);
            fail("failed to throw userException on null input");
        } catch (UserException e){
            // step 5
            assertEquals(expectedMessage, e.getMessage());
        }

        // step 6: verify
        verify(repo, times(0)).save(any());
    }

    // what if name is null
    @Test
    public void testNameIsNull() {
        // step two: set up expectations
        String expectedMessage = "Category name is null";

        // step 3: set up your input data
        Category inputCat = new Category();
        inputCat.setName(null);

        // step four: call the service
        try {
            categoryService.save(inputCat);
            fail("failed to throw userException on Category name being null");
        } catch (UserException e) {
            // step five: test the output
            assertEquals(expectedMessage, e.getMessage());
        }

        // step 6: verify
        verify(repo, times(0)).save(any());

    }

    // what if name is blank
    @Test
    public void testNameIsBlank() {
        // step two: set up expectations
        String expectedMessage = "Category name is blank";

        // step 3: set up your input data
        Category inputCat = new Category();
        inputCat.setName("");

        // step four: call the service
        try {
            categoryService.save(inputCat);
            fail("failed to throw userException on Category name being blank");
        } catch (UserException e) {
            // step five: test the output
            assertEquals(expectedMessage, e.getMessage());
        }

        // step 6: verify
        verify(repo, times(0)).save(any());


    }

    @Test
    public void testNameIsSpace() {
        // step two: set up expectations
        String expectedMessage = "Category name is blank";

        // step 3: set up your input data
        Category inputCat = new Category();
        inputCat.setName(" ");

        // step four: call the service
        try {
            categoryService.save(inputCat);
            fail("failed to throw userException on Category name being blank");
        } catch (UserException e) {
            // step five: test the output
            assertEquals(expectedMessage, e.getMessage());
        }

        // step 6: verify
        verify(repo, times(0)).save(any());


    }

    // adding a duplicate name
    @Test
    public void testSavingDuplicate() {
        // step one: set up given data
        // will need to make a new method for finding (look for find by example)
        when(repo.findAll()).thenReturn(reusableCats());

        // step two: set up expectations
        String expectedMessage = "Category already exists";

        // step 3: set up your input data
        Category gpuCat = new Category();
        gpuCat.setName("GPU");


        // step four: call the service

        try {
            categoryService.save(gpuCat);
            fail("failed to throw conflict exception due to duplicate name");
        } catch (ConflictException e) {
            // step five: test the output
            assertEquals(expectedMessage, e.getMessage());
        }
        // step six:
        verify(repo, times(0)).save(any());



    }

    
    public List<Category> reusableCats(){
        Category gpuCat = new Category();
        gpuCat.setId("1");
        gpuCat.setName("GPU");

        Category cpuCat = new Category();
        cpuCat.setId("2");
        cpuCat.setName("CPU");

        Category casesCat = new Category();
        casesCat.setId("3");
        casesCat.setName("Cases");



        return List.of(gpuCat, cpuCat,casesCat);
    }


    @Test
    public void testListCat() {
        // step one: set up given data
        when(repo.findAll()).thenReturn(reusableCats());

        // step two: set up any expected data
        List<Category> expected = reusableCats();

        System.out.println("Listed categories: " + expected);

        // step four: call the service
        List<Category> actual = categoryService.list();

        // step five: verify
        assertNotNull(actual);
        assertEquals(expected, actual);
        for(Category c : actual){
            assertGoodCategory(c);
        }

        // verify that repo was called
        verify(repo, times(1)).findAll();

    }

    // Reuseable assertion method
    private void assertGoodCategory(Category c) {
        assertNotNull(c);
        assertNotNull(c.getName());
        assertFalse(c.getName().isBlank());
        assertNotNull(c.getId());
        assertFalse(c.getId().isBlank());
    }


    // Zero Case

    // one Zase

    //








}

package com.example.recipe.ingredient.service;

import com.example.recipe.ingredient.dto.request.IngredientRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class IngredientServiceTest {
    @Autowired
    private IngredientService ingredientService;

    @Test
    void save() {
        IngredientRequest req = new IngredientRequest(1l,"ksh","type","ksh type");
        ingredientService.save(req);
    }

    @Test
    void getAll() {

    }

    @Test
    void getById() {
    }

    @Test
    void getDescriptionById() {
    }

    @Test
    void update() {
    }
}
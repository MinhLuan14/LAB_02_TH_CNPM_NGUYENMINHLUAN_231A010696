package com.example.saleappv1.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.saleappv1.Model.Category;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Service
public class CategoryService {

    private final ObjectMapper objectMapper;

    public CategoryService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Category> getCategories() {

        try {

            InputStream inputStream =
                    getClass().getResourceAsStream("/data/category.json");

            if (inputStream == null) {
                System.out.println("KHONG TIM THAY category.json");
                return new ArrayList<>();
            }

            return objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Category>>() {}
            );

        } catch (Exception e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
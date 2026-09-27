package com.example.saleappv1.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.saleappv1.Model.Product;
import com.example.saleappv1.Service.CategoryService;
import com.example.saleappv1.Service.ProductService;

@Controller
public class HomeController {

    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("categories",
                categoryService.getCategories());

        return "index";
    }
}
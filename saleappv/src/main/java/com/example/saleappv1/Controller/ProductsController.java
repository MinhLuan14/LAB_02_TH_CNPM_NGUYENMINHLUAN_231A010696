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
public class ProductsController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductsController(ProductService productService,
                             CategoryService categoryService) {

        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("products",
                productService.getProduct());

        model.addAttribute("categories",
                categoryService.getCategories());

        return "web/Product";
    }

    // Sản phẩm theo danh mục
    @GetMapping("/products/category/{id}")
    public String productsByCategory(@PathVariable int id,
                                     Model model) {

        List<Product> products = productService.getProduct()
                .stream()
                .filter(p -> p.getCategoryID() == id)
                .toList();

        model.addAttribute("products", products);
        model.addAttribute("categories",
                categoryService.getCategories());

        return "web/Product";
    }
    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable int id,
                                Model model) {

        Product product = productService.getProductByID(id);

        model.addAttribute("product", product);

        return "web/ProductDetail";
    }
}
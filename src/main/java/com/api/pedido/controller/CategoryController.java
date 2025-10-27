package com.api.pedido.controller;


import com.api.pedido.model.Category;
import com.api.pedido.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    private ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }
}

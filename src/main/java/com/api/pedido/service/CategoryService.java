package com.api.pedido.service;


import com.api.pedido.model.Category;
import com.api.pedido.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public  List<Category> findAll(){

        return categoryRepository.findAll();
    }

    public Category findById(Long id){

        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
    }
}

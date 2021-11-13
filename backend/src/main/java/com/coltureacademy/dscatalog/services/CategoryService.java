package com.coltureacademy.dscatalog.services;

import com.coltureacademy.dscatalog.dto.CategoryDTO;
import com.coltureacademy.dscatalog.entities.Category;
import com.coltureacademy.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list =repository.findAll();
        return list.stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());
    }
}

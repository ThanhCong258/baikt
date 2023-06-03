package com.example.kiethuynh.services;

import com.example.kiethuynh.entity.Book;
import com.example.kiethuynh.entity.Category;
import com.example.kiethuynh.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;


    public List<Category> getAllCategories(){ return iCategoryRepository.findAll();}
    public Category getCategoryById(Long id)
    {
        Optional<Category> optionalCategory = iCategoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else{
            throw new RuntimeException("Category not found");
        }
    }

    public Category saveCategory(Category category){ return iCategoryRepository.save(category);}
    public Category createCategory(Category category){ return iCategoryRepository.save(category);}
    public  void  updateCategory(Category category) { iCategoryRepository.save(category);}
    public void deleteCategory(Long id) { iCategoryRepository.deleteById(id);}

}

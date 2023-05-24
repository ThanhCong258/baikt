package com.example.kiethuynh.repository;

import com.example.kiethuynh.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}

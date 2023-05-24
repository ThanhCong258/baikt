package com.example.kiethuynh.repository;

import com.example.kiethuynh.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

}

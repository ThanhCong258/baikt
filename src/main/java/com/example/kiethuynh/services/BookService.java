package com.example.kiethuynh.services;

import com.example.kiethuynh.entity.Book;
import com.example.kiethuynh.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository ibookRepository;

    public List<Book> getAllBooks(){
        return ibookRepository.findAll();
    }
    public Book getBookById(Long id){
        Optional<Book> optional = ibookRepository.findById(id);
        return optional.orElse(null);
    }
    public void addBook(Book book){
        ibookRepository.save(book);
    }
    public void updateBook(Book book){
        ibookRepository.save(book);
    }
    public void deleteBook(Long id){
        ibookRepository.deleteById(id);
    }
}

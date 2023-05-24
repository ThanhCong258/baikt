package com.example.kiethuynh.controller;
import jakarta.validation.Valid;

import com.example.kiethuynh.entity.Book;
import com.example.kiethuynh.services.BookService;
import com.example.kiethuynh.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model){
        Book editBook = bookService.getBookById(id);
        if (editBook!=null){
            model.addAttribute("book", editBook);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public  String editBook(@Valid @ModelAttribute("book")Book updateBook, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAllCategories());
            return "book/edit";
        }
        bookService.getAllBooks().stream()
                .filter(book -> book.getId() == updateBook.getId())
                .findFirst()
                .ifPresent(book -> bookService.getAllBooks().set(bookService.getAllBooks().indexOf(book), updateBook));
        return "redirect:/books";

    }



    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }


    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "book/list";
    }
}

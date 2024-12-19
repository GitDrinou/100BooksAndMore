package com.drinounet._BooksAndMore.controller;

import com.drinounet._BooksAndMore.datas.Book;
import com.drinounet._BooksAndMore.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("books", booksService.getAllBooks());
        return "index";
    }

    @PostMapping("/addbook")
    public String addBook(Book book, BindingResult result, Model model) {
     if (result.hasErrors()) {
         return "error";
     }
        booksService.saveBook(book);
        return "redirect:/index";
    }

    @PutMapping("/edit/{id}")
    public String editBook(Book book, @PathVariable int id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        booksService.editBook(id, book);
        return "redirect:/index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        booksService.deleteBook(id);
        return "redirect:/index";
    }

}

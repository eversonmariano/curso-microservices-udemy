package br.com.everson.controller;

import br.com.everson.model.Book;
import br.com.everson.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;


    @Autowired
    private BookRepository repository;


    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");

        var port = environment.getProperty("local.server.port");
        return book;


    }

}

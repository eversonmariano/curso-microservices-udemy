package br.com.everson.controller;

import br.com.everson.model.Book;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d

import br.com.everson.repository.BookRepository;


<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
import br.com.everson.repository.BookRepository;
=======
>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import java.util.Date;


<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d

    @Autowired
    private BookRepository repository;


<<<<<<< HEAD
=======
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

=======
<<<<<<< HEAD
    @Autowired
    private BookRepository repository;

=======
>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");

<<<<<<< HEAD
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found");

        var port = environment.getProperty("local.server.port");
        return book;
<<<<<<< HEAD


=======
=======
        var port = environment.getProperty("local.server.port");
<<<<<<< HEAD
        return book;


=======
        return new Book(
                1L, "Nigel Poulton",
                "Docker Deep Dive", new Date(),
                Double.valueOf(13.7), currency, port
        );
>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
    }

}

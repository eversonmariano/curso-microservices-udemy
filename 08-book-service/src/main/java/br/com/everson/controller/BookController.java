package br.com.everson.controller;

import br.com.everson.model.Book;
import br.com.everson.proxy.CambioProxy;
import br.com.everson.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @Operation(summary = "Find a specific book by ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findById(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency) {


        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found!");

        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(
                  "Book port" + port
                + "Cambio port: " + cambio.getEnvironment());

        book.setPrice(cambio.getConvertedValue());
        return book;
    }

    //Abaixo temos a função que faz com que uma API consuma outra API

/*    @GetMapping(value = "/{id}/{currency}", produces = { "application/json" })
    public Book findById(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency) {

        String port = environment.getProperty("local.server.port");

        Book book = repository.getById(id);

        HashMap<String, String> params = new HashMap<>();

        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate()
                .getForEntity("http://localhost:8000/cambio-service/"
                                + " {amount}/{from}/{to}",
                        Cambio.class, params);

        Cambio cambio = response.getBody();
        book.setEnvironment(port);
        book.setPrice(cambio.getConvertedValue());
        book.setCurrency(currency);
        return book;
    }*/





}

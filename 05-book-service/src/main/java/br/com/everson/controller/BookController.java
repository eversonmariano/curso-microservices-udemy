package br.com.everson.controller;

import br.com.everson.model.Book;
import br.com.everson.proxy.CambioProxy;
import br.com.everson.repository.BookRepository;
import br.com.everson.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Proxy;
import java.util.HashMap;


@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "/{id}/{currency}", produces = { "application/json" })
    public Book findById(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency) {


        var book = repository.getById(id);
        if (book == null) throw new RuntimeException("Book not found!");

        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port + "FEIGN");
        book.setPrice(cambio.getConvertedValue());
        return book;
    }

    //Abaixo temos a função que faz com que uma API consuma outra API

   /* @GetMapping(value = "/{id}/{currency}", produces = { "application/json" })
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
        return book;*/
    }







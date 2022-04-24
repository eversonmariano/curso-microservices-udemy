package br.com.everson.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "book")
public class Book  implements Serializable {
<<<<<<< HEAD
=======

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author", nullable = false, length = 180)
    private String author;
    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false, length = 250)
    private String title;
    @Transient
    private String currency;
    @Transient
<<<<<<< HEAD
=======
=======
public class Book implements Serializable {
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author", nullable = false, length = 180)
    private String author;
    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false, length = 250)
    private String title;
    @Transient
    private String currency;
<<<<<<< HEAD
    @Transient
=======
>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
    private String environment;

    public Book() {
    }

<<<<<<< HEAD
    public Book(Long id, String author, Date launchDate, Double price, String title, String currency, String environment) {
=======
<<<<<<< HEAD
    public Book(Long id, String author, Date launchDate, Double price, String title, String currency, String environment) {
=======
<<<<<<< HEAD
    public Book(Long id, String author, Date launchDate, Double price, String title, String currency, String environment) {
=======
    public Book(Long id, String author, String title,
                Date launchDate, Double price,
                String currency,
                String environment) {
>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author) && Objects.equals(launchDate, book.launchDate) && Objects.equals(price, book.price) && Objects.equals(title, book.title) && Objects.equals(currency, book.currency) && Objects.equals(environment, book.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launchDate, price, title, currency, environment);
    }
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
}
>>>>>>> 7187068f8e5f1d0b3c9f751de4f645058c598c02
>>>>>>> 4415eeb428d807a00882ab7ca072cc58b36b5ba0
>>>>>>> 8356af45bd2ea793e8ebe13b6c0bec06ba6eb25d

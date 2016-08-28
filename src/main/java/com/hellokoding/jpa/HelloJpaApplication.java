package com.hellokoding.jpa;

import com.hellokoding.jpa.model.Book;
import com.hellokoding.jpa.model.BookDetail;
import com.hellokoding.jpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HelloJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Book original = bookRepository.save(new Book("My Book", null));

        original.setBookDetail(new BookDetail(1001));

        Book updated = bookRepository.save(original);

        logger.info(updated.toString());
    }
}

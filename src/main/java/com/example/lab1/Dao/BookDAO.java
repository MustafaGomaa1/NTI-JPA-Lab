package com.example.lab1.Dao;

import com.example.lab1.EntityManagerUtil;
import com.example.lab1.model.Book;

import jakarta.persistence.EntityManager;

public class BookDAO {
    EntityManager entityManager = EntityManagerUtil.StartSession();

    public void addBook(Book book) {
        entityManager.persist(book);
        System.out.println("<====== Add Books =====>");
    }

    public Book findById(int id) {
        Book book = entityManager.find(Book.class, 1);
        System.out.println("========= Find Book ============");
        return book;
    }

    public void updateBook(int id, Book book) {
        Book oldBook = entityManager.find(Book.class, id);
        oldBook.setAuth(book.getAuth());
        oldBook.setName(book.getName());
        oldBook.setPrice(book.getPrice());
        oldBook.setPublisher(book.getPublisher());
        System.out.println("======= Book Updated =======");
    }

    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Book.class, id));
        System.out.println("====== Delete Book ========");
    }
}

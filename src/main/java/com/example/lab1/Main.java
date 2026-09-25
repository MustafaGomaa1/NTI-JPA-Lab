package com.example.lab1;

import java.util.List;

import com.example.lab1.Dao.BookDAO;
import com.example.lab1.model.Auth;
import com.example.lab1.model.Book;
import com.example.lab1.model.Category;
import com.example.lab1.model.Publisher;

import jakarta.persistence.EntityManager;

@SuppressWarnings("not used")
public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.StartSession();
        BookDAO bookDAO = new BookDAO();
        Book myBook = new Book();
        bookDAO.addBook(myBook);
        myBook.setName("MIPS IN LOL & JPA & Hibernate");
        myBook.setPrice(1500);
        log("inf", "Create an instances of BOOK , ENTITY MANAGER , BOOKDAO");
        Auth auth = new Auth();
        entityManager.persist(auth);
        auth.setName("Mustafa Gomaa");
        List<Book> authBooks = auth.getBooks();
        authBooks.add(myBook);
        auth.setBooks(authBooks);
        log("INFO", "MAKE Auth Be Managed By JPA");

        Category category = new Category();
        entityManager.persist(category);
        category.setBooks(authBooks);
        category.setName("Tech");
        log("INFO", "Manage Category By JPA");

        Publisher publisher = new Publisher();
        entityManager.persist(publisher);
        publisher.setName("MG Group");
        log("INFO", "Manage Publisher By JPA");

        myBook.setAuth(auth);
        myBook.setPublisher(publisher);

        List<Category> bookCategories = myBook.getCategories();
        bookCategories.add(category);

        myBook.setCategories(bookCategories);

        log("INFO", "ADD BOOK META DATA");
    }

    public static void log(String type, String message) {
        System.out.println("{ " + type + " } ======> { " + message + " } <==========");
    }
    // System.out.println("Hello world!");
    // EntityManagerFactory factory =
    // Persistence.createEntityManagerFactory("empPU");

    // Employee emp = new Employee();
    // emp.setName("Mustafa");
    // emp.setEmail("Mustafa@Example.test");
    // emp.setSalary(12300);
    // EntityManager entityManager = factory.createEntityManager();
    // System.out.println("Create Entity Manager Instance==>");

    // entityManager.persist(emp);
    // System.out.println("Persist Employee Object {" + emp.getClass().getName() +
    // "}");
    // System.out.println(emp.toString());
    // emp.setSalary(13000);
    // System.out.println("Change the Persist Entity {" + emp.getClass().getName() +
    // "}");
    // System.out.println(emp.toString());

    // entityManager.detach(emp);
    // System.out.println("Detach The Persist Entity");

    // Employee e = entityManager.find(Employee.class, emp.getId());
    // System.out.println("Re Persist The Entity");
    // System.out.println(e.toString());
    // System.out.println("IS EQUALS=======> " + (e == emp));

    // entityManager.getTransaction().begin();
    // e.setEmail("MOAATROX@LOL.SILVER");
    // entityManager.getTransaction().commit();
    // System.out.println(e.toString());
    // System.out.println("Entity Manager Flush");

    // entityManager.close();
    // System.out.println("Entity Manager Close");

}
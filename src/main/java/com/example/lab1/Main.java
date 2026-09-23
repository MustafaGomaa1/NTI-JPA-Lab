package com.example.lab1;

import com.example.lab1.Dao.BookDAO;
import com.example.lab1.model.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("JPA&Hibernate");
        book.setPrice(1000);
        BookDAO dao = new BookDAO();
        dao.addBook(book);
        Book managedBook = dao.findById(1);
        System.out.println(managedBook.toString());
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
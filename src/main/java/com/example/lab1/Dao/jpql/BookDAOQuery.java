package com.example.lab1.Dao.jpql;

import java.util.List;

import com.example.lab1.EntityManagerUtil;
import com.example.lab1.model.Auth;
import com.example.lab1.model.Book;
import com.example.lab1.model.Publisher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class BookDAOQuery {
    static EntityManager entityManager = EntityManagerUtil.StartSession();

    public static List<Book> findByAuthor(int auth_id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> book = criteriaQuery.from(Book.class);

        criteriaQuery.select(book).where(criteriaBuilder.equal(book.get("auth_id"), auth_id));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public static List<Book> findByPublisher(Publisher publisher) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher", Book.class)
                .setParameter("publisher", publisher).getResultList();
    }

    public static Book findById(int bookId) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.id = ?1", Book.class).setParameter(1, bookId)
                .getSingleResult();
    }

    public static Auth findAuthById(int authId) {
        return entityManager.createQuery("SELECT a FROM Auth a JOIN FETCh Book b WHERE b.auth_id = :id", Auth.class)
                .setParameter("id", authId).getSingleResult();
    }

    public static Book findBookByTitle(String title) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> book = criteriaQuery.from(Book.class);

        criteriaQuery.select(book).where(criteriaBuilder.equal(book.get("title"), title));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}

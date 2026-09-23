package com.example.lab1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("empPU");
    private static EntityManager entityManager = factory.createEntityManager();

    public static EntityManager StartSession() {
        return entityManager;
    }

    public static void closeSession() {
        entityManager.close();
    }
}

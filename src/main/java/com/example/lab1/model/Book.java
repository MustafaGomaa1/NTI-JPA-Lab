package com.example.lab1.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    private Auth auth;

    @ManyToOne
    @JoinColumn(name = "pub_id")
    private Publisher publisher;

    @ManyToMany(mappedBy = "books")
    List<Category> categories = new ArrayList<>();

    // public Book(Integer id, String name, String price, Auth auth, Publisher
    // publisher) {
    // this.id = id;
    // this.name = name;
    // this.price = price;
    // this.auth = auth;
    // this.publisher = publisher;
    // }

    // public Book() {
    // }
}

package com.re.projcethackkathon011.entity;
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean isDeleted = false;

    public enum Status {
        AVAILABLE,
        BORROWED
    }
}
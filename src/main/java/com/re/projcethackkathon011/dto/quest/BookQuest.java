package com.re.projcethackkathon011.dto.quest;

public class BookRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Positive
    private double price;

    private Book.Status status;
}
package com.example.booksera;

public class Product {

    private int id;
    private String title;
    private String link;


    public Product(int id, String title, double price, String link) {
        this.id = id;
        this.title = title;
        this.link=link;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

package org.example.model;

public class Book {
    private String author;
    private String title;
    private int publish_year;

    public Book() { super(); }
    public Book(String title, String author, int publish_year) {
        this.title = title;
        this.author = author;
        this.publish_year = publish_year;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

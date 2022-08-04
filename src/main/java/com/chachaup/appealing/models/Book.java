package com.chachaup.appealing.models;

import java.util.Objects;

public class Book {
    private int id;
    private String bookName;
    private String author;
    private String description;
    private int price;
    private byte img;

    public Book(String bookName, String author, String description, int price) {
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getImg() {
        return img;
    }

    public void setImg(byte img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && price == book.price && img == book.img && bookName.equals(book.bookName) && author.equals(book.author) && description.equals(book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, description, price, img);
    }
}

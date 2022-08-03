package com.chachaup.appealing.models;

import java.util.Objects;

public class Book {
    private int id;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private int bookPrice;
    private byte bookImg;

    public Book(String bookName, String bookAuthor, String bookDescription, int bookPrice, byte bookImg) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.bookImg = bookImg;
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public byte getBookImg() {
        return bookImg;
    }

    public void setBookImg(byte bookImg) {
        this.bookImg = bookImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && bookPrice == book.bookPrice && bookImg == book.bookImg && bookName.equals(book.bookName) && bookAuthor.equals(book.bookAuthor) && bookDescription.equals(book.bookDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookAuthor, bookDescription, bookPrice, bookImg);
    }

    @Override
    public String toString() {
        return "Book{" +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookImg=" + bookImg +
                '}';
    }
}

package org.example.models;

import java.time.LocalDate;
import java.util.Objects;

public class Book
{
    private String name;

    private String author;

    private LocalDate publicationDate;

    private String ISBN;

    public Book() {}

    public Book(String name, String author, LocalDate publicationDate, String ISBN)
    {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public LocalDate getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    @Override
    public String toString()
    {
        return "Book {" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publicationDate, ISBN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publicationDate, book.publicationDate) &&
                Objects.equals(ISBN, book.ISBN);
    }
}

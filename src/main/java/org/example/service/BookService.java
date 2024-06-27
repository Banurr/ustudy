package org.example.service;

import org.example.models.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService
{
    private static final ArrayList<Book> books = new ArrayList<>();

    public static List<Book> allBooks()
    {
        return books;
    }

    public static void addBook(Book book)
    {
        books.add(book);
    }

    public static void deleteBook(int index)
    {
        books.remove(index);
    }

    public static List<Book> findBookByName(String name)
    {
        List<Book> result;
        result = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return result;
    }

    public static List<Book> findBookByDate(LocalDate date)
    {
        List<Book> result;
        result = books.stream().filter(book -> book.getPublicationDate().equals(date)).collect(Collectors.toList());
        return result;
    }

    public static List<Book> findBookByAuthor(String author)
    {
        List<Book> result;
        result = books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
        return result;
    }

}

package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.models.Book;
import org.example.service.BookService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest
{
    @BeforeEach
    public void setUp()
    {
        BookService.addBook(new Book("Harry Potter","Rowling",LocalDate.of(2004,12,3),"123456789"));
        BookService.addBook(new Book("Java Fundamentals","Timur Yeslamgaliyev",LocalDate.of(2020,7,2),"000000000"));
        BookService.addBook(new Book("Twisted Ones","Mike Schmidt",LocalDate.of(2013,1,30),"222299945"));
    }

    @AfterEach
    public void tearDown()
    {
        BookService.allBooks().clear();
    }

    @Test
    public void allBookTest()
    {
        List<Book> books = BookService.allBooks();
        assertEquals(3,books.size());
    }

    @Test
    public void addBookTest()
    {
        Book book = new Book("Receipt cooking","Nurmash", LocalDate.of(2024,8,5),"111111111");
        BookService.addBook(book);
        List<Book> books = BookService.allBooks();
        assertEquals(4,books.size());
        assertTrue(books.contains(book));
    }

    @Test
    public void deleteBookTest() throws InvalidIndexException
    {
        int index = 0;
        Book book = BookService.allBooks().get(index);
        BookService.deleteBook(index);
        assertEquals(2,BookService.allBooks().size());
        assertFalse(BookService.allBooks().contains(book));
    }

    @Test
    public void deleteBookExceptionTest() throws InvalidIndexException
    {

        assertThrows(InvalidIndexException.class, ()-> BookService.deleteBook(-1));
        assertEquals(3,BookService.allBooks().size());
    }

    @Test
    public void findBookByName()
    {
        List<Book> expected = List.of(new Book("Harry Potter","Rowling",LocalDate.of(2004,12,3),"123456789"));
        List<Book> actual = BookService.findBookByName("Harry Potter");
        assertEquals(expected,actual);
    }

    @Test
    public void findBookByAuthor()
    {
        List<Book> expected = List.of(new Book("Harry Potter","Rowling",LocalDate.of(2004,12,3),"123456789"));
        List<Book> actual = BookService.findBookByAuthor("Rowling");
        assertEquals(expected,actual);
    }

    @Test
    public void findBookByDate()
    {
        List<Book> expected = List.of(new Book("Harry Potter","Rowling",LocalDate.of(2004,12,3),"123456789"));
        List<Book> actual = BookService.findBookByDate(LocalDate.of(2004,12,3));
        assertEquals(expected,actual);
    }

}

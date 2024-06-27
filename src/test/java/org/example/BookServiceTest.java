package org.example;

import org.example.models.Book;
import org.example.service.BookService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest
{

    @BeforeAll
    public static void setUp()
    {
        BookService.addBook(new Book("Harry Potter","Rowling",LocalDate.of(2004,12,3),"123456789"));
        BookService.addBook(new Book("Java Fundamentals","Timur Yeslamgaliyev",LocalDate.of(2020,7,2),"000000000"));
    }

    @Test
    public void addBookTest()
    {
        Book book = new Book("Receipt cooking","Nurmash", LocalDate.of(2024,8,5),"111111111");
        BookService.addBook(book);
        List<Book> books = BookService.allBooks();
        assertEquals(3,books.size());
        assertTrue(books.contains(book));
    }

}

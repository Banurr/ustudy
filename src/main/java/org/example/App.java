package org.example;

import org.example.models.Book;
import org.example.service.BookService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App
{
    static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {
        System.out.println("Welcome to Book Management System!");

        while(true)
        {
            System.out.println("Please choose operation to do:");

            System.out.println("""
                    0 - Exit
                    1 - Show all books
                    2 - Add new book
                    3 - Delete book
                    4 - Find book""");
            String option = sc.nextLine();

            if(option.equals("0"))
            {
                System.out.println("Good Bye!");

                System.exit(0);
            }

            else if(option.equals("1")) showAllBooks();

            else if(option.equals("2")) addNewBook();

            else if(option.equals("3")) deleteBook();

            else if(option.equals("4")) findBook();

            else System.out.println("Incorrect option!!!");

        }
    }

    public static void printList(List<Book> books)
    {
        for(Book book : books)
        {
            System.out.println(book);
        }
    }

    public static void showAllBooks()
    {
        List<Book> books = BookService.allBooks();

        if(books.size()==0) System.out.println("There are no books!");

        else printList(books);

    }

    public static void addNewBook()
    {
        System.out.println("Enter name of the book");

        String name = sc.nextLine();

        System.out.println("Enter author");

        String author = sc.nextLine();

        System.out.println("Enter date of publication in the format yyyy-mm-dd");

        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter ISBN of the book");

        String ISBN = sc.nextLine();

        BookService.addBook(new Book(name,author,date,ISBN));

        System.out.println("Book was added successfully");

    }

    public static void deleteBook()
    {
        List<Book> books = BookService.allBooks();

        if(books.size() == 0)
        {
            System.out.println("There are no books to delete");

            return;
        }

        System.out.println("Choose book you want to delete");

        for(int i = 0 ; i < books.size(); i++)
        {
            System.out.println(i + " - " + books.get(i));
        }
        int index = Integer.parseInt(sc.nextLine());

        BookService.deleteBook(index);

        System.out.println("Book was deleted successfully");
    }

    public static void findBook()
    {
        while(true)
        {
            System.out.println("Choose criteria to find the book:");

            System.out.println("""
                        0 - Exit
                        1 - By name
                        2 - By author
                        3 - By date of publication
                        """);

            String criteria = sc.nextLine();

            if(criteria.equals("0")) break;

            else if(criteria.equals("1")) findBookByName();

            else if(criteria.equals("2")) findBookByAuthor();

            else if(criteria.equals("3")) findBookByDate();

            else System.out.println("Incorrect criteria");
        }
    }

    public static void findBookByName()
    {
        System.out.println("Enter name");

        String name = sc.nextLine();

        List<Book> books = BookService.findBookByName(name);

        if(books.size() == 0) System.out.println("There are books with this name");

        else printList(books);
    }

    public static void findBookByAuthor()
    {
        System.out.println("Enter author");

        String author = sc.nextLine();

        List<Book> books = BookService.findBookByAuthor(author);

        if(books.size() == 0) System.out.println("There are no books with this author");

        else printList(books);
    }

    public static void findBookByDate()
    {
        System.out.println("Enter date of publication in format yyyy-mm-dd");

        LocalDate date = LocalDate.parse(sc.nextLine());

        List<Book> books = BookService.findBookByDate(date);

        if(books.size() == 0) System.out.println("There are no books with this publication date");

        else printList(books);
    }
}

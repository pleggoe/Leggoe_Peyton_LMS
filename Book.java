/*
*Peyton Leggoe
*Book.java
* 1/21/2024
*The class Book is used to create an object Book for use in the LMS program.
*Book houses data members id, title, and author. A default constructor was made with empty strings and sets the id
*to 0 by default.
*/
public class Book
{
    int id;
    String title;
    String author;

    Book()
    {
        id = 0;
        title = "";
        author = "";
    }
    Book(int id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
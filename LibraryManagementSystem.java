import java.io.*;
import java.util.*;

/*
*Peyton Leggoe
*CEN 3042C-26663
*1/21/2024
*LibraryManagementSystem.java
*This class houses the main method for the program. This program reads in an existing collection
*of books from a .txt formatted as "ID,Title,Author" and allows the user to add a book, remove a book, and show a list
*of the collection.
*/
public class LibraryManagementSystem {
    ArrayList<Book> Books = new ArrayList<Book>();

    /**
     * method: readCollection
     * parameters: none
     * return: none
     * purpose: reads in.txt file and loads collection of books into ArrayList<Book> Books
     * Note: File path will need to be changed based on file path of the machine running the code
     */
    void readCollection() throws IOException
    {
        Scanner fileIn = new Scanner(new File("C:\\Users\\Vipertoo\\Desktop\\CEN 3024\\projects\\LibraryManagementSystem\\src\\in1.txt"));

        System.out.println("Loading collection");

        while(fileIn.hasNextLine())
        {
            Book tempBook = new Book();
            int id;
            String title;
            String author;

            int inputLength;
            int i = 0;
            String forLoopInput = "";

            String collectionInput = fileIn.nextLine();
            inputLength = collectionInput.length();

            for(; collectionInput.charAt(i) != ','; i++)
            {
                forLoopInput = forLoopInput + collectionInput.charAt(i);
            }
            id = Integer.parseInt(forLoopInput);
            tempBook.id = id;
            forLoopInput = "";
            i++;

            for(; collectionInput.charAt(i) != ','; i++)
            {
                forLoopInput = forLoopInput + collectionInput.charAt(i);
            }
            title = forLoopInput;
            tempBook.title = title;
            forLoopInput = "";
            i++;

            for(; i < inputLength; i++)
            {
                forLoopInput = forLoopInput + collectionInput.charAt(i);
            }
            author = forLoopInput;
            tempBook.author = author;
            forLoopInput = "";

            Books.add(tempBook);
        }

        fileIn.close();

        System.out.println("Done!\n");
    }

    /**
     * method: addBook
     * parameters: none
     * return: none
     * purpose: Receives user input for Book id, title, and author then adds book to ArrayList<Book> Books.
     * Checks if id is already in use and will ask user to enter a unique ID
     */
    void addBook()
    {
        Book tempBook;
        int id;
        String title;
        String author;
        boolean exitCon = true;

        Scanner userIn = new Scanner(System.in);

        System.out.print("Book ID: ");
        id = Integer.parseInt(userIn.nextLine());
        while(exitCon)
        {
            exitCon = false;
            for(Book i: Books)
            {
                if(i.id == id)
                {
                    System.out.println("Book ID already in use. Please use a different ID");
                    System.out.print("Book ID: ");
                    id = Integer.parseInt(userIn.nextLine());
                    exitCon = true;
                }
            }

        }
        System.out.print("\nTitle: ");
        title = userIn.nextLine();
        System.out.print("\nAuthor: ");
        author = userIn.nextLine();

        tempBook = new Book(id, title, author);
        Books.add(tempBook);
    }

    /**
     * method: removeBook
     * parameters: int id
     * return: none
     * purpose: removes Book from ArrayList<Book> Books based off of input received from user (int id)
     */
    void removeBook(int id)
    {
        for(Book i: Books)
        {
            if(i.id == id)
            {
                System.out.println("Removed book: " + i.id + "," + i.title + "," + i.author + "\n");
                Books.remove(i);
                return;
            }
        }
        System.out.println("Book ID not found\n");
    }

    /**
     * method: listBooks
     * parameters: none
     * return: none
     * purpose: displays current list of Books from ArrayList<Book> Books
     */
    void listBooks()
    {
        System.out.println("---------------------------------------------");
        for(Book i: Books)
        {
            System.out.println(i.id + "," + i.title + "," + i.author);
        }
        System.out.println("---------------------------------------------");
    }

  public static void main(String [] args) throws IOException {
        LibraryManagementSystem instance = new LibraryManagementSystem();
        instance.readCollection();
        Scanner userIn = new Scanner(System.in);

        char menuOption;
        boolean exitCon = true;
        int bookId;

        while(exitCon)
        {
            System.out.print("1:Add new book\n2:Remove book\n3:List collection\n4:Exit program\n");
            menuOption = userIn.nextLine().charAt(0);

            switch(menuOption)
            {
                case 49:
                    System.out.println("Option 1 selected");
                    instance.addBook();
                    break;

                case 50:
                    System.out.println("Option 2 selected");
                    System.out.println("Enter ID of book for removal: ");
                    bookId = Integer.parseInt(userIn.nextLine());
                    instance.removeBook(bookId);
                    break;

                case 51:
                    System.out.println("Option 3 selected");
                    instance.listBooks();
                    break;

                case 52:
                    System.out.println("Goodbye");
                    exitCon = false;
                    break;

                default:
                    System.out.println("Invalid option selected");
                    break;
            }
        }
  }
}



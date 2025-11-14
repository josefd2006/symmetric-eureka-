import java.util.*;
public class Library {
    List <Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
    }

    public void addPrevBook(Book book){
        books.add(book);
    }

    public void listBooks(){
        if (books.isEmpty()){
            System.out.println("No books in the library.");
        }
        else{
            for (Book book : books){
                System.out.println(book.getTitle() + " by " + book.getAuthor() + (book.isAvailable() ? " (Available)" : " (Checked Out)"));
            }
        }
    }

    public void checkoutBook(String title){
        if (books.isEmpty()){
            System.out.println("No books available to checkout.");
        }
        
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                if(!book.isAvailable()){
                    System.out.println("Sorry, this book is currently checked out.");
                }
                else{
                    book.isAvailable = false;
                    System.out.println("You have successfully checked out: " + title);
                }
            }
            }
        
    }

    public void returnBook(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                if(book.isAvailable()){
                    System.out.println("This book was not checked out.");
                }
                else{
                    book.isAvailable = true;
                    System.out.println("You have successfully returned: " + title);
                }
            }
        }
    }

}
import java.util.Scanner;
public class Main {
    public static String question(){
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("""
                    1) Type "Donate" to add a book
                    2) Type "List" to see the contents of our library
                    3) Type "Checkout" to checkout a book
                    4) Type "Return" to return a book
                    Type "End" to quit
                    """);
        String input = in.nextLine();
        return input;
    }
    public static void main (String[] args){
        Library library = new Library();
        Book book1 = new Book("To Kill A Mockingbird","Harper Lee");
        Book book2 = new Book("1984","George Orwell");
        Book book3 = new Book("The Great Gatsby","F. Scott Fitzgerald");
        Book book4 = new Book("Pride and Prejudice","Jane Austen");
        Book book5 = new Book("The Catcher in the Rye","J.D. Salinger");
        Book book6 = new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling");
        Book book7 = new Book("The Hobbit","J.R.R Tolkien");
        Book book8 = new Book("The Da Vinci Code","Dan Brown");
        Book book9 = new Book("The Alchemist","Paulo Coelho");
        Book book10 = new Book("The Hunger Games","Suzanne Collins");

        library.addPrevBook(book1);
        library.addPrevBook(book2);
        library.addPrevBook(book3);
        library.addPrevBook(book4);
        library.addPrevBook(book5);
        library.addPrevBook(book6);
        library.addPrevBook(book7);
        library.addPrevBook(book8);
        library.addPrevBook(book9);
        library.addPrevBook(book10);

        
        
        String input = question();
        Scanner in = new Scanner(System.in);
        while (!input.equals("End")){
        if (input.equals("Donate")){
                System.out.println("Thank you for donating! Please enter the name of the book and then the author on seperate lines.");
                String name = in.nextLine();
                String title = in.nextLine();
                library.addBook(name, title);
            }
            else if(input.equals("List")){
                System.out.println("Thank you for taking an interest in our library, here is a list of current titles and authors we have.");
                library.listBooks();
            }
            else if(input.equals("Checkout")){
                System.out.println("We would love to help you check out a book. Please enter the title of the book below");
                String title = in.nextLine();
                library.checkoutBook(title);
            }
            else if(input.equals("Return")){
                System.out.println("Thank you for returning our book. Please enter the name of the book you are returning below");
                String title = in.nextLine();
                library.returnBook(title);
            }
            else if(input.equals("End")){
                System.out.println("Thank you for your buisness, we hope to see you again in the future for all your library needs");
                break;
            }
            input = question();
        }
    }
}

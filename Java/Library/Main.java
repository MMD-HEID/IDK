import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book.initializeBooks();
        Main main = new Main();
        main.getOrder();
    }

    void getOrder() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter What You Want To Do: ");
        System.out.println("1: Search For A Book");
        System.out.println("2: Borrow A Book");
        System.out.println("3: Return A Book");
        System.out.println("4: Add A Book");
        System.out.println("5: Show All The Books");
        int order = input.nextInt();
        input.nextLine();
        String temp = "";

        if (order == 1) {
            System.out.println("1: Search By Book Name  2: Search By Author");
            int searchType = input.nextInt();
            input.nextLine();
            System.out.println("Enter The Phrase You Want To Search: ");
            temp = input.nextLine().trim().toLowerCase();

            boolean bookFound = false;

            if (searchType == 1) {
                for (int i = 0; i < Book.books.length; i++) {
                    Book book = Book.books[i];
                    if (book.bookName.contains(temp)) {
                        System.out.println("Book Name: " + book.bookName + " | Author: " + book.author + " | Availability: " + (book.availability ? "Yes" : "No"));
                        bookFound = true;
                        System.out.println();
                        getOrder();
                    }
                }
            } else if (searchType == 2) {
                for (int i = 0; i < Book.books.length; i++) {
                    Book book = Book.books[i];
                    if (book.author.contains(temp)) {
                        System.out.println("Book Name: " + book.bookName + " | Author: " + book.author + " | Availability: " + (book.availability ? "Yes" : "No"));
                        bookFound = true;
                        System.out.println();
                        getOrder();
                    }
                }
            }

            if (!bookFound) {
                System.out.println("The Book You're Looking For Is Not Found!");
            }
        } else if (order == 2) {
            System.out.println("Enter The Book Name: ");
            temp = input.nextLine();
            boolean bookFound = false;

            for (int i = 0; i < Book.books.length; i++) {
                Book book = Book.books[i];
                if (book.bookName.equalsIgnoreCase(temp)) {
                    bookFound = true;
                    if (book.availability) {
                        System.out.println("The Book Is Yours!");
                        System.out.println();
                        book.availability = false;
                        getOrder();
                    } else {
                        System.out.println("The Book Is Not Available!");
                    }
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("The Book You're Looking For Was Not Found!");
            }
        } else if (order == 3) {
            System.out.println("Enter The Book Name That You're Returning: ");
            temp = input.nextLine();
            boolean bookFound = false;

            for (int i = 0; i < Book.books.length; i++) {
                Book book = Book.books[i];
                if (book.bookName.equalsIgnoreCase(temp)) {
                    book.availability = true;
                    System.out.println("Thanks For Taking Care Of Our Book! ;) ");
                    System.out.println();
                    bookFound = true;
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("I Think You Got The Book Wrong! :o ");
            }
        } else if (order == 4) {
            System.out.println("WHAT!? You Want To Give Us A Book For Free??");
            System.out.println("Go Ahead Enter The Book Name: ");
            System.out.println("Enter Book Name: ");
            String newBookName = input.nextLine();
            System.out.println("Enter Author: ");
            String newAuthor = input.nextLine();

            if (Book.bC == Book.books.length) {
                Book[] tempBooks = new Book[Book.books.length * 2];
                for (int i = 0; i < Book.books.length; i++) {
                    tempBooks[i] = Book.books[i];
                }
                Book.books = tempBooks;
            }

            Book.books[Book.bC] = new Book(newBookName, newAuthor, true);
            Book.bC++;
            System.out.println("Thank you for the book!");
            getOrder();
        } else if (order == 5) {
            System.out.println("These Are All The Books: ");
            System.out.println();
            Library.displayAllBooks();
        }
    }
}

class Library {
    public static void displayAllBooks() {
        for (Book book : Book.books) {
            if (book != null) {
                System.out.println("Book Name: " + book.bookName + " | Author: " + book.author + " | Availability: " + (book.availability ? "Yes" : "No"));
            }
        }
    }

    public static int countAvailableBooks() {
        int count = 0;
        for (Book book : Book.books) {
            if (book != null && book.availability) {
                count++;
            }
        }
        return count;
    }
}


class Book {
    static int bC = 10;
    boolean availability;
    String bookName, author;
    static Book[] books = new Book[bC];

    public Book(String bookName, String author, boolean availability) {
        this.bookName = bookName;
        this.author = author;
        this.availability = availability;
    }

    public static void initializeBooks() {
        books[0] = new Book("to kill a mockingbird", "Harper Lee", true);
        books[1] = new Book("1984", "George Orwell", true);
        books[2] = new Book("pride and prejudice", "Jane Austen", true);
        books[3] = new Book("the great gatsby", "F. Scott Fitzgerald", true);
        books[4] = new Book("moby-dick", "Herman Melville", true);
        books[5] = new Book("the catcher in the rye", "J.D. Salinger", false);
        books[6] = new Book("war and peace", "Leo Tolstoy", true);
        books[7] = new Book("the hobbit", "J.R.R. Tolkien", true);
        books[8] = new Book("crime and punishment", "Fyodor Dostoevsky", true);
        books[9] = new Book("the odyssey", "Homer", false);
    }
}

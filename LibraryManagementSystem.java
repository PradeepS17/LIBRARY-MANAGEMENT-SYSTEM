import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by Author");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    for (Book book : catalog.searchByTitle(title)) {
                        System.out.println(book);
                    }
                    break;

                case 3:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    for (Book book : catalog.searchByAuthor(author)) {
                        System.out.println(book);
                    }
                    break;

                case 4:
                    System.out.print("Enter title to check out: ");
                    title = scanner.nextLine();
                    catalog.checkOutBook(title);
                    break;

                case 5:
                    System.out.print("Enter title to return: ");
                    title = scanner.nextLine();
                    catalog.returnBook(title);
                    break;

                case 6:
                    catalog.displayAllBooks();
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}

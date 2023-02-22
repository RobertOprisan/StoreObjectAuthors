import java.io.Serializable;
import java.util.Scanner;
public class Book implements Serializable {
    private String title;
    private Author author;
    private double price;
    private int qtyInStock = 0;
    public Book(String name, Author author, double price) {
        this.title = name;
        this.author = author;
        this.price = price;
    }
    public Book(String name, Author author, double price,
                int qtyInStock) {
        this.title = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }
    public String getName() {
        return title;
    }
    public Author getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public int getQtyInStock() {
        return qtyInStock;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public String getAuthorName() {
        return author.getName();
    }
    public String getAuthorEmail() {
        return author.getEmail();
    }
    public char getAuthorGender() {
        return author.getGender();
    }
    public String toString() {
        return getName() + " by " + author;
    }
    public static Book readFromKeyboard(Scanner scanner) {
        String title = readTitle(scanner);
        System.out.println("----Author----");
        Author author = Author.readFromKeyboard(scanner);
        System.out.println("--------------");
        double price = readPrice(scanner);
        int stock = readStock(scanner);
        return new Book(title, author, price, stock);
    }
    private static String readTitle(Scanner scanner) {
        System.out.println("Enter title:");
        return scanner.nextLine();
    }
    private static double readPrice(Scanner scanner) {
        boolean invalidNumber;
        int price = 0;
        do {
            invalidNumber = false;
            System.out.println("Enter price:");
            String s = scanner.nextLine();
            try {
                price = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                invalidNumber = true;
            }
        } while (invalidNumber);
        return price;
    }

    private static int readStock(Scanner scanner) {
        boolean invalidNumber;
        int stock = 0;
        do {
            invalidNumber = false;
            System.out.println("Enter stock:");
            String s = scanner.nextLine();
            try {
                stock = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                invalidNumber = true;
            }
        } while (invalidNumber);
        return stock;
    }


}
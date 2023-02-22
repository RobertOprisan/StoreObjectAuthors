import java.io.*;
import java.util.Scanner;
public class WriteBooks {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (
                    new BufferedOutputStream(
                            new FileOutputStream("books.obj")));
            do {
                Book b = Book.readFromKeyboard(scanner);
                out.writeObject(b);
            } while(enterOneMoreAuthor(scanner));
        } catch (FileNotFoundException ex) {
            System.err.println("Could not create the file");
        } catch (IOException ex) {
            System.err.println("Error writing book to the file");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static boolean enterOneMoreAuthor(Scanner scanner) {
        String answer;
        do {
            System.out.print("One more book (yes/no)? ");
            answer = scanner.nextLine();
        } while (!answer.equalsIgnoreCase("yes") &&
                !answer.equalsIgnoreCase("y") &&
                !answer.equalsIgnoreCase("no") &&
                !answer.equalsIgnoreCase("n"));
//input.close(); never close a scanner with System.in
        if (answer.equalsIgnoreCase("yes") ||
                answer.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }
}
import java.io.*;
import java.util.Scanner;
public class WriteAuthors {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("authors.dat", true)));
            do {
                Author a = Author.readFromKeyboard(scanner);
                out.writeUTF(a.getName());
                out.writeUTF(a.getEmail());
                out.writeChar(a.getGender());
                out.writeInt(a.getYear());
            } while(enterOneMoreAuthor(scanner));
        } catch (FileNotFoundException ex) {
            System.err.println("Could not create the file");
        } catch (IOException ex) {
            System.err.println("Error writing Author to the file");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    private static boolean enterOneMoreAuthor(Scanner scanner) {
        String answer;
        do {
            System.out.print("One more author (yes/no)? ");
            answer = scanner.nextLine();
        } while (!answer.equalsIgnoreCase("yes") &&
                !answer.equalsIgnoreCase("y") &&
                !answer.equalsIgnoreCase("no") &&
                !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("yes") ||
                answer.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }
}
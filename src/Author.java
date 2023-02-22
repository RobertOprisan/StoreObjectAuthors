import java.util.Scanner;
class Author {
    private String name;
    private String email;
    private char gender;
    private int year;
    public String getName() {
        return name;
    }
    public String toString() {
        return getName() + " (" + getGender() + ") " + "at " +
                getEmail() + " Birth year: " + year;
    }
    public String getEmail() {
        return email;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }
    public Author(String name, String email, char gender, int year) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.year = year;
    }
    public static Author readFromKeyboard(Scanner scanner) {
        String name = null;
        String email = null;
        int year;
        char gender;
        do {
            System.out.println("Enter name:");
            name = scanner.nextLine();
        } while ((name.equals("")));
        System.out.println("Enter email:");
        email = scanner.nextLine();
        do {
            System.out.println("Enter gender (m/f):");
            gender = scanner.nextLine().toLowerCase().charAt(0);
        } while (gender != 'm' && gender != 'f');
        boolean invalidNumber;
        year = 0;
        do { // Just as an example to deal with numbers
            invalidNumber = false;
            System.out.println("Enter birth year:");
            String s = scanner.nextLine();
            try {
                year = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                invalidNumber = true;
            }
        } while (invalidNumber);
        return new Author(name, email, gender, year);
    }
}

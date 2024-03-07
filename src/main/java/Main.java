import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search By : \n\t1) Movie Name \n\t2) Actor Name\n\t3) EXIT");

        String userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Name of the Movie : ");
            String movieName = scanner.nextLine();

        } else if (userInput.equals("2")) {
            System.out.println("Name of the Actor : ");
            String actorName = scanner.nextLine();

        } else {
            System.out.println("I assume you type 3.\nBa Bye");

        }


    }
}
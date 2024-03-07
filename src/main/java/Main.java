import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Search For : \n\t1) Movie Name \n\t2) Actor Name\n\t3) EXIT");

        String userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Name of the Movie : ");
            String movieName = scanner.nextLine();
            Movie movie = new Movie(new ArrayList<>() , "", 0);
            String Data = movie.getMovieData(movieName);

            System.out.println("Release Date : \n\t" + movie.getReleaseDateViaApi(Data));
            System.out.println("Actors : \n\t" + movie.getActorListViaApi(Data));
            System.out.println("Number of Votes : \n\t" + movie.getImdbVotesViaApi(Data));
            System.out.println("Rating : \n\t" + movie.getRatingViaApi(Data));


        } else if (userInput.equals("2")) {
            System.out.println("Name of the Actor : ");
            String actorName = scanner.nextLine();

        } else {
            System.out.println("I assume you type 3.\nBa Bye");

        }


    }
}
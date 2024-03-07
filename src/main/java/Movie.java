import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
import org.json.JSONObject;
public class Movie {
    public static final String API_KEY = "25ae3736";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        //TODO --> (Write a proper constructor using the get_from_api functions)
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) {
        try {
            title = title.replace(" " , "+");
            URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
            URLConnection Url = url.openConnection();
            Url.setRequestProperty("Authorization", "Key" + API_KEY);
            if (((HttpURLConnection) Url).getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
                String line;
                StringBuilder stringBuilder = new StringBuilder();

                while ((line = reader.readLine())!=null) {
                    stringBuilder.append(line);
                }

                reader.close();

                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                String response = jsonObject.getString("Response");

                if (response == "False") {
                    return "Movie Not Found!";
                } else {
                    return stringBuilder.toString();
                }

            } else {
                return "Error " + ((HttpURLConnection) Url).getResponseCode() + " : \n\t" + ((HttpURLConnection) Url).getResponseMessage();

            }


        } catch (IOException Err) {
            Err.printStackTrace();
            return null;

        }
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        int ImdbVotes = 0;
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        ImdbVotes = Integer.parseInt((jsonObject.getString("imdbVotes").replace("," , "")));
        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){
        //TODO --> (This function must return the rating in the "Ratings" part
        // where the source is "Internet Movie Database")  -->
        String rating = "";
        return rating;
    }

    public void getActorListViaApi(String movieInfoJson){
        //TODO --> (This function must return the "Actors" in actorsList)
    }
}
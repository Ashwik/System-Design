package LowLevelDesign.BookMyShow.Movie;

import java.util.*;

public class Movie {
    int movieId;
    String movieName;
    int movieDurationInMinutes;
    String language;
    Date releaseDate;
    String country;
    String genre;

    public List<Show> getAllShows(){
        return new ArrayList<>();
    }

}

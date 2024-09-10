package LowLevelDesign.BookMyShow.Users;

import LowLevelDesign.BookMyShow.Movie.Movie;
import LowLevelDesign.BookMyShow.Movie.Show;
import LowLevelDesign.BookMyShow.Movie.Theatre;

public class Admin extends Person{

    public boolean addMovie(Movie movie){
        return true;
    }

    public boolean addTheatre(Theatre theatre){
        return true;
    }

    public boolean addShow(Show show) {
        return true;
    }
}

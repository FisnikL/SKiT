import java.util.List;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberOfRatedMovies(List<Movie> movies) {
        int total = 0;
        for(Movie movie: movies) {
            if(movie.isThisMovieRatedBy(username)){
                total += 1;
            }
        }
        return total;
    }
}

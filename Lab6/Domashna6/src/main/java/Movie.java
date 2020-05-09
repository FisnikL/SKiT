import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private List<User> users;
    private MovieRatingService movieRatingService;

    public Movie(String id) {
        this.id = id;
        this.users = new ArrayList<User>();
    }

    public MovieRatingService getMovieRatingService() {
        return movieRatingService;
    }

    public void setMovieRatingService(MovieRatingService movieRatingService) {
        this.movieRatingService = movieRatingService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public double getAverageRating() {
        double total = 0.0;

        for(User user: users) {
            total += movieRatingService.getRateFromUser(user.getUsername());
        }

        return users.size() > 0 ? total / users.size() : total;
    }

    public boolean isThisMovieRatedBy(String username) {
        if(movieRatingService.getRateFromUser(username) == null){
            return false;
        }
        return true;
    }
}

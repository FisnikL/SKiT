import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MockitoTesting {
    private Movie movie;
    private MovieRatingService movieRatingService;

    public static void main(String[] args) {
        MockitoTesting mockitoTesting = new MockitoTesting();

        mockitoTesting.setUpForTestingAverageRate();
        System.out.println("testAverageRate:");
        System.out.println("\tTest1: " + (mockitoTesting.testAverageRate1() ? "Passed successfully":"Failed"));
        System.out.println("\tTest2: " + (mockitoTesting.testAverageRate2() ? "Passed successfully":"Failed"));
        System.out.println("\tTest3: " + (mockitoTesting.testAverageRate3() ? "Passed successfully":"Failed"));

        mockitoTesting.setUpForTestingTotalNumberOfMoviesRatedByUser();
        System.out.println("testTotalNumberOfMoviesRatedByUser");
        System.out.println("\tTest1: " + (mockitoTesting.testTotalNumberOfMoviesRatedByFirstUser() ? "Passed successfully":"Failed"));
        System.out.println("\tTest2: " + (mockitoTesting.testTotalNumberOfMoviesRatedBySecondUser() ? "Passed successfully":"Failed"));
        System.out.println("\tTest3: " + (mockitoTesting.testTotalNumberOfMoviesRatedByThirdUser() ? "Passed successfully":"Failed"));
    }

    public void setUpForTestingAverageRate() {
        this.movie = new Movie("movie1");

        movieRatingService = mock(MovieRatingService.class);
        this.movie.setMovieRatingService(movieRatingService);
    }

    public boolean testAverageRate1() {
        List<User> usersThatRatedMovie = new ArrayList<User>();
        usersThatRatedMovie.add(new User("user1"));
        usersThatRatedMovie.add(new User("user2"));
        usersThatRatedMovie.add(new User("user3"));
        usersThatRatedMovie.add(new User("user4"));
        usersThatRatedMovie.add(new User("user5"));

        movie.setUsers(usersThatRatedMovie);

        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(0).getUsername())).thenReturn(4);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(1).getUsername())).thenReturn(3);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(2).getUsername())).thenReturn(4);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(3).getUsername())).thenReturn(4);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(4).getUsername())).thenReturn(5);

        movie.setMovieRatingService(movieRatingService);

        return movie.getAverageRating() == 4;
    }

    public boolean testAverageRate2() {
        List<User> usersThatRatedMovie = new ArrayList<User>();
        usersThatRatedMovie.add(new User("user1"));
        usersThatRatedMovie.add(new User("user2"));
        usersThatRatedMovie.add(new User("user3"));
        usersThatRatedMovie.add(new User("user4"));
        usersThatRatedMovie.add(new User("user5"));

        movie.setUsers(usersThatRatedMovie);

        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(0).getUsername())).thenReturn(2);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(1).getUsername())).thenReturn(4);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(2).getUsername())).thenReturn(3);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(3).getUsername())).thenReturn(3);
        when(movieRatingService.getRateFromUser(usersThatRatedMovie.get(4).getUsername())).thenReturn(1);

        movie.setMovieRatingService(movieRatingService);

        return movie.getAverageRating() == (2+4+3+3+1)/5.0;
    }

    public boolean testAverageRate3() {
        List<User> usersThatRatedMovie = new ArrayList<User>();

        movie.setUsers(usersThatRatedMovie);
        movie.setMovieRatingService(movieRatingService);

        return movie.getAverageRating() == 0;
    }


    private List<Movie> movies = new ArrayList<Movie>();

    private MovieRatingService movieRatingService0;
    private MovieRatingService movieRatingService1;
    private MovieRatingService movieRatingService2;
    private MovieRatingService movieRatingService3;
    private MovieRatingService movieRatingService4;

    private List<User> users = new ArrayList<User>();


    public void setUpForTestingTotalNumberOfMoviesRatedByUser() {
        // CREATE 5 MOVIES
        this.movies.add(new Movie("movie0"));
        this.movies.add(new Movie("movie1"));
        this.movies.add(new Movie("movie2"));
        this.movies.add(new Movie("movie3"));
        this.movies.add(new Movie("movie4"));

        // CREATE MOCK SERVICES
        this.movieRatingService0 = mock(MovieRatingService.class);
        this.movieRatingService1 = mock(MovieRatingService.class);
        this.movieRatingService2 = mock(MovieRatingService.class);
        this.movieRatingService3 = mock(MovieRatingService.class);
        this.movieRatingService4 = mock(MovieRatingService.class);

        // SET ONE MOCK SERVICE PER MOVIE
        movies.get(0).setMovieRatingService(movieRatingService0);
        movies.get(1).setMovieRatingService(movieRatingService1);
        movies.get(2).setMovieRatingService(movieRatingService2);
        movies.get(3).setMovieRatingService(movieRatingService3);
        movies.get(4).setMovieRatingService(movieRatingService4);

        // CREATE 3 USERS
        users.add(new User("user0"));
        users.add(new User("user1"));
        users.add(new User("user2"));

        // ADD USERS THAT RATED THE FIRST MOVIE
        List<User> usersThatRatedMovie0 = new ArrayList<User>();
        usersThatRatedMovie0.add(users.get(0));
        usersThatRatedMovie0.add(users.get(1));
        this.movies.get(0).setUsers(usersThatRatedMovie0);

        when(movieRatingService0.getRateFromUser("user0")).thenReturn(3);
        when(movieRatingService0.getRateFromUser("user1")).thenReturn(4);
        when(movieRatingService0.getRateFromUser("user2")).thenReturn(null);


        // ADD USERS THAT RATED THE SECOND MOVIE
        List<User> usersThatRatedMovie1 = new ArrayList<User>();
        usersThatRatedMovie1.add(users.get(0));
        usersThatRatedMovie1.add(users.get(1));
        this.movies.get(1).setUsers(usersThatRatedMovie1);

        when(movieRatingService1.getRateFromUser("user0")).thenReturn(2);
        when(movieRatingService1.getRateFromUser("user1")).thenReturn(3);
        when(movieRatingService1.getRateFromUser("user2")).thenReturn(null);


        // ADD USERS THAT RATED THE THIRD MOVIE
        List<User> usersThatRatedMovie2 = new ArrayList<User>();
        usersThatRatedMovie2.add(users.get(1));
        this.movies.get(2).setUsers(usersThatRatedMovie2);

        when(movieRatingService2.getRateFromUser("user0")).thenReturn(null);
        when(movieRatingService2.getRateFromUser("user1")).thenReturn(5);
        when(movieRatingService2.getRateFromUser("user2")).thenReturn(null);


        // ADD USERS THAT RATED THE FOURTH MOVIE
        List<User> usersThatRatedMovie3 = new ArrayList<User>();
        usersThatRatedMovie3.add(users.get(0));
        usersThatRatedMovie3.add(users.get(1));
        this.movies.get(3).setUsers(usersThatRatedMovie3);

        when(movieRatingService3.getRateFromUser("user0")).thenReturn(2);
        when(movieRatingService3.getRateFromUser("user1")).thenReturn(5);
        when(movieRatingService3.getRateFromUser("user2")).thenReturn(null);


        // ADD USERS THAT RATED THE FIFTH MOVIE
        List<User> usersThatRatedMovie4 = new ArrayList<User>();
        usersThatRatedMovie4.add(users.get(1));
        this.movies.get(4).setUsers(usersThatRatedMovie4);

        when(movieRatingService4.getRateFromUser("user0")).thenReturn(null);
        when(movieRatingService4.getRateFromUser("user1")).thenReturn(4);
        when(movieRatingService4.getRateFromUser("user2")).thenReturn(null);
    }

    public boolean testTotalNumberOfMoviesRatedByFirstUser() {
        return users.get(0).getNumberOfRatedMovies(this.movies) == 3;
    }

    public boolean testTotalNumberOfMoviesRatedBySecondUser() {
        return users.get(1).getNumberOfRatedMovies(this.movies) == 5;
    }

    public boolean testTotalNumberOfMoviesRatedByThirdUser() {
        return users.get(2).getNumberOfRatedMovies(this.movies) == 0;
    }
}

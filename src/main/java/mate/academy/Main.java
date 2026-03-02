package mate.academy;

import mate.academy.lib.Injector;
import mate.academy.model.Movie;
import mate.academy.service.MovieService;

public class Main {

    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.academy");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);

        Movie[] movies = {new Movie(),
                new Movie("1984"),
                new Movie("Better call Saul", "an interesting film")};

        for (Movie movie : movies) {
            movieService.add(movie);
            System.out.println(movie);
        }
    }
}

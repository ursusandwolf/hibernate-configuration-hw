package mate.academy.service;

import mate.academy.dao.MovieDao;
import mate.academy.model.Movie;

public class MovieServiceImpl implements MovieService {
    MovieDao movieDao;
    MovieServiceImpl (MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}

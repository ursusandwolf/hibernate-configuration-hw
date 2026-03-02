package mate.academy.service;

import mate.academy.dao.MovieDao;
import mate.academy.lib.Service;
import mate.academy.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieDao movieDao;

    public MovieServiceImpl() {
    }

    MovieServiceImpl(MovieDao movieDao) {
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

    public MovieDao getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
}

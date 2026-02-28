package mate.academy.dao;

import java.util.Optional;
import mate.academy.model.Movie;
import org.hibernate.Session;

import static mate.academy.util.HibernateUtil.getSessionFactory;

public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        try(Session session = getSessionFactory()
                .getCurrentSession();
        ) {
            session.save(movie);
            session.commit(movie);
            return movie;
        }
        catch (Exception e) {
            throw new DataProcessingException("Can't insert movie " + movie, e);
        }
    }

    @Override
    public Optional<Movie> get(Long id) {
        try(Session session = getSessionFactory()
                .getCurrentSession();
        ) {
            Object o = session.get(String.valueOf(id), Movie.class);
            Movie res = (Movie) o;
            return Optional.ofNullable(res);
        }
        catch (Exception e) {
            throw new DataProcessingException("Can't find id " + id, e);
        }
    }
}

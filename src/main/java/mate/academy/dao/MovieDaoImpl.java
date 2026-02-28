package mate.academy.dao;

import static mate.academy.util.HibernateUtil.getSessionFactory;

import java.util.Optional;
import mate.academy.model.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert movie " + movie, e);
        }
    }

    @Override
    public Optional<Movie> get(Long id) {
        try (Session session = getSessionFactory().openSession()) {

            Movie movie = session.get(Movie.class, id);
            return Optional.ofNullable(movie);

        } catch (Exception e) {
            throw new DataProcessingException("Can't find movie by id " + id, e);
        }
    }
}

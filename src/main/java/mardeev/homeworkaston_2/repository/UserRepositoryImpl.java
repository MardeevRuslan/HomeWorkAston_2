package mardeev.homeworkaston_2.repository;

import lombok.AllArgsConstructor;
import mardeev.homeworkaston_2.config.SessionFactoryConfig;
import mardeev.homeworkaston_2.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private SessionFactoryConfig sessionFactoryConfig;


    @Override
    public Optional<User> findByName(String name) {
        try (Session session = sessionFactoryConfig.getSession()){
            return Optional.ofNullable(session.get(User.class, name));
        }
        catch (HibernateException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean save(User user) {
        try (Session session = sessionFactoryConfig.getSession()){
            session.save(user);
            return true;
        }
        catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(String name, String passwordNew) {
        Optional<User> optionalUser = findByName(name);
        if (optionalUser.isPresent() ) {
            try (Session session = sessionFactoryConfig.getSession()){
                session.update(new User(name, passwordNew));
                return true;
            }
            catch (HibernateException e) {
                return false;
            }
        }
        return false;
    }


    @Override
    public List<User> getUsers() {
        try (Session session = sessionFactoryConfig.getSession()) {
            Query<User> query = session.createQuery("from User", User.class);
            return query.getResultList();
        }
        catch (HibernateException e) {
            return new ArrayList<>(0);
        }
    }
}

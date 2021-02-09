package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.person.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }


}

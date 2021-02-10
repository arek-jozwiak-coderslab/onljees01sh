package pl.coderslab.drink;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DrinkDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Drink drink) {
        entityManager.persist(drink);
    }

    public Drink findById(long id) {
        return entityManager.find(Drink.class, id);
    }

    public void update(Drink drink) {
        entityManager.merge(drink);
    }

    public void delete(Drink drink) {
        entityManager.remove(entityManager.contains(drink) ?
                drink : entityManager.merge(drink));
    }

    public List<Drink> getAll() {
        Query select = entityManager.createQuery("SELECT p from Drink p");
        return select.getResultList();
    }



}

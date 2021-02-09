package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        Query select = entityManager.createQuery("SELECT b from Book b");
        return select.getResultList();
    }

    public List<Book> getByRating(int rating) {
        Query select = entityManager.createQuery("SELECT b from Book b where b.rating=:rat");
        select.setParameter("rat", rating);
        return select.getResultList();
    }

    public List<Book> getAllWithAtLeastOnePublisher() {
        Query select = entityManager.createQuery("SELECT b from Book b join b.publisher");
        return select.getResultList();
    }

    public List<Book> getAllForPublisher(Publisher publisher) {
        Query select = entityManager.createQuery("SELECT b from Book b where b.publisher=:publisher");
        select.setParameter("publisher", publisher);
        return select.getResultList();
    }

    public List<Book> getAllForAuthor(Author author) {
        Query select = entityManager.createQuery("SELECT b from Book b where b.author=:author");
        select.setParameter("author", author);
        return select.getResultList();
    }

    public List<Book> getAllWithAuthors() {
        Query select = entityManager.createQuery("SELECT b from Book b JOIN FETCH b.authors");
        return select.getResultList();
    }


}

package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    public void mergeAuthor(Author author) {
        entityManager.merge(author);
    }

    public void deleteAuthor(Author author) {
        if (!entityManager.contains(author)) {
            author = entityManager.merge(author);
        }
        entityManager.remove(author);
    }

    public List<Author> getAllAuthors() {
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

    public Author find(Long id) {
        return entityManager.find(Author.class, id);
    }

}

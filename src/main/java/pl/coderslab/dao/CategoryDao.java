package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    public void mergeCategory(Category category) {
        entityManager.merge(category);
    }

    public void deleteCategory(Category category) {
        if (!entityManager.contains(category)) {
            category = entityManager.merge(category);
        }
        entityManager.remove(category);
    }

    public List<Category> getAllCategories() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

    public Category find(Long id) {
        return entityManager.find(Category.class, id);
    }

}

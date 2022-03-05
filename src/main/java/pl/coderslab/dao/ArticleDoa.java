package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDoa {

    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }

    public void mergeArticle(Article article) {
        entityManager.merge(article);
    }

    public void deleteArticle(Article article) {
        if (!entityManager.contains(article)) {
            article = entityManager.merge(article);
        }
        entityManager.remove(article);
    }
}

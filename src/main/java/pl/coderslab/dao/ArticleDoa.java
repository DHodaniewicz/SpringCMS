package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    public List<Article> getAllArticles() {
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

    public List<Article> gey5LatestArticles() {
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.crated DESC ");
        query.setMaxResults(5);
        return query.getResultList();
    }


}

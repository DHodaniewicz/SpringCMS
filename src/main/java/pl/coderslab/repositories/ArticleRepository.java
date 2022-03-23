package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

List<Article> findArticlesByCategories(Category category);

}

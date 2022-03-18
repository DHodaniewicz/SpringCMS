package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ArticleDoa;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleDoa articleDoa;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final Validator validator;

    @Autowired
    public ArticleController(ArticleDoa articleDoa, AuthorDao authorDao, CategoryDao categoryDao, Validator validator) {
        this.articleDoa = articleDoa;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.validator = validator;
    }

    @GetMapping("/all")
    public String showAllArticles(Model model) {
        model.addAttribute("articles", articleDoa.getAllArticles());
        return "allarticles.jsp";
    }

    @GetMapping("/add")
    public String viewAddArticle(Model model) {
        model.addAttribute("article", new Article());
        return "addarticle.jsp";
    }

    @PostMapping("/add")
    public String addArticle(Model model, Article article) {
        articleDoa.saveArticle(article);
        return "redirect:/article/all";
    }


    @ModelAttribute("availableAuthors")
    List<Author> availableAuthors() {
        return authorDao.getAllAuthors();
    }

    @ModelAttribute("availableCategories")
    List<Category> availableCategories() {
        return categoryDao.getAllCategories();
    }


}

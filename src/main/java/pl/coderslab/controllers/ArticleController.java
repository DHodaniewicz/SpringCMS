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

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    ArticleDoa articleDoa;
    AuthorDao authorDao;
    CategoryDao categoryDao;

    @Autowired
    public ArticleController(ArticleDoa articleDoa, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDoa = articleDoa;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
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
    public String AddArticle(Model model, Article article) {
        articleDoa.saveArticle(article);
        return "/article/all";
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

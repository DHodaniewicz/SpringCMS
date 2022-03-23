package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ArticleDoa;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;
import pl.coderslab.repositories.ArticleRepository;
import pl.coderslab.repositories.CategoryRepository;

@Controller
public class HomePageController {

    CategoryDao categoryDao;
    ArticleRepository articleRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public HomePageController(CategoryDao categoryDao, ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.categoryDao = categoryDao;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categoryList", categoryDao.getAllCategories());
        return "homepage.jsp";
    }

   @GetMapping("/all-articles/{id}")
   public String allArticles(@PathVariable long id, Model model) {
       Category category = categoryRepository.getById(id);
       model.addAttribute("articles", articleRepository.findArticlesByCategories(category));
       return "/article/articleshome.jsp";
   }

}

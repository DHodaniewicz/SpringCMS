package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ArticleDoa;

@Controller
public class HomePageController {

    ArticleDoa articleDoa;

    @Autowired
    public HomePageController(ArticleDoa articleDoa) {
        this.articleDoa = articleDoa;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articleList", articleDoa.gey5LatestArticles());
        return "homepage.jsp";
    }

}

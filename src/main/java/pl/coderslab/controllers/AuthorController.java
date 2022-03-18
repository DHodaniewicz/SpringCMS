package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import javax.validation.Validator;


@Controller
@RequestMapping("/author")
public class AuthorController {
    AuthorDao authorDao;
    Validator validator;

    @Autowired
    public AuthorController(AuthorDao authorDao, Validator validator) {
        this.authorDao = authorDao;
        this.validator = validator;
    }

    @GetMapping("/all")
    public String allAuthors(Model model) {
        model.addAttribute("allAuthors", authorDao.getAllAuthors());
        return "allauthors.jsp";
    }

    @GetMapping("/add")
    public String viewAddAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "addauthor.jsp";
    }

    @PostMapping("/add")
    public String addAuthor(@Valid Author author, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "addauthor.jsp";
        }
        authorDao.saveAuthor(author);
        return "redirect:/author/all";
    }

    @GetMapping("/update/{id}")
    public String viewUpdateAuthor(@PathVariable Long id, Model model) {
        Author author = authorDao.find(id);
        model.addAttribute("author", author);
        return "/author/updateauthor.jsp";
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@Valid Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/author/updateauthor.jsp";
        }
        authorDao.mergeAuthor(author);
        return "redirect:/author/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorDao.deleteAuthor(authorDao.find(id));
        return "redirect:/author/all";
    }

}

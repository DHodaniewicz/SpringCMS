package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {
    CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/all")
    public String allCategories(Model model) {
        model.addAttribute("allCategories", categoryDao.getAllCategories());
        return "allcategories.jsp";
    }

    @GetMapping("/add")
    public String viewAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory.jsp";
    }

    @PostMapping("/add")
    public String addCategory(Category category) {
        categoryDao.saveCategory(category);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryDao.deleteCategory(categoryDao.find(id));
        return "redirect:/category/all";
    }

    @GetMapping("/update/{id}")
    public String viewUpdateCategory(@PathVariable Long id, Model model) {
        Category category = categoryDao.find(id);
        model.addAttribute("category", category);
        return "/category/updatecategory.jsp";
    }

    @PostMapping("/update/{id}")
    public String updateCategory(Category category) {
        categoryDao.mergeCategory(category);
        return "redirect:/category/all";
    }


}

package pl.coderslab.converters;

import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {
    CategoryDao categoryDao;

    public CategoryConverter(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String source) {
        return categoryDao.find(Long.parseLong(source));
    }
}

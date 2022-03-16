package pl.coderslab.converters;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    AuthorDao authorDao;

    public AuthorConverter(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String source) {
        return authorDao.find(Long.parseLong(source));
    }
}

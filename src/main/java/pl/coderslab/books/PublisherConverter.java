package pl.coderslab.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherDao;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String s) {
        return publisherDao.findById(Long.parseLong(s));
    }
}

package pl.coderslab.twitter.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.repository.TweetRepository;


import java.lang.annotation.Annotation;

@Component
public class TweetConverter implements Converter<String, Tweet> {

    @Autowired
    TweetRepository tweetRepository;


    @Override
    public Tweet convert(String id) {
        return tweetRepository.findFirstById(Integer.parseInt(id));
    }
}

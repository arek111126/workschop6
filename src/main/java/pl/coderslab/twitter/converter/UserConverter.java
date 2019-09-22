package pl.coderslab.twitter.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.entity.User;
import pl.coderslab.twitter.repository.TweetRepository;
import pl.coderslab.twitter.repository.UserRepository;

@Component
public class UserConverter implements Converter<String, User> {

    @Autowired
    UserRepository userRepository;


    @Override
    public User convert(String id) {
        return userRepository.findFirstById(Integer.parseInt(id));
    }
}
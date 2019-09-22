package pl.coderslab.twitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.twitter.entity.Comment;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.entity.User;
import pl.coderslab.twitter.repository.CommentRepository;
import pl.coderslab.twitter.repository.TweetRepository;
import pl.coderslab.twitter.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class TweetController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    CommentRepository commentRepository;


    @PostMapping("/addtweet")
    public String addTweet(@ModelAttribute("tweet") Tweet tweet, Model model, HttpSession session) {

        User user = (User) session.getAttribute("userSaveInSession");
        tweet.setUser(userRepository.findFirstById(user.getId()));
        tweetRepository.save(tweet);
        return "redirect:/login";


    }

    @ModelAttribute("userTweets")
    public List<Tweet> getAllTweets(HttpSession session) {
        User user = (User) session.getAttribute("userSaveInSession");
        List<Tweet> byUserId = tweetRepository.findByUserId(user.getId());
        return byUserId;
    }

    @GetMapping("/usertweets")
    public String getUserTweets(Model model) {
        return "login-user-tweets";
    }

    @GetMapping("/tweetDetail")
    public String tweetDetails(@RequestParam int id, Model model) {
        Tweet currentTweet = tweetRepository.findFirstById(id);
        User user = userRepository.findFirstById(currentTweet.getUser().getId());
        model.addAttribute("currentTweet", currentTweet);
        model.addAttribute("user", user);
        List<Comment> commentList = commentRepository.findAllByTweetOrderByCreatedAsc(currentTweet);
        model.addAttribute("commentList", commentList);
        Comment comment = new Comment();
        comment.setTweet(currentTweet);
        comment.setUser(user);
        model.addAttribute("comment", comment);
        return "tweet-details";

    }
}

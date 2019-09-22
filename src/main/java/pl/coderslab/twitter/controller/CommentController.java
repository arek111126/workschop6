package pl.coderslab.twitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.twitter.entity.Comment;

import pl.coderslab.twitter.repository.CommentRepository;


@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/addcomment")
    public String addComment(@ModelAttribute("comment") Comment comment, Model model) {
        commentRepository.save(comment);
        return "redirect:/tweetDetail?id=" + comment.getTweet().getId();

    }

}

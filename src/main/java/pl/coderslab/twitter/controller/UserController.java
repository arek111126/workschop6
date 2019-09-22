package pl.coderslab.twitter.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.entity.User;
import pl.coderslab.twitter.repository.TweetRepository;
import pl.coderslab.twitter.repository.UserRepository;

import pl.coderslab.twitter.validation.LoginValidationGroup;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"userSaveInSession", "logged"})
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @ModelAttribute("tweetsList")
    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    @GetMapping("/login")
    public String loginUserGet(Model model, HttpSession session) {
        Boolean logged = (Boolean) session.getAttribute("logged");
        if (logged == null) {
            model.addAttribute("user", new User());
            return "login";
        } else {

            model.addAttribute("tweet", new Tweet());
            return "dashboard";
        }


    }

    @PostMapping("/login")
    public String loginUserPost(@Validated({LoginValidationGroup.class}) User user, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors() || !isAuthorize(user)) {
            model.addAttribute("error", "Podales niepoprawne dane do logowania");
            return "login";
        }
        model.addAttribute("logged", true);
        String email = user.getEmail();
        User userSaveInSession = userRepository.findFirstByEmail(email);
        model.addAttribute("userSaveInSession", userSaveInSession);
        model.addAttribute("tweet", new Tweet());

        return "dashboard";


    }

    @GetMapping("/register")
    public String RegisterUserGet(Model model) {
        model.addAttribute("user", new User());
        return "register";


    }

    @PostMapping("/register")
    public String RegisterUserPost(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() || isAuthorize(user)) {
            return "register";
        }
        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashpw);
        userRepository.save(user);
        model.addAttribute("loged", "true");
        user.setPassword("");

        return "login";


    }

    private boolean isAuthorize(User user) {

        String email = user.getEmail();
        String password = user.getPassword();

        User userDb = userRepository.findFirstByEmail(email);
        if (userDb != null) {
            if (BCrypt.checkpw(password, userDb.getPassword())) {
                return true;
            }

        }
        return false;

    }


}

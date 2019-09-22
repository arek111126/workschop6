package pl.coderslab.twitter.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.twitter.entity.Message;
import pl.coderslab.twitter.entity.User;
import pl.coderslab.twitter.repository.MessageRepository;
import pl.coderslab.twitter.repository.UserRepository;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/SentAndReceivedMessages")
    public String getMessages(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSaveInSession");
        List<Message> recivedMessage = messageRepository.findAllByReceiverOrderByCreatedAsc(user);
        model.addAttribute("recivedMessage", recivedMessage);
        List<Message> sendedMessage = messageRepository.findAllBySenderOrderByCreatedAsc(user);
        model.addAttribute("sendedMessage", sendedMessage);
        return "message-all";
    }

    @GetMapping("/showReceivedMessage")
    public String getReceivedMessage(@RequestParam int id, Model model) {
        Message message = messageRepository.findFirstById(id);
        message.setReaded(1);
        messageRepository.save(message);

        model.addAttribute("message", message);

        return "message-detail-received";

    }

    @GetMapping("/showSendedMessage")
    public String getSendedMessage(@RequestParam int id, Model model) {
        Message message = messageRepository.findFirstById(id);
        model.addAttribute("message", message);
        return "message-detail-sended";
    }

    @GetMapping("/createNewMessage")
    public String createMessage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSaveInSession");
        List<User> allUsers =
                userRepository
                        .findAll()
                        .stream()
                        .filter(u -> u.getId() != user.getId())
                        .collect(Collectors.toList());

        Message message = new Message();
        message.setSender(user);
        model.addAttribute("message", message);
        model.addAttribute("allUsers", allUsers);
        return "message-add-new";
    }

    @PostMapping("/createNewMessage")
    public String createNewMessage(@ModelAttribute("message") Message message, Model model) {
        message.setReaded(1);
        messageRepository.save(message);
        return "redirect:/SentAndReceivedMessages";


    }


}

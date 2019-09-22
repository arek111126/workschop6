package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.twitter.entity.Message;
import pl.coderslab.twitter.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    Message findFirstById(int id);

    List<Message> findAllBySenderOrderByCreatedAsc(User sender);

    List<Message> findAllByReceiverOrderByCreatedAsc(User receiver);


}


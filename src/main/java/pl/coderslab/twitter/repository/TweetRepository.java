package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.twitter.entity.Tweet;
import pl.coderslab.twitter.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    @Query("SELECT t FROM Tweet t WHERE t.user.id = :userId")
    List<Tweet> findByUserId(@Param("userId") int userId);

    List<Tweet> findAllByUser(User user);

    Tweet findFirstById(int id);
}

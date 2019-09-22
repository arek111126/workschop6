package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.twitter.entity.Comment;
import pl.coderslab.twitter.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByTweetOrderByCreatedAsc(Tweet tweet);

    @Query("SELECT c FROM Comment c WHERE c.tweet.id = :id ORDER BY c.created ASC")
    List<Comment> findAllByTweetIdOrderByCreatedASC(@Param("id") int id);
}

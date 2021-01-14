package SpringPractice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SpringPractice.entity.Comment;
import SpringPractice.entity.TestBoard;

public interface 

ReplyDao extends JpaRepository<Comment, Long> {

	List<Comment> findByBoardNo(Long idx);


}

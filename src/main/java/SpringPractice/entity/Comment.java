package SpringPractice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentNo; //댓글 번호
	
	@Column (nullable = false)
	private Long boardNo; // 게시물 번호
	
	@Column
	private String writerNm; // 작성자 이름
	
	@Column (nullable = false)
	private String writerId; // 작성자 아이디
	
	@Column
	private String comment; // 댓글내용
	
	@CreatedDate
	@Column(updatable = false) //등록 날짜
	private LocalDate regDt;

}

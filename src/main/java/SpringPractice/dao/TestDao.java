package SpringPractice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SpringPractice.entity.TestBoard;

public interface TestDao extends JpaRepository<TestBoard, Long> {

	@Query
	TestBoard findByIdx(Long idx);

	@Query
	List<TestBoard> findByTitleContaining(String keyward);

}

package SpringPractice.service;

import java.util.List;

import SpringPractice.entity.TestBoard;

public interface TestService {

	void save(TestBoard testBoard);

	List<TestBoard> getList();

	TestBoard findIdx(Long idx);

	void delete(Long idx);

	void update(TestBoard testBoard);

	List<TestBoard> searchList(String keyward);



}

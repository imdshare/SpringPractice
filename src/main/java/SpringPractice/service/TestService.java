package SpringPractice.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import SpringPractice.entity.TestBoard;

public interface TestService {

	void save(TestBoard testBoard);

	ModelAndView getList(int page);

	TestBoard findIdx(Long idx);

	void delete(Long idx);

	void update(TestBoard testBoard);

	List<TestBoard> searchList(String keyward);



}

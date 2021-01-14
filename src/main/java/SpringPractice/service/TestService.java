package SpringPractice.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import SpringPractice.entity.TestBoard;

public interface TestService {

	void save(TestBoard testBoard);

	List<TestBoard> getList(int page, Model model );

	TestBoard findIdx(Long idx);

	void delete(Long idx);

	void update(TestBoard testBoard);

	List<TestBoard> searchList(String keyward);



}

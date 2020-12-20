package SpringPractice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import SpringPractice.dao.TestDao;
import SpringPractice.entity.TestBoard;
import SpringPractice.util.PageInfo;

@Service
public class TestServiceimpl implements TestService{
	
	@Autowired
	TestDao dao;

	@Override
	public void save(TestBoard testBoard) {
		dao.save(testBoard);
	}

	@Override
	public ModelAndView getList(int page) {
		Sort sort = Sort.by(Direction.DESC,"idx");
		int size = 3;
		Pageable pageable=PageRequest.of(page-1, size, sort);
	
		Page<TestBoard> pageInfo=dao.findAll(pageable);
		System.out.println(pageInfo + "pageInfo??????????????");
		List<TestBoard> list=pageInfo.getContent();
		System.out.println("list?????????" + list);
		PageInfo p = new PageInfo(page, pageInfo.getTotalPages());
		System.out.println("p??????????"  + p);
//		List<TestBoard> list =dao.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("page", p);
		return mv;
	}

	@Override
	public TestBoard findIdx(Long idx) {
		TestBoard result = dao.findById(idx).orElse(null);
		System.out.println(result);
		return result;
	}

	@Override
	public void delete(Long idx) {
		dao.deleteById(idx);
	}

	@Transactional
	@Override
	public void update(TestBoard testBoard) {
		dao.findByIdx(testBoard.getIdx());
		dao.save(testBoard);
	}

	@Transactional
	@Override
	public List<TestBoard> searchList(String keyward) {
		List<TestBoard> list=dao.findByTitleContaining(keyward);
	
		return list;
	}



}

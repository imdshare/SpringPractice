package SpringPractice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringPractice.dao.TestDao;
import SpringPractice.entity.TestBoard;

@Service
public class TestServiceimpl implements TestService{
	
	@Autowired
	TestDao dao;

	@Override
	public void save(TestBoard testBoard) {
		dao.save(testBoard);
	}

	@Override
	public List<TestBoard> getList() {
		List<TestBoard> list =dao.findAll();
		return list;
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

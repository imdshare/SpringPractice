package SpringPractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringPractice.entity.TestBoard;
import SpringPractice.service.TestService;


@Controller
public class MainContoller {
	
	@Autowired
	TestService testService;
	
	
	@GetMapping
	public String home(Model model) {
		List <TestBoard> list=testService.getList();
		if(list != null)
		model.addAttribute("list",list);
	
		return "index";
	}
	
	@RequestMapping("/test/write.do")
	public String write() {
		return "/board/write";
	}
	
	
	@RequestMapping("/test/save.do")
	public String save(TestBoard testBoard) {
		testService.save(testBoard);
		return "redirect:/";
	}
	
	@GetMapping("/test/{idx}")
	public String detail(@PathVariable Long idx, Model model) {
		TestBoard detail=testService.findIdx(idx);
		model.addAttribute("detail", detail);
		return "/board/detail";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable Long idx) {
		testService.delete(idx);
		return "redirect:/";
	}
	

	@GetMapping("/update/{idx}")
	public String update(@PathVariable Long idx , Model model) {
		TestBoard detail=testService.findIdx(idx);
		model.addAttribute("detail", detail);
		return "/board/update";
	}
	
	@PostMapping("/update")
	public String update(TestBoard testBoard) {
		testService.update(testBoard);
		return "redirect:/";
	}
	

}

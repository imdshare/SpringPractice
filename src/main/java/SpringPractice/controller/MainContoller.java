package SpringPractice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import SpringPractice.entity.TestBoard;
import SpringPractice.service.TestService;


@Controller
public class MainContoller {
	
	@Autowired
	TestService testService;
	
	
	@GetMapping("/{page}")
	public ModelAndView home(Model model, @PathVariable int page) {
	ModelAndView mv =testService.getList(page);
	mv.setViewName("index");
	
		return mv;
	}
	
	@RequestMapping("/test/write.do")
	public String write() {
		return "/board/write";
	}
	
	
	@RequestMapping("/test/save.do")
	public String save(TestBoard testBoard, MultipartFile files) throws IOException {
		String fileName=files.getOriginalFilename();
		testBoard.setFileNm(fileName);
		
//		ClassPathResource cr=new ClassPathResource("static/upload"); //bin�뿉 ���옣�맖
//		File dir=cr.getFile();
//		File dest=new File(dir,fileName);
//		files.transferTo(dest);
		testService.save(testBoard);
		return "redirect:/"+1;
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
		return "redirect:/"+1;
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
		return "redirect:/"+1;
	}
	
	@GetMapping("/search.do")
	public String search(@RequestParam(value = "keyward") String keyward, Model model) {
		List<TestBoard> searchList = testService.searchList(keyward);
		model.addAttribute("searchList", searchList);
		return "index";
	}
	

}

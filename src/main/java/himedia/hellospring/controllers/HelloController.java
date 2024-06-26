package himedia.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import himedia.hellospring.vo.UserVO;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(value = "name", required = false, defaultValue = ("익명")) String name) { // 기본적인
																													// 요청
																													// 파라미터
//		서블릿에서 getParameter로 받아온 행위 -> @RequestParam(파라미터명)
		ModelAndView mav = new ModelAndView(); // 데이터와 뷰 정보를 함께 가진 객체

		mav.addObject("message", "Hello, " + name);
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}

	@RequestMapping("/hello2")
//	return type: String -> ViewName을 의미.
	public String hello2(@RequestParam("name") String name, @RequestParam("no") int no,
			@RequestParam("password") String password) {
		System.out.println("name:" + name);
		System.out.println("no:" + no);
		System.out.println("password:" + password);
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@ResponseBody // 리턴된 문자열을 직접 응답으로 출력 (MessageConverter)
	@RequestMapping("/hello3")
	public String hello3(@ModelAttribute UserVO vo) {
		// @ModelAttribute : 복잡한 요청 파라미터를 자동으로 Vo에 매핑
		
		
		return "<h1>Request</h1><p>"+vo+"</p>";
	}
}

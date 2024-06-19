package himedia.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam("name") String name) {
//		서블릿에서 getParameter로 받아온 행위 -> @RequestParam(파라미터명)
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello, "+name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
}

package springmvc_ctrltoui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_ctrltoui.dtos.UserInfoDto;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@GetMapping
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("id", "id");
		modelAndView.addObject("password", "pw");
		modelAndView.addObject("salary", 0);
		
		return modelAndView;
	}
	
	@RequestMapping("/uiobj01")
	@GetMapping
	public ModelAndView uiobj01() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("uiobj01view");
		modelAndView.addObject("uiobj01", new UserInfoDto("id01", "pw01", "u"));
		return modelAndView;
	}

}

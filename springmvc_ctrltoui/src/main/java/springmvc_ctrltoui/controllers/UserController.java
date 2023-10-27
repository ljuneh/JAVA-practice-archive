package springmvc_ctrltoui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_ctrltoui.dtos.User;

@Controller
public class UserController {
	@RequestMapping("/userregister")
	public ModelAndView register(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		System.out.println(user);
		return modelAndView;
		
	}

}

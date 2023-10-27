package springmvc_ctrltoui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamController {
	@RequestMapping("/showParam")
	public ModelAndView showParam(@RequestParam("id") String id,
													@RequestParam("name") String name,
													@RequestParam(value = "salary", required = false) String salary) {
		ModelAndView modelAndView = new ModelAndView();
		
	    System.out.println(id + " : " + name + " : " + salary);
	    
	    if(salary=="") {
	    	System.out.println("no inputed salary");
	    } else {
	    	System.out.println("salary printed");
	    }
		
		modelAndView.setViewName("../../inputUser");
		return modelAndView;
	}
	
	@RequestMapping("/inputUser")
	public ModelAndView inputUser() {
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName("user");
		return modelAndView;
	}
	@RequestMapping("/outputUser")
	public ModelAndView outputUser(@RequestParam("id") String id,
												@RequestParam("name") String name,
												@RequestParam(value = "salary", required = false) String salary) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("id", id);
		modelAndView.addObject("name", name);
		modelAndView.addObject("salary", salary);
		
		modelAndView.setViewName("user");
		return modelAndView;
	}

}

package com.example.javawebdev;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.example.javawebdev.biz.MessageService;

@Controller("/hello")
public class HelloController extends AbstractController {

	@Autowired
	protected MessageService messageService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String key = request.getParameter("key");
		String value = messageService.getMessage(key);
		return new ModelAndView("hello", "value", value);
	}

}

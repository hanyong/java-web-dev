package com.example.javawebdev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HttpServletBean;

import com.example.javawebdev.biz.MessageService;

@Controller("/helloServlet")
public class HelloServlet extends HttpServletBean {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
	
	@Autowired
	protected MessageService messageService;

	@PostConstruct
	@Override
	protected void initServletBean() throws ServletException {
		super.initServletBean();
		logger.info("HelloServlet.initServletBean ...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = messageService.getMessage(key);
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.printf("Hello Servlet %s\n", value);
	}
	
}

package com.example.javawebdev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HttpServletBean;

import com.example.javawebdev.biz.MessageService;

public class HelloServlet extends HttpServletBean implements HttpRequestHandler {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	protected MessageService messageService;

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
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

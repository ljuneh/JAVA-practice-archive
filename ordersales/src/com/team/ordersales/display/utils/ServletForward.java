package com.team.ordersales.display.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForward {
	public void pageForward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				req.getRequestDispatcher(req.getAttribute("pageurl").toString());
		
		req.removeAttribute("pageurl");
		
		dispatcher.forward(req, resp);
	}

}


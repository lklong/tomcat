package com.lkl.muyi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LKLServlet
 */
public class LongURLPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LongURLPatternServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletPath());
		System.out.println("已经进入请求部分！");
		System.out.println("-----------------------------------------------------------------------------------------------");
		String path = request.getServletPath();
		if("/hello/welcome".equals(path)){
			PrintWriter out = response.getWriter();
			out.write("欢迎访问\n哈哈asfasdfasd哈哈哈哈哈哈哈哈哈哈哈哈哈哈jasdfjaskdfjkasdfjasdkfjkjafkdasjf");
		}
	}
 
}

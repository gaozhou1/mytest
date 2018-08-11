package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.UserDao;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取前台页面表单信息
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//拼接sql语句
		String sql="insert into user(username,password)" +
				" values('"+username+"','"+password+"')";
		//创建dao对象
		UserDao dao=new UserDao();
		//执行操作
		try {
			dao.addUser(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//请求转发
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

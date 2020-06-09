package com.qst.not.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.not.result.Result;
import com.qst.note.bean.UserBean;
import com.qst.note.dao.UserDao;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserBean user=new UserBean();
		user.setName(request.getParameter("name"));
		user.setPass(request.getParameter("pass"));
		user.setTel(request.getParameter("tel"));
		UserDao userdao=new UserDao();
		Boolean b=userdao.regist(user);
		Result r=new Result();
		r.isSuccess=b;
		if(b) {
			r.msg="¹§Ï²Äú×¢²á³É¹¦";
		}else {
			r.msg="×¢²áÊ§°Ü£¬¸ÃÊÖ»úºÅÒÑ±»×¢²á";
		}
		Gson gson=new Gson();
		response.getWriter().append(gson.toJson(r));
	}

}

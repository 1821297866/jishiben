package com.qst.not.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.not.result.Result;
import com.qst.note.dao.NoteDao;

/**
 * Servlet implementation class InsertNoteServlet
 */
@WebServlet("/InsertNoteServlet")
public class InsertNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoteServlet() {
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
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String tel=request.getParameter("tel");
		String noteTime=request.getParameter("noteTime");
		NoteDao dao=new NoteDao();
		Result rl=new Result();
		rl.isSuccess=dao.insert(title, content, noteTime, tel);
		rl.msg=rl.isSuccess?"记录成功":"保存失败";
		Gson gson=new Gson();
		response.getWriter().append(gson.toJson(rl));
		
	}

}

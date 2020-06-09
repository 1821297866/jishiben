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
 * Servlet implementation class UpdateNoteServlet
 */
@WebServlet("/UpdateNoteServlet")
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String noteTime=request.getParameter("noteTime");
		int id=Integer.valueOf(request.getParameter("id"));
		NoteDao dao=new NoteDao();
		Gson gson=new Gson();
		Result re=new Result();
		re.isSuccess=dao.ModifyNote(id, title, content, noteTime);
		re.msg=re.isSuccess?"记录成功":"保存失败";
		response.getWriter().append(gson.toJson(re));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

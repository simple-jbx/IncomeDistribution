package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.YH;
import service.LoginService;
import utils.StringUtils;

/**
 * Servlet implementation class loginController
 */
@WebServlet(name = "getMenuJSON", urlPatterns = { "/getMenuJSON.do" })
public class getMenuJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMenuJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");      
        response.setCharacterEncoding("utf-8");
        YH currentYH = (YH)request.getSession().getAttribute("currentYH");
        String basePath = (String)request.getSession().getAttribute("basePath");
        if(currentYH == null) {
			response.sendRedirect(basePath+"/index.jsp");
        }
		
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}
}

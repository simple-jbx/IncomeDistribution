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
import service.YHService;
import utils.SHA1Utils;

/**
 * Servlet implementation class changePassword
 */
@WebServlet(name = "changePassController", urlPatterns = { "/changePassController.do" })
public class changePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");      
        response.setCharacterEncoding("utf-8");
       
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		YH currentYH = (YH)session.getAttribute("currentYH");
		String oldPass = (String)request.getParameter("inputOldPass");
		String newPass = (String)request.getParameter("inputNewPass");
		if(!SHA1Utils.sha1Encode(oldPass).equals(currentYH.getMM())) {
			out.print("-1");//原密码不正确
		}else {
			//session.removeAttribute("currentYH");
			newPass = SHA1Utils.sha1Encode(newPass);
			currentYH.setMM(newPass);
			YHService yhService = new YHService();
			yhService.updateData(currentYH);
			out.print("1");
		}
	}
}

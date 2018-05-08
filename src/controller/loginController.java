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
@WebServlet(name = "loginController", urlPatterns = { "/loginController.do" })
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
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
		String accountNo = (String)request.getParameter("accountNo");
		String password = (String)request.getParameter("password");
		//System.out.println(password + " " + accountNo); 
		PrintWriter out = response.getWriter();
		LoginService loginService = new LoginService();
		YH currentYH = loginService.getYH(accountNo);
		if(StringUtils.isEmpty(accountNo) || StringUtils.isEmpty(password)) {
			out.print(-1);//密码或用户名为空
		}else if(currentYH == null){
			out.print(-2);//该用户不存在
		}else{
			String encodePass = "";
			try {
				 encodePass = utils.SHA1Utils.sha1Encode(password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				encodePass = "";
				out.print(-4);//系统错误
				e.printStackTrace();
			}
			if(encodePass.equals(currentYH.getMM())){
				out.print(0);//登陆成功
				currentYH.setMM("-");
				HttpSession session = request.getSession(); 
				session.setAttribute("currentYH", currentYH);
				//System.out.println(currentYH.toJson());
			}else
				out.print(-3);//密码错误
		}		
		out.flush();
		out.close();
	}
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import bean.*;
import service.*;
import utils.List2JsonUtils;
import utils.StringUtils;

/**
 * Servlet implementation class commonController
 */
@WebServlet("/commonController")
public class commonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated beanMethod stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated beanMethod stub
		request.setCharacterEncoding("utf-8");      
        response.setCharacterEncoding("utf-8");
		
	}
	
	
	public <T> void realizeDoPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		String op  = request.getParameter("op");
		String classType = request.getParameter("type");
		Object beanObject = null;
		Object serviceObject = null;
		Method beanMethod = null, serviceMethod = null;
		String value = "";
		if(classType.equals("jsxljshfwsj")) {
			beanObject = new JSXLJSHFWSJ();
			serviceObject = new JSXLJSHFWSJService();
			beanMethod = beanObject.getClass().getMethod("toJson");
		}
		YH yh = (YH)session.getAttribute("yh");
		if(yh != null) {
			if(StringUtils.isEmpty(op)) {
				response.sendRedirect("../index.jsp");
			}else if(op.equals("personal")) {
				//beanClass = commonService.getDataByRydm(beanClass.getClass(), yh.getGH());
				beanObject = commonService.getDataByRydm(beanObject.getClass(), yh.getRYDM());
				if(beanObject != null) {
					beanMethod.invoke(beanObject, value);
					out.print(value);
				}else {
					out.print("0");//没有数据
				}
			}else if(yh.getYHGROUP() == 0 || yh.getYHGROUP() == 1) {
				String json = "";
				List<Map<String, Object> > list;
				if(op.equals("update")) {
					String row = request.getParameter("row");
					if(StringUtils.isEmpty(row)) {
						out.print("-1");//请求数据为空
					}else {
						serviceMethod = serviceObject.getClass().getMethod("updateData");
						beanObject = JSON.parseObject(row, beanObject.getClass());
						serviceMethod.invoke(beanObject);
						out.println("1");
					}
					
				}else if(op.equals("delete")) {
					String iD = request.getParameter("ID");//获得从前端传来的工号
					if(StringUtils.isEmpty(iD)) {
						out.print("-1");//请求数据为空
					}else {
						commonService.deleteByID(beanObject.getClass(), iD);
						out.print("1");					
					}
				}else if(op.equals("getAll")) {
					list = commonService.getAllData(beanObject.getClass());
					if(list == null) {
						out.print("0");//没有数据
					}else {
						json = List2JsonUtils.list2Json2String(list);
						out.print(json);
					}
				}else {
					response.sendRedirect("../index.jsp");
				}
			}
		}else {
			response.sendRedirect("../login.jsp");
		}
	}

}

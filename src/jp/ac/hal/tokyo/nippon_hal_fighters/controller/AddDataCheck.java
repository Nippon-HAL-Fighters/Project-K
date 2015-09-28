package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanieDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class AddDataCheck
 */
@WebServlet("/AddDataCheck")
public class AddDataCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		OrganaizationBean orgBean = null;
		PostBean postBean = null;
		CompanieBean compBean = null;
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddCheckMaster.jsp");
		
		String orgId="";
		String addData="";
		
		int num;
		
		int hanbetu = Integer.parseInt(request.getParameter("addtype"));
		
		switch(hanbetu){
		case 1:
			num =1;
				orgId = request.getParameter("orgid");
				addData = request.getParameter("orgaddtext");
				orgBean = new OrganaizationBean();
				orgBean.setOrganaizationId(orgId);
				orgBean.setOrganaizationName(addData);
				request.setAttribute("orgBean", orgBean);
				request.setAttribute("addtype", num);
				dispatcher.forward(request, response);
				break;
				
		case 2:
			num =2;
				addData = request.getParameter("postaddtext");
				postBean = new PostBean();
				postBean.setPostName(addData);
				request.setAttribute("postBean", postBean);
				request.setAttribute("addtype", num);
				dispatcher.forward(request, response);
				break;

		case 3:
			num =3;
				addData = request.getParameter("compaddtext");
				compBean = new CompanieBean();
				compBean.setCompanyName(addData);
				request.setAttribute("compBean", compBean);
				request.setAttribute("addtype", num);
				dispatcher.forward(request, response);
				break;
		}
	}	
}


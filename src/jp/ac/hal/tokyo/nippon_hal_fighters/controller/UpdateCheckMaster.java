package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;

/**
 * Servlet implementation class UpdateCheckMaster
 */
@WebServlet("/UpdateCheckMaster")
public class UpdateCheckMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCheckMaster() {
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
		
		String updatetype = request.getParameter("updateType");	
		System.out.print(updatetype);
		
		request.setCharacterEncoding("UTF-8");
		
		OrganaizationBean orgBean = null;
		PostBean postBean = null;
		CompanieBean compBean = null;
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCheckMaster.jsp");
		
		String orgId="";
		String ordId="";
		int postId;
		int compId;
		String updData="";
		
		switch(updatetype){
			case "org":
				orgId = request.getParameter("orgid");
				ordId = request.getParameter("ordid");
				updData = request.getParameter("orgname");
				orgBean = new OrganaizationBean();
				orgBean.setOrganaizationId(orgId);
				orgBean.setOrganaizationName(updData);
				request.setAttribute("orgBean", orgBean);
				request.setAttribute("ordid", ordId);
				request.setAttribute("updatetype", updatetype);
				dispatcher.forward(request, response);
				break;
				
			case "post":
				postId = Integer.parseInt(request.getParameter("postid"));
				updData = request.getParameter("postname");
				postBean = new PostBean();
				postBean.setPostId(postId);
				postBean.setPostName(updData);
				request.setAttribute("postBean", postBean);
				request.setAttribute("updatetype", updatetype);
				dispatcher.forward(request, response);
				break;
				
			case "comp":
				compId = Integer.parseInt(request.getParameter("compid"));
				updData = request.getParameter("compname");
				compBean = new CompanieBean();
				compBean.setCompanyId(compId);
				compBean.setCompanyName(updData);
				request.setAttribute("compBean", compBean);
				request.setAttribute("updatetype", updatetype);
				dispatcher.forward(request, response);
				break;
			
				
		}
	}

}

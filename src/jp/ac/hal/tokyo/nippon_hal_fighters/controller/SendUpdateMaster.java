package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class UpdateMaster
 */
@WebServlet("/SendUpdateMaster")
public class SendUpdateMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendUpdateMaster() {
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
		request.setCharacterEncoding("utf-8");
		
		String updatetype = request.getParameter("updateType");		
		OrganaizationBean orgBean = null;
		PostBean postBean = null;
		CompanieBean compBean = null;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateMaster.jsp");
		
		//更新に必要なデータ一覧を取得。次で表示させる。
		switch (updatetype) {
		case "org":			//組織の場合
			String orgid = request.getParameter("OrganaizationID");
			String orgname = request.getParameter("OrganaizationName");
			orgBean = new OrganaizationBean();
			orgBean.setOrganaizationId(orgid);
			orgBean.setOrganaizationName(orgname);
			request.setAttribute("orgBean", orgBean);
			request.setAttribute("updatetype", updatetype);
			dispatcher.forward(request, response);
			break;
			
		case "post":			//組織の場合
			int postid = Integer.parseInt(request.getParameter("PostID"));
			String postname = request.getParameter("PostName");
			postBean = new PostBean();
			postBean.setPostId(postid);
			postBean.setPostName(postname);
			request.setAttribute("postBean", postBean);
			request.setAttribute("updatetype", updatetype);
			dispatcher.forward(request, response);
			break;
			
		case "comp":			//組織の場合
			int compid = Integer.parseInt(request.getParameter("CompanyID"));
			String compname = request.getParameter("CompanyName");
			compBean = new CompanieBean();
			compBean.setCompanyId(compid);
			compBean.setCompanyName(compname);
			request.setAttribute("compBean", compBean);
			request.setAttribute("updatetype", updatetype);
			dispatcher.forward(request, response);
			break;
		}		
	}

}

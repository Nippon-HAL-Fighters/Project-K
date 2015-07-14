package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanyDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class ChangeMasterServlet
 */
@WebServlet("/ChangeMasterServlet")
public class ChangeMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeMasterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 判別用の数字
		int num;

		String keyword = request.getParameter("category");
		//System.out.print(keyword);

		switch (keyword) {
		// 組織の場合ここから
		case "organaization":
			num = 1;
			request.setAttribute("num", num);
			RequestDispatcher orgdisp = request.getRequestDispatcher("GetOrganizationServlet");
			orgdisp.forward(request, response);
			break;

		// 役職の場合ここから
		case "post":
			num = 2;
			request.setAttribute("num", num);
			RequestDispatcher postdisp = request.getRequestDispatcher("GetPostsServlet");
			postdisp.forward(request, response);
			break;

		// 会社の場合ここから
		case "company":
			num = 3;
			request.setAttribute("num", num);
			RequestDispatcher companyDisp = request.getRequestDispatcher("GetCompanyServlet");
			companyDisp.forward(request, response);
			break;
		}// switch　終了
	}
}

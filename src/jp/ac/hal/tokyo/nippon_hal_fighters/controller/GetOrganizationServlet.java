package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/GetOrganizationServlet")
public class GetOrganizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOrganizationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//表示するための条件
		int num = 1;

		// DAO定義
		OrganaizationDao organizationDao = new OrganaizationDao();

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<OrganaizationBean> selectData = new ArrayList<OrganaizationBean>();
		try {
			selectData = organizationDao.selectAllOrganaiation();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				organizationDao.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		request.setAttribute("recode", selectData);
		request.setAttribute("num", num);
		// データを取得してから一覧へ遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("master.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//表示するための条件
		int num = 1;

		// DAO定義
		OrganaizationDao organizationDao = new OrganaizationDao();

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<OrganaizationBean> selectData = new ArrayList<OrganaizationBean>();
		try {
			selectData = organizationDao.selectAllOrganaiation();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				organizationDao.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		request.setAttribute("recode", selectData);
		request.setAttribute("num", num);
		// データを取得してから一覧へ遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("master.jsp");
		dispatcher.forward(request, response);

	}

}

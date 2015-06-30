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

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class GetPhoneInsideServlet
 */
@WebServlet("/GetPhoneServlet")
public class GetPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPhoneServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 表示するための条件
		int num = 3;

		// DAO定義
		DBConnecter connecter = new DBConnecter();
		Connection con = null;

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<PhoneBean> selectData = new ArrayList<PhoneBean>();
		try {
			con = connecter.getConnection();
			PhoneDao phoneDao = new PhoneDao(con);
			selectData = phoneDao.selectAll();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 表示するための条件
		int num=(Integer)request.getAttribute("num");
		System.out.println(num);
		
		// DAO定義
		DBConnecter connecter = new DBConnecter();
		Connection con = null;

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<PhoneBean> selectData = new ArrayList<PhoneBean>();
		try {
			con = connecter.getConnection();
			PhoneDao phoneDao = new PhoneDao(con);
			selectData = phoneDao.selectAll();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
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

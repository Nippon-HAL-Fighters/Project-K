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
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/GetPostsServlet")
public class GetPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPostsServlet() {
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

		// 表示するための条件
		int num = 2;

		DBConnecter connecter = new DBConnecter();
		Connection con = connecter.getConnection();
		// DAO定義
		PostDao postDao = null;

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<PostBean> selectData = new ArrayList<PostBean>();
		try {
			postDao = new PostDao(con);
			selectData = postDao.selectAllPosts();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				if(con != null){
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		request.setAttribute("recode", selectData);
		request.setAttribute("num", num);
		System.out.println(num);
		// データを取得してから一覧へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("master.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 表示するための条件
		int num = 2;

		// DAO定義
		PostDao postDao = new PostDao();

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<PostBean> selectData = new ArrayList<PostBean>();
		try {
			selectData = postDao.selectAllPosts();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				postDao.close();
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

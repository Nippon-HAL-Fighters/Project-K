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

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
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
		DBConnecter connecter = new DBConnecter();
		Connection con = connecter.getConnection();

		// OrganaizationDaoインスタンス化
		OrganaizationDao organaizationDao = new OrganaizationDao(con);
		ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();

		// PostDaoインスタンス化
		PostDao postDao = new PostDao(con);
		ArrayList<PostBean> postList = new ArrayList<PostBean>();

		//PhoneDaoインスタンス化
		PhoneDao phoneDao = new PhoneDao(con);
		
		ArrayList<PhoneBean> phoneInsideList = new ArrayList<PhoneBean>();
		//
		ArrayList<PhoneBean> phoneOutsideList = new ArrayList<PhoneBean>();

		//
		
		
		// 判別用の数字
		int num;

		String keyword = request.getParameter("category");
		System.out.print(keyword);

		switch (keyword) {
		// 組織の場合ここから
		case "organaization":
			num = 1;
			try {
				organaizationList = organaizationDao.selectAllOrganaiation();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			System.out.print(num);
			request.setAttribute("recode", organaizationList);
			// request.setAttribute("orglist", orglist);
			break;

		// 役職の場合ここから
		case "post":
			num = 2;
			try {
				postList = postDao.selectAllPosts();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			request.setAttribute("recode", postList);
			break;

		// 内線電話の場合ここから
		case "phoneInside":
			num = 3;
			try {
				phoneInsideList = phoneDao.selectAllInsidePhone();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			request.setAttribute("recode", phoneInsideList);
			break;
			
		// 外線電話の場合ここから
		case "phoneOutside":
			num = 4;
			try {
				phoneOutsideList = phoneDao.selectAllOutsidePhone();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			request.setAttribute("recode", phoneOutsideList);
			break;
		/**
		 * // 会社の場合ここから case "company": try { orglist =
		 * organaizationDao.selectAllOrganaiation(); } catch (SQLException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } finally {
		 * try { con.close(); } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } } request.setAttribute("orglist",
		 * orglist); break;
		 **/
		}// switch　終了
		RequestDispatcher disp = request.getRequestDispatcher("master.jsp");
		disp.forward(request, response);
	}
}

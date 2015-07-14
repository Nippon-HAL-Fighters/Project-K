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
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanyDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class AddDataServlet
 */
@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDataServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 追加するデータの内容
		String addData = "";
		
		DBConnecter connecter = new DBConnecter();
		Connection con = connecter.getConnection();
		String orgId;
		

		// OrganaizationDaoインスタンス化
		OrganaizationDao organaizationDao = new OrganaizationDao(con);
		OrganaizationBean orgrecode = new OrganaizationBean();
		ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();

		// PostDaoインスタンス化
		PostDao postDao = new PostDao(con);
		PostBean postrecode = new PostBean();
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		// postid
		int postId;

		// CompanyDaoインスタンス化
		CompanyDao companyDao = new CompanyDao(con);
		CompanieBean companyrecode = new CompanieBean();
		ArrayList<CompanieBean> companyList = new ArrayList<CompanieBean>();
		// companyId
		int companyId;

		// 判別用の数字
		int num;

		String keyword = request.getParameter("category");
		int hanbetu = Integer.parseInt(request.getParameter("addtype"));
		//System.out.print(hanbetu);
		// System.out.print(keyword);

		switch (hanbetu) {
		// 組織の場合ここから
		case 1:
			num = 1;
			try {
					orgId = request.getParameter("orgid");
					addData = request.getParameter("orgaddtext");
					orgrecode.setOrganaizationId(orgId);
					orgrecode.setOrganaizationName(addData);
					organaizationDao.insertOrganaiation(orgrecode);
					postDao.commit();
					organaizationList = organaizationDao.selectAllOrganaiation();
					//}
				
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
			request.setAttribute("num", 1);
			request.setAttribute("recode", organaizationList);
			RequestDispatcher orgdisp = request.getRequestDispatcher("master.jsp");
			orgdisp.forward(request, response);
			break;

		// 役職の場合ここから
		case 2:
			num = 2;
			try {
				addData = request.getParameter("postaddtext");
				//System.out.println("add:" + addData);
				postId = postDao.datacount();
				postId = postId + 1;
				postrecode.setPostName(addData);
				postrecode.setPostId(postId);
				postDao.insertPost(postrecode);
				postDao.commit();
				postList = postDao.selectAllPosts();
				
			} catch (Exception e) {
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
			request.setAttribute("num", 2);
			request.setAttribute("recode", postList);
			RequestDispatcher postdisp = request
					.getRequestDispatcher("master.jsp");
			postdisp.forward(request, response);
			break;

		// 所属会社の場合ここから
		case 3:
			num = 3;
			try {
				addData = request.getParameter("compaddtext");
				companyId = companyDao.datacount();
				companyId = companyId + 1;
				companyrecode.setCompanyId(companyId);
				companyrecode.setCompanyName(addData);
				companyDao.insertCompany(companyrecode);
				companyDao.commit();
				companyList = companyDao.selectAll();
				
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
			request.setAttribute("num", 3);
			request.setAttribute("recode", companyList);
			RequestDispatcher companydisp = request
					.getRequestDispatcher("master.jsp");
			companydisp.forward(request, response);
			break;
		}// switch　終了
	}

}

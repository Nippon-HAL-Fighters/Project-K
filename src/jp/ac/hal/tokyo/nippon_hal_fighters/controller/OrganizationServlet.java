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
@WebServlet("/OrganizationServlet")
public class OrganizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrganizationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");

		request.setCharacterEncoding("utf-8");

		// DAO定義
		OrganaizationDao organizationDao = new OrganaizationDao();

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<OrganaizationBean> selectData = new ArrayList<OrganaizationBean>();
		try {
			selectData = organizationDao.selectAllOrganaiation();
			System.out.println("要素数" + selectData.size());

			for (int i = 0; i < selectData.size(); i++) {
				System.out.println(selectData.get(i).getOrganaizationId());
				System.out.println(selectData.get(i).getOrganaizationName());
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				organizationDao.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		request.setAttribute("recode", selectData);
		// データを取得してから一覧へ遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("master.jsp");
		dispatcher.forward(request, response);

		// 登録情報取得
		// OrganizationId = request.getParameter("OrganizationId");
		// OrganizationName = request.getParameter("OrganizationName");

		// System.out.println(employeeId);
		// System.out.println(employeeName);

		/**
		 * // Bean 作成 & データセット EmployeeBean insertData = new EmployeeBean();
		 * 
		 * insertData.setEmployeeId(employeeId);
		 * insertData.setEmployeeName(employeeName);
		 * 
		 * // 情報登録実行 try { insertResult =
		 * insertOrganizationDao.insertOrganization(insertData);
		 * insertEmployeeDao.commit(); } catch (SQLException e) { //
		 * INSERTエラー発生時実行 try { insertEmployeeDao.rollback(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } e.printStackTrace(); }
		 * finally { // Daoクローズ try { insertEmployeeDao.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 **/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// DAO定義
		OrganaizationDao organizationDao = new OrganaizationDao();

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<OrganaizationBean> selectData = new ArrayList<OrganaizationBean>();
		try {
			selectData = organizationDao.selectAllOrganaiation();
			System.out.println("要素数" + selectData.size());

			for (int i = 0; i < selectData.size(); i++) {
				System.out.println(selectData.get(i).getOrganaizationId());
				System.out.println(selectData.get(i).getOrganaizationName());
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				organizationDao.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		request.setAttribute("recode", selectData);
		// データを取得してから一覧へ遷移
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("master.jsp");
		dispatcher.forward(request, response);

		// 登録情報取得
		// OrganizationId = request.getParameter("OrganizationId");
		// OrganizationName = request.getParameter("OrganizationName");

		// System.out.println(employeeId);
		// System.out.println(employeeName);

		/**
		 * // Bean 作成 & データセット EmployeeBean insertData = new EmployeeBean();
		 * 
		 * insertData.setEmployeeId(employeeId);
		 * insertData.setEmployeeName(employeeName);
		 * 
		 * // 情報登録実行 try { insertResult =
		 * insertOrganizationDao.insertOrganization(insertData);
		 * insertEmployeeDao.commit(); } catch (SQLException e) { //
		 * INSERTエラー発生時実行 try { insertEmployeeDao.rollback(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } e.printStackTrace(); }
		 * finally { // Daoクローズ try { insertEmployeeDao.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 **/

	}

}

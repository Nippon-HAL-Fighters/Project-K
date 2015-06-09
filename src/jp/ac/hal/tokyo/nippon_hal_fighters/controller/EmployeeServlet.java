package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// DAO定義
		EmployeeDao employeeDao = new EmployeeDao();

		/*
		 * 以下 Connecter＆DAO テスト用
		 */
		ArrayList<EmployeeBean> selectData = new ArrayList<EmployeeBean>();
		try {
			selectData = employeeDao.selectAllEmployees();
			System.out.println("要素数" + selectData.size());

			for(int i = 0; i < selectData.size();i++){
				System.out.println("行番号：" + i);
				System.out.println("社員場号：" + selectData.get(i).getEmployeeId());
				System.out.println("社員名：" + selectData.get(i).getEmployeeName());
				System.out.println("雇用状態：" + selectData.get(i).getEmployeeStatus());
				System.out.println("管理者権限：" + selectData.get(i).getAdmin());
				System.out.println("パスワード：" + selectData.get(i).getPassword());
				System.out.println("組織番号：" + selectData.get(i).getOrgnaizationId());
				System.out.println("役職番号：" + selectData.get(i).getPostId());
				System.out.println("電話識別番号：" + selectData.get(i).getPhoneId());
				System.out.println("会社番号：" + selectData.get(i).getCompanyId());
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		/**
		// 登録情報取得
		employeeId = request.getParameter("employeeId");
		employeeName = request.getParameter("employeeName");
		employeeStatus = request.getParameter("employeeStatus");
		admin = Integer.parseInt(request.getParameter("admin"));
		orgnaizationId = Integer.parseInt(request.getParameter("organaizationId"));
		postId = Integer.parseInt(request.getParameter("postId"));
		phoneId = Integer.parseInt(request.getParameter("phoneId"));
		companyId = Integer.parseInt(request.getParameter("companyId"));

		System.out.println(employeeId);
		System.out.println(employeeName);
		System.out.println(employeeStatus);
		System.out.println(admin);
		System.out.println(orgnaizationId);
		System.out.println(postId);
		System.out.println(phoneId);
		System.out.println(companyId);

		// Bean 作成 & データセット
		EmployeeBean insertData = new EmployeeBean();

		insertData.setEmployeeId(employeeId);
		insertData.setEmployeeName(employeeName);
		insertData.setEmployeeStatus(employeeStatus);
		insertData.setAdmin(admin);
		insertData.setPassword(password);
		insertData.setOrgnaizationId(orgnaizationId);
		insertData.setPostId(postId);
		insertData.setPhoneId(phoneId);
		insertData.setCompanyId(companyId);

		// 情報登録実行
		try {
			insertResult = insertEmployeeDao.insertEmployee(insertData);
			insertEmployeeDao.commit();
		} catch (SQLException e) {	// INSERTエラー発生時実行
			try {
				insertEmployeeDao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally { // Daoクローズ
			try {
				insertEmployeeDao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		**/

	}

}

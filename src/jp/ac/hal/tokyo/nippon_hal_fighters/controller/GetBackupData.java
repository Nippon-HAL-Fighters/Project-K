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

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.BackupBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.BackupDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;

/**
 * Servlet implementation class GetBackupData
 */
@WebServlet("/GetBackupData")
public class GetBackupData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBackupData() {
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

		// DAO定義
		EmployeeDao employeeDao = new EmployeeDao();
		BackupDao backupDao = new BackupDao();

		String backPage = "./seatEdit.jsp";
		int backupId = Integer.parseInt((String) request
				.getAttribute("selectDate"));

		ArrayList<EmployeeBean> employeeData = new ArrayList<EmployeeBean>();
		ArrayList<EmployeeBean> employeeNames = new ArrayList<EmployeeBean>();
		ArrayList<BackupBean> backupData = new ArrayList<BackupBean>();

		try {
			employeeData = employeeDao.selectAllEmployees();
			backupData = backupDao.fileSelect(backupId);

			for (int i = 0; i < employeeData.size(); i++) {
				EmployeeBean employeeBean = new EmployeeBean();

				employeeBean.setEmployeeName(employeeData.get(i)
						.getEmployeeName());

				employeeNames.add(employeeBean);
				System.out.println(employeeNames.get(i).getEmployeeName());
			}

			request.setAttribute("employeeNames", employeeNames);
			request.setAttribute("backupData", backupData);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher(backPage);
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				employeeDao.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		} finally {
			try {
				employeeDao.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		request.setAttribute("employeeData", employeeData);

		RequestDispatcher dispatcher = request.getRequestDispatcher(backPage);
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

		// DAO定義
		EmployeeDao employeeDao = new EmployeeDao();
		BackupDao backupDao = new BackupDao();

		String backPage = "./seatEdit.jsp";
		int backupId = Integer.parseInt(request.getAttribute("selectId")
				.toString());
		String wArea = request.getAttribute("area").toString();
		int area = 0;

		ArrayList<EmployeeBean> employeeData = new ArrayList<EmployeeBean>();
		ArrayList<EmployeeBean> employeeNames = new ArrayList<EmployeeBean>();
		ArrayList<BackupBean> backupData = new ArrayList<BackupBean>();

		if (wArea.equals("東京")) {
			area = 0;
		} else {
			area = 1;
		}

		try {
			employeeData = employeeDao.selectAreaEmployees(area);
			backupData = backupDao.fileSelect(backupId);

			for (int i = 0; i < employeeData.size(); i++) {
				EmployeeBean employeeBean = new EmployeeBean();

				employeeBean.setEmployeeName(employeeData.get(i)
						.getEmployeeName());

				employeeNames.add(employeeBean);
				System.out.println(employeeNames.get(i).getEmployeeName());
			}

			System.out.println(backupData.get(0).getTitle());
			request.setAttribute("employeeNames", employeeNames);
			request.setAttribute("backupData", backupData);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher(backPage);
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				employeeDao.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		} finally {
			try {
				employeeDao.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}

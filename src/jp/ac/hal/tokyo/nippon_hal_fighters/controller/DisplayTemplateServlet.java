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
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.BackupDao;

/**
 * Servlet implementation class DisplayTmplateServlet
 */
@WebServlet("/DisplayTmplateServlet")
public class DisplayTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayTemplateServlet() {
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
		String change = "東京";

		if (request.getAttribute("change") != null) {
			change = request.getAttribute("change").toString();
		}

		System.out.println(request.getAttribute("change"));
		// DAO定義
		BackupDao backupDao = new BackupDao();

		String backPage = "./seatTemplateList.jsp";

		ArrayList<BackupBean> tokyoSelectData = new ArrayList<BackupBean>();
		ArrayList<BackupBean> tokyoListData = new ArrayList<BackupBean>();

		ArrayList<BackupBean> osakaSelectData = new ArrayList<BackupBean>();
		ArrayList<BackupBean> osakaListData = new ArrayList<BackupBean>();

		try {
			tokyoSelectData = backupDao.tokyoTemplateSelect();
			osakaSelectData = backupDao.osakaTemplateSelect();

			for (int i = 0; i < tokyoSelectData.size(); i++) {
				BackupBean backupBean = new BackupBean();

				backupBean.setBackupId(tokyoSelectData.get(i).getBackupId());
				backupBean.setTitle(tokyoSelectData.get(i).getTitle());
				backupBean.setResetDate(tokyoSelectData.get(i).getResetDate());
				backupBean.setImplementor(tokyoSelectData.get(i)
						.getImplementor());

				tokyoListData.add(backupBean);

			}

			for (int i = 0; i < osakaSelectData.size(); i++) {
				BackupBean backupBean = new BackupBean();

				backupBean.setBackupId(osakaSelectData.get(i).getBackupId());
				backupBean.setTitle(osakaSelectData.get(i).getTitle());
				backupBean.setResetDate(osakaSelectData.get(i).getResetDate());
				backupBean.setImplementor(osakaSelectData.get(i)
						.getImplementor());

				osakaListData.add(backupBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				backupDao.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		} finally {
			try {
				backupDao.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		request.setAttribute("change", change);
		request.setAttribute("tokyoListData", tokyoListData);
		request.setAttribute("osakaListData", osakaListData);

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

		String change = request.getAttribute("change").toString();

		BackupDao backupDao = new BackupDao();

		String backPage = "./seatTemplateList.jsp";

		ArrayList<BackupBean> tokyoSelectData = new ArrayList<BackupBean>();
		ArrayList<BackupBean> tokyoListData = new ArrayList<BackupBean>();

		ArrayList<BackupBean> osakaSelectData = new ArrayList<BackupBean>();
		ArrayList<BackupBean> osakaListData = new ArrayList<BackupBean>();

		try {
			tokyoSelectData = backupDao.tokyoSelect();
			osakaSelectData = backupDao.osakaSelect();

			for (int i = 0; i < tokyoSelectData.size(); i++) {
				BackupBean backupBean = new BackupBean();

				backupBean.setBackupId(tokyoSelectData.get(i).getBackupId());
				backupBean.setTitle(tokyoSelectData.get(i).getTitle());
				backupBean.setResetDate(tokyoSelectData.get(i).getResetDate());
				backupBean.setImplementor(tokyoSelectData.get(i)
						.getImplementor());

				tokyoListData.add(backupBean);

			}

			for (int i = 0; i < osakaSelectData.size(); i++) {
				BackupBean backupBean = new BackupBean();

				backupBean.setBackupId(osakaSelectData.get(i).getBackupId());
				backupBean.setTitle(osakaSelectData.get(i).getTitle());
				backupBean.setResetDate(osakaSelectData.get(i).getResetDate());
				backupBean.setImplementor(osakaSelectData.get(i)
						.getImplementor());

				osakaListData.add(backupBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				backupDao.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		} finally {
			try {
				backupDao.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		System.out.println(change);
		request.setAttribute("change", change);
		request.setAttribute("tokyoListData", tokyoListData);
		request.setAttribute("osakaListData", osakaListData);

		RequestDispatcher dispatcher = request.getRequestDispatcher(backPage);
		dispatcher.forward(request, response);

	}
}
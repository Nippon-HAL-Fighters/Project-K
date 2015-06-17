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
 * Servlet implementation class seatList
 */
@WebServlet("/BackupServlet")
public class BackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackupServlet() {
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
		BackupDao backupDao = new BackupDao();

		String backPage = "./seatList.html";
		int fileId = 1;

		ArrayList<BackupBean> selectData = new ArrayList<BackupBean>();
		ArrayList<BackupBean> listData = new ArrayList<BackupBean>();
		try {
			selectData = backupDao.listSelect(fileId);

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


		for (int i = 0; i < selectData.size(); i++) {
			BackupBean backupBean = new BackupBean();

			backupBean.setBackupId(selectData.get(i).getBackupId());
			backupBean.setTitle(selectData.get(i).getTitle());
			backupBean.setResetDate(selectData.get(i).getResetDate());
			backupBean.setImplementor(selectData.get(i).getImplementor());

			System.out.println(selectData.get(i).getBackupId());
			System.out.println(selectData.get(i).getTitle());
			System.out.println(selectData.get(i).getResetDate());
			System.out.println(selectData.get(i).getImplementor());

			listData.add(backupBean);

		}

		request.setAttribute("listData", listData);

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
		BackupDao backupDao = new BackupDao();

		String title = request.getParameter("cell");
		String choice = request.getParameter("choices");
		String backPage = "./seatList.html";
		int fileId = 1;

		String[] BackupId = title.split(",", 0);
		int backupId = Integer.parseInt(BackupId[1]);

		if (title != "") {
			switch (choice) {
			case "印刷":
				response.setContentType("text/html; charset=utf-8");
				response.sendRedirect(backPage);

				break;
			case "削除":
				try {
					if (backupDao.fileDelete(backupId, fileId) > 0) {
						backupDao.commit();
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

				break;

			case "編集":
				ArrayList<BackupBean> selectData = new ArrayList<BackupBean>();
				try {
					selectData = backupDao.fileSelect(backupId, fileId);

					// System.out.println(selectData.get(0).getBackupId());
					// System.out.println(selectData.get(1).getBackupFile());
					// System.out.println(selectData.get(2).getFileId());
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
				backPage = "./seatEdit.html";
				response.setContentType("text/html; charset=utf-8");
				response.sendRedirect(backPage);

				break;

			default:
				break;
			}

			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

		} else {

			// ServletContext sc = getServletContext();
			backPage = "./seatList.html";
			// sc.getRequestDispatcher(backPage).forward(request, response);

			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);
		}

	}

}

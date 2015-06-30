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

		String backPage = "./seatList.jsp";

		ArrayList<BackupBean> selectData = new ArrayList<BackupBean>();
		ArrayList<BackupBean> listData = new ArrayList<BackupBean>();

		try {
			selectData = backupDao.listSelect();

			for (int i = 0; i < selectData.size(); i++) {
				BackupBean backupBean = new BackupBean();

				backupBean.setBackupId(selectData.get(i).getBackupId());
				backupBean.setTitle(selectData.get(i).getTitle());
				backupBean.setResetDate(selectData.get(i).getResetDate());
				backupBean.setImplementor(selectData.get(i).getImplementor());

				listData.add(backupBean);

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
		String backPage = "./BackupServlet";

		String[] BackupId = title.split(",", 0);

		System.out.println(choice);

		switch (choice) {
		case "新規":
			backPage = "seatEdit.html";
			System.out.println(backPage);
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		case "印刷":
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		case "削除":
			if (title != "") {
				try {
					int backupId = Integer.parseInt(BackupId[1]);
					if (backupDao.fileDelete(backupId) > 0) {
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
			}

			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		case "編集":
			if (title != "") {
				ArrayList<BackupBean> selectData = new ArrayList<BackupBean>();
				try {
					int backupId = Integer.parseInt(BackupId[1]);
					selectData = backupDao.fileSelect(backupId);

					System.out.println(selectData.get(0).getBackupId());
					System.out.println(selectData.get(1).getBackupFile());

					request.setAttribute("selectData", selectData);
					backPage = "./seatEdit.html";

					RequestDispatcher dispatcher = request
							.getRequestDispatcher(backPage);
					dispatcher.forward(request, response);

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
			}

			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		default:
			// ServletContext sc = getServletContext();
			backPage = "./BackupServlet";
			// sc.getRequestDispatcher(backPage).forward(request, response);

			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;
		}
	}

}

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
 * Servlet implementation class BackupTemplateServlet
 */
@WebServlet("/BackupTemplateServlet")
public class BackupTemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackupTemplateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("doGET");

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
		String area = request.getParameter("area");
		String change = "東京";
		String backPage = "./DisplayTemplateServlet";

		String[] BackupId = title.split(",", 0);

		System.out.println(choice);
		System.out.println(area);

		switch (choice) {
		case "テンプレート":
			backPage = "seat_template_edit.jsp";
			System.out.println(backPage);
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		case "新規":
			backPage = "seat_template_edit.jsp";
			System.out.println(backPage);
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		case "印刷":
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;

		case "削除":
			switch (area) {

			case "東京":

				if (title != "") {
					try {
						int backupId = Integer.parseInt(BackupId[1]);
						if (backupDao.fileDelete(backupId, 0) > 0) {
							change = "東京";
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

			case "大阪":

				if (title != "") {
					try {
						int backupId = Integer.parseInt(BackupId[1]);
						if (backupDao.fileDelete(backupId, 1) > 0) {
							change = "大阪";
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
			}
			System.out.println(change);
			request.setAttribute("change", change);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(backPage);
			dispatcher.forward(request, response);

			break;

		case "編集":
			if (title != "") {
				ArrayList<BackupBean> selectData = new ArrayList<BackupBean>();
				try {
					int backupId = Integer.parseInt(BackupId[1]);
					selectData = backupDao.fileSelect(backupId);
					//int selectId = selectData.get(0).getBackupId();

					//System.out.println(selectId);
					// バックアップファイルは表示できない
					// System.out.println(selectData.get(1).getBackupFile());

					//request.setAttribute("area", area);
					//request.setAttribute("selectId", selectId);
					backPage = "seat_template_edit.jsp";

					RequestDispatcher dispatcher2 = request
							.getRequestDispatcher(backPage);
					dispatcher2.forward(request, response);

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

			break;

		default:
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(backPage);

			break;
		}
	}
}

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
 * Servlet implementation class SeatPlacementServlet
 */
@WebServlet("/SeatPlacementServlet")
public class SeatPlacementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatPlacementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BackupDao backupDao = new BackupDao();
		ArrayList<BackupBean> backupData = new ArrayList<BackupBean>();
		String url  = "./seat_placement.jsp";
		int backupId = 1;

		try {
			backupData = backupDao.fileSelect(backupId);

			request.setAttribute("backupData", backupData);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.BackupBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.BackupDao;

/**
 * Servlet implementation class SeatTemplate
 */
@WebServlet("/SeatTemplate")
public class SeatTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeatTemplate() {
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
		BackupDao backupDao = new BackupDao();
		BackupBean backupBean = new BackupBean();

		// jointjs_seat_template からバックアップ情報の受取り
		BufferedReader bufferReader = new BufferedReader(request.getReader());
		String buckupString = bufferReader.readLine();

		System.out.println(buckupString); // バックアップ情報の表示用

		backupBean.setBackupFile(buckupString);
		backupBean.setTitle("aaa");
		backupBean.setResetDate("2015-01-01");
		backupBean.setImplementor("ueno");
		backupBean.setCompanyPlace("1");

		try {
			int success = backupDao.insertBuckup(backupBean);

			if (success == 1) {
				backupDao.commit();
			} else {
				backupDao.rollback();
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 座席表テンプレート保存処理などを行うサーブレット
 *
 * @author s.kato
 */
@WebServlet("/SeatTemplate")
public class SeatTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatTemplate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BackupDao backupDao = new BackupDao();
		//BackupBean backupBean = new BackupBean();

		BufferedReader bufferReader = new BufferedReader(request.getReader());
		String buckupString = bufferReader.readLine();

		String value = request.getParameter("name");

		System.out.println(value);

//		System.out.println(buckupString);





	}

}

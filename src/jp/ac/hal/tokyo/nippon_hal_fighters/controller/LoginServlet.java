package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン済みの場合は400エラー
		if (UserUtil.isLogin(request)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String employeeId = request.getParameter("employee_id");
		String passwd     = request.getParameter("password");

		// 入力チェック
		if (employeeId == null || passwd == null || employeeId.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("errorMsg", "従業員番号とパスワードを入力してください");
			request.getRequestDispatcher("login.jsp").forward(request, response);

			return;
		}

		// EmployeeID と Passwordが一致するユーザを検索
		String findEmployee = "SELECT COUNT(employee_id), admin FROM employees WHERE employee_id = ? AND password = ?";
		int empCount = 0;
		boolean isAdmin = false;

		DBConnecter dbConn = new DBConnecter();

		try {
			Connection conn = dbConn.getConnection();

			PreparedStatement state = conn.prepareStatement(findEmployee);

			state.setString(1, employeeId);
			state.setString(2, passwd);

			ResultSet result = state.executeQuery();

			result.first();

			empCount = result.getInt(1);

			if (result.getInt(2) == 1) {
				isAdmin = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("errorMsg", "サーバーでエラーが起きました");
			request.getRequestDispatcher("login.jsp").forward(request, response);

			return;
		}

		if (empCount != 1) {
			//ログイン失敗処理
			request.setAttribute("errorMsg", "従業員番号とパスワードが一致しません");
			request.getRequestDispatcher("login.jsp").forward(request, response);

			return;
		} else {
			// ログイン成功処理
			HttpSession session = request.getSession();

			session.setAttribute("employee_id", employeeId);
			session.setAttribute("isAdmin", isAdmin);

			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();

			out.println("ログイン成功");
			out.println("Employee ID: " + (String) session.getAttribute("employee_id"));
			out.println("isAdmin: " + (boolean) session.getAttribute("isAdmin"));
		}
	}

}

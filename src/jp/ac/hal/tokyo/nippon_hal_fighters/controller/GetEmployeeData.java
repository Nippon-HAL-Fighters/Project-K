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

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;

/**
 * Servlet implementation class GetEmployeeData
 */
@WebServlet("/GetEmployeeData")
public class GetEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		/**
		 *	DBから一覧データを取得？
		 **/
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		ArrayList<EmployeeBean> getData = new ArrayList<EmployeeBean>();
		
		try {
			getData = employeeDao.selectListAllEmployees();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			try {
				employeeDao.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		request.setAttribute("recode", getData);
		//データを取得してから一覧へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList_new.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

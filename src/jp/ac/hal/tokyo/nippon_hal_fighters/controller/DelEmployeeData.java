package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class DelEmployeeData
 */
@WebServlet("/DelEmployeeData")
public class DelEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelEmployeeData() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		DBConnecter connecter = new DBConnecter();
		Connection con = null;
		EmployeeBean deleteempBean = new EmployeeBean();
		PhoneBean delphoneBean = new PhoneBean();
		
		String employeeId = request.getParameter("delempid");
		int phoneid = Integer.parseInt(request.getParameter("delphoneid"));
		deleteempBean.setEmployeeId(employeeId);
		delphoneBean.setPhoneId(phoneid);
		
		try {
			con = connecter.getConnection();
			EmployeeDao employeeDao = new EmployeeDao(con);
			PhoneDao phoneDao = new PhoneDao(con);		
			phoneDao.deletephone(delphoneBean);	
			employeeDao.deleteEmployee(deleteempBean);		
			employeeDao.commit();
			phoneDao.commit();
			System.out.print("OK!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		//データを削除したら一覧へ遷移する。
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
		dispatcher.forward(request, response);
	}

}

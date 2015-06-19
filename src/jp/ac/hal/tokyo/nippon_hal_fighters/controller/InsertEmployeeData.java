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
 * Servlet implementation class InsertEmployeeData
 */
@WebServlet("/InsertEmployeeData")
public class InsertEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmployeeData() {
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
		Connection con = connecter.getConnection();
		EmployeeBean insertBean = new EmployeeBean();
		PhoneBean phoneBean = new PhoneBean();
		EmployeeDao employeeDao = new EmployeeDao(con);
		PhoneDao phoneDao = new PhoneDao(con);
		
		String employeeId = request.getParameter("employeeid");
		String employeeName = request.getParameter("employeename"); 
		String koyo = request.getParameter("koyo");
		int admin = Integer.parseInt(request.getParameter("admin"));
		String password = request.getParameter("pass");
		int posts = Integer.parseInt(request.getParameter("posts"));
		int org = Integer.parseInt(request.getParameter("org"));
		int comp = Integer.parseInt(request.getParameter("comp"));
		String phoneinside = request.getParameter("phoneinside");
		String phoneout = request.getParameter("phoneout");	
		int phoneId;
		
		try {
			phoneId = phoneDao.datacount();
			
			insertBean.setEmployeeId(employeeId);
			insertBean.setEmployeeName(employeeName);
			insertBean.setEmployeeStatus(koyo);
			insertBean.setAdmin(admin);
			insertBean.setPassword(password);
			insertBean.setPostId(posts);
			insertBean.setOrgnaizationId(org);
			insertBean.setPhoneId(phoneId);
			insertBean.setPhoneInside(phoneinside);
			insertBean.setPhoneOutside(phoneout);
			insertBean.setCompanyId(comp);
			phoneBean.setPhoneId(phoneId);
			phoneBean.setPhoneInside(phoneinside);
			phoneBean.setPhoneOutside(phoneout);
			
			employeeDao.insertEmployee(insertBean);
			phoneDao.insertPhone(phoneBean);			
			employeeDao.commit();
			phoneDao.commit();
			System.out.print("OK!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		//データを登録したら一覧へ遷移する。
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
		dispatcher.forward(request, response);
	}

}

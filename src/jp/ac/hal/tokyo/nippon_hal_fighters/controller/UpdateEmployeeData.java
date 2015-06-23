package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaiationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanieDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class UpdateEmployeeData
 */
@WebServlet("/UpdateEmployeeData")
public class UpdateEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeData() {
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
		EmployeeBean updateBean = new EmployeeBean();
		PhoneBean phoneBean = new PhoneBean();
		EmployeeDao employeeDao = new EmployeeDao(con);
		PhoneDao phoneDao = new PhoneDao(con);
		
		String employeeId = request.getParameter("employeeid");
		String employeeName = request.getParameter("employeename"); 
		String koyo = request.getParameter("koyo");
		int admin = Integer.parseInt(request.getParameter("admin"));
		String password = request.getParameter("pass");
		int posts = Integer.parseInt(request.getParameter("posts"));
		String org = request.getParameter("org");
		int comp = Integer.parseInt(request.getParameter("comp"));
		String phoneinside = request.getParameter("phoneinside");
		String phoneout = request.getParameter("phoneout");	
		int phoneId;
		
		try {
			phoneId = phoneDao.datacount();
			
			updateBean.setEmployeeId(employeeId);
			updateBean.setEmployeeName(employeeName);
			updateBean.setEmployeeStatus(koyo);
			updateBean.setAdmin(admin);
			updateBean.setPassword(password);
			updateBean.setPostId(posts);
			updateBean.setOrgnaizationId(org);
			updateBean.setPhoneId(phoneId);
			updateBean.setPhoneInside(phoneinside);
			updateBean.setPhoneOutside(phoneout);
			updateBean.setCompanyId(comp);
			phoneBean.setPhoneId(phoneId);
			phoneBean.setPhoneInside(phoneinside);
			phoneBean.setPhoneOutside(phoneout);
			
			employeeDao.updateEmployee(updateBean);
			phoneDao.upodatePhone(phoneBean);			
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
		
		//データを更新したら一覧へ遷移する。
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeList.jsp");
		dispatcher.forward(request, response);
	}

}

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
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanyDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class SendConfirmationUpdateEmployee
 */
@WebServlet("/SendConfirmationUpdateEmployee")
public class SendConfirmationUpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendConfirmationUpdateEmployee() {
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
		CompanyDao compDao = new CompanyDao(con);
		OrganaizationDao orgDao = new OrganaizationDao(con);
		PostDao postDao = new PostDao(con);
		EmployeeBean empBean = new EmployeeBean();
		
		//入力データの受け取り
		String employeeId = request.getParameter("employeeid");
		String employeeName = request.getParameter("employeename");
		String ordemployeeId = request.getParameter("ordempid");
		String password = request.getParameter("password");
		String koyo = request.getParameter("koyo");
		int admin = Integer.parseInt(request.getParameter("admin"));
		int posts = Integer.parseInt(request.getParameter("posts"));
		String org = request.getParameter("org");
		int comp = Integer.parseInt(request.getParameter("comp"));
		String phoneinside = request.getParameter("phoneinside");
		String phoneout = request.getParameter("phoneout");
		String postName = null;			//役職名
		String orgName = null;			//組織名
		String compName = null;			//会社名
		int phoneid = Integer.parseInt(request.getParameter("phoneid"));
				
		try {
			compName = compDao.compname(comp);		//協力会社名取得
			orgName = orgDao.selectOrgName(org);	//組織
			postName = postDao.selectPostName(posts);		//ポスト名
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
		
		empBean.setEmployeeId(employeeId);
		empBean.setEmployeeName(employeeName);
		empBean.setPassword(password);
		empBean.setEmployeeStatus(koyo);
		empBean.setAdmin(admin);
		empBean.setPostId(posts);
		empBean.setPostName(postName);
		empBean.setOrgnaizationId(org);
		empBean.setOrgnaizationName(orgName);
		empBean.setCompanyId(comp);
		empBean.setCompanayName(compName);
		empBean.setPhoneId(phoneid);
		empBean.setPhoneInside(phoneinside);
		empBean.setPhoneOutside(phoneout);
	
		//遷移する
		request.setAttribute("emprecode", empBean);
		request.setAttribute("ordemp", ordemployeeId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmationUpdateEnployee.jsp");
		dispatcher.forward(request, response);
	}

}

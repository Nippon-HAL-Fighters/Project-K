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
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanieDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class UpdateEmployeeData
 */
@WebServlet("/SendUpdateEmployeeData")
public class SendUpdateEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendUpdateEmployeeData() {
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
		request.setCharacterEncoding("utf-8");

		String updateEmpId = request.getParameter("updateempid");
		DBConnecter connecter = null;
		Connection con = null;
		EmployeeDao empDao = null;
		PostDao postDao = null;
		OrganaizationDao orgDao = null;
		CompanieDao compDao = null;
		ArrayList<PostBean> getPost = new ArrayList<PostBean>();
		ArrayList<OrganaizationBean> getOrg = new ArrayList<OrganaizationBean>();
		ArrayList<CompanieBean> getComp = new ArrayList<CompanieBean>();	
		EmployeeBean getData = new EmployeeBean();
		String admin = null;
		
		
		try {
			connecter = new DBConnecter();
			con = connecter.getConnection();
			empDao = new EmployeeDao(con);
			postDao = new PostDao(con);
			orgDao = new OrganaizationDao(con);
			compDao = new CompanieDao(con);
			getPost = postDao.selectAllPosts();
			getOrg = orgDao.selectAllOrganaiation();	
			getComp = compDao.selectAllCompanie();
			getData = empDao.selectListEmployees(updateEmpId);
			admin = String.valueOf(getData.getAdmin());
			System.out.println(getData.getAdmin());
						
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			try {
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		//データを取得してから一覧へ遷移
		request.setAttribute("empData", getData);
		request.setAttribute("postlist", getPost);
		request.setAttribute("orglist", getOrg);
		request.setAttribute("complist", getComp);
		request.setAttribute("admin", admin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeUpdate.jsp");
		dispatcher.forward(request, response);
	}

}

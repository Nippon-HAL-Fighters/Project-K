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

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class InsertOrganaizationServlet
 */
@WebServlet("/InsertOrganaizationServlet")
public class InsertOrganaizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrganaizationServlet() {
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
		
		DBConnecter connecter = new DBConnecter();
		Connection con = connecter.getConnection();
		OrganaizationDao organaizationDao = new OrganaizationDao(con);
		OrganaizationBean insertBean = new OrganaizationBean();
		
		String OrganaizationId = request.getParameter("organaizationid");
		String OrganaizationName = request.getParameter("organaizationname");
		
		
		try{
			insertBean.setOrganaizationId(OrganaizationId);
			insertBean.setOrganaizationName(OrganaizationName);
			
			organaizationDao.insertOrganaiation(insertBean);
			organaizationDao.commit();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try {
				organaizationDao.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		//データを取得してから社員情報登録へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("master.jsp");
		dispatcher.forward(request, response);	
	}

}

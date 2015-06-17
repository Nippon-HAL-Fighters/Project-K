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
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaiationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanieDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class GetEntryData
 */
@WebServlet("/GetEntryData")
public class GetEntryData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEntryData() {
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
		PostDao postDao = new PostDao(con);
		OrganaizationDao orgDao = new OrganaizationDao(con);
		CompanieDao compDao = new CompanieDao(con);
		ArrayList<PostBean> getPost = new ArrayList<PostBean>();
		ArrayList<OrganaiationBean> getOrg = new ArrayList<OrganaiationBean>();
		ArrayList<CompanieBean> getComp = new ArrayList<CompanieBean>();	
		
		try{
			getPost = postDao.selectAllPosts();
			getOrg = orgDao.selectAllOrganaiation();	
			getComp = compDao.selectAllCompanie();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try {
				//postDao.close();
				//orgDao.close();
				//compDao.close();
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		
		request.setAttribute("postlist", getPost);
		request.setAttribute("orglist", getOrg);
		request.setAttribute("complist", getComp);
		//データを取得してから社員情報登録へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeEntry.jsp");
		dispatcher.forward(request, response);
	}

}

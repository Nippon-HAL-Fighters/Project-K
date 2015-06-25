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
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanieDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class DelMaster
 */
@WebServlet("/DelMaster")
public class DelMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMaster() {
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
		
		//DB接続
		DBConnecter connecter = new DBConnecter();
		Connection con = connecter.getConnection();
		OrganaizationBean orgBean = null;
		OrganaizationDao orgDao = null;
		PostBean postBean = null;
		PostDao postDao = null;
		CompanieBean compBean = null;
		CompanieDao compDao= null;
		
		ArrayList<OrganaizationBean> orgList = new ArrayList<OrganaizationBean>();
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		ArrayList<CompanieBean> compList = new ArrayList<CompanieBean>();
		
		int nextnum = 0;
		//switch文の判定条件
		String deltype = request.getParameter("Deltype");
		RequestDispatcher dispatcher = null;
		
		switch (deltype) {
		case "org":		//組織の場合
			String delorgid = request.getParameter("OrganaizationID");			
			nextnum = 1;
			try {
				orgBean = new OrganaizationBean();
				orgBean.setOrganaizationId(delorgid);
				orgDao = new OrganaizationDao(con);
				
				orgDao.deleteOrg(orgBean);					//削除
				orgDao.commit();							//コミット
				orgList = orgDao.selectAllOrganaiation();	//一覧の取得
				
			} catch (Exception e) {
				// TODO: handle exception
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
			
			request.setAttribute("recode", orgList);
			request.setAttribute("num", nextnum);
			dispatcher = request.getRequestDispatcher("master.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "post":		//役職削除の場合
			int postid = Integer.parseInt(request.getParameter("PostID"));			
			nextnum = 2;
			try {
				postBean = new PostBean();
				postBean.setPostId(postid);
				postDao = new PostDao(con);
				
				postDao.deletePost(postBean);
				postDao.commit();
				postList = postDao.selectAllPosts();
			} catch (Exception e) {
				// TODO: handle exception
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
			
			request.setAttribute("recode", postList);
			request.setAttribute("num", nextnum);
			dispatcher = request.getRequestDispatcher("master.jsp");
			dispatcher.forward(request, response);
			break;

		case "comp":		//役職削除の場合
			int compid = Integer.parseInt(request.getParameter("CompanyID"));			
			nextnum = 3;
			try {
				compBean = new CompanieBean();
				compBean.setCompanyId(compid);
				compDao = new CompanieDao(con);
				
				compDao.deletePost(compBean);
				compDao.commit();
				compList = compDao.selectAllCompanie();
			} catch (Exception e) {
				// TODO: handle exception
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
			
			request.setAttribute("recode", compList);
			request.setAttribute("num", nextnum);
			dispatcher = request.getRequestDispatcher("master.jsp");
			dispatcher.forward(request, response);
			break;			
		}
	}
}

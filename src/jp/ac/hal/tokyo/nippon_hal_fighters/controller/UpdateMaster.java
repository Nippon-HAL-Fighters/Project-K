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

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanieDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class UpdateMaster
 */
@WebServlet("/UpdateMaster")
public class UpdateMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMaster() {
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
		
		String updatetype=request.getParameter("updatetype");
		DBConnecter connecter = new DBConnecter();
		Connection con = null;
		OrganaizationBean orgBean = null;
		OrganaizationDao orgDao = null;
		PostBean postBean = null;
		PostDao postDao = null;
		CompanieBean compBean = null;
		CompanieDao compDao = null;
		RequestDispatcher dispatcher = null;
		
		switch (updatetype) {
		case "org":
			try {
				String orgid = request.getParameter("orgid");
				String orgname = request.getParameter("orgname");
				String ordid = request.getParameter("ordid"); 
				con = connecter.getConnection();		//コネクションの取得
				orgBean = new OrganaizationBean();
				orgDao = new OrganaizationDao(con);
				orgBean.setOrganaizationId(orgid);
				orgBean.setOrganaizationName(orgname);
				orgDao.updateOrganaiation(orgBean,ordid);
				orgDao.commit();
				dispatcher = request.getRequestDispatcher("GetOrganizationServlet");
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
			dispatcher.forward(request, response);
			break;
			
		case "post":
			try {
				int postid = Integer.parseInt(request.getParameter("postid"));
				String postname = request.getParameter("postname");
				con = connecter.getConnection();		//コネクションの取得
				postBean = new PostBean();
				postDao = new PostDao(con);
				postBean.setPostId(postid);
				postBean.setPostName(postname);
				postDao.updatepost(postBean);
				postDao.commit();
				dispatcher = request.getRequestDispatcher("GetPostsServlet");
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
			dispatcher.forward(request, response);
			break;

		case "comp":
			try {
				int compid = Integer.parseInt(request.getParameter("compid"));
				String compname = request.getParameter("compname");
				con = connecter.getConnection();		//コネクションの取得
				compBean = new CompanieBean();
				compBean.setCompanyId(compid);
				compBean.setCompanyName(compname);
				compDao = new CompanieDao(con);
				compDao.updatecomp(compBean);
				compDao.commit();				
				dispatcher = request.getRequestDispatcher("GetCompanyServlet");
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
			dispatcher.forward(request, response);
			break;
		}
	}

}

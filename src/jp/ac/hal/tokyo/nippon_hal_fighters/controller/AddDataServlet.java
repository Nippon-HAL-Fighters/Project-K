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
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.CompanyDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrganaizationDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PhoneDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.PostDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Servlet implementation class AddDataServlet
 */
@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataServlet() {
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
		
		DBConnecter connecter = new DBConnecter();
		Connection con = connecter.getConnection();
		
		String addData="";

		// OrganaizationDaoインスタンス化
		OrganaizationDao organaizationDao = new OrganaizationDao(con);
		ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();

		// PostDaoインスタンス化
		PostDao postDao = new PostDao(con);
		PostBean postrecode = new PostBean();
		ArrayList<PostBean> postList = new ArrayList<PostBean>();
		//phoneid
		int postId;

		// PhoneDaoインスタンス化
		PhoneDao phoneDao = new PhoneDao(con);
		PhoneBean phonerecode = new PhoneBean();
		// 内線番号用リスト
		ArrayList<PhoneBean> phoneInsideList = new ArrayList<PhoneBean>();
		// 外線番号用リスト
		ArrayList<PhoneBean> phoneOutsideList = new ArrayList<PhoneBean>();
		//phoneId
		int phoneId;

		// CompanyDaoインスタンス化
		CompanyDao companyDao = new CompanyDao(con);
		ArrayList<CompanieBean> companyList = new ArrayList<CompanieBean>();

		// 判別用の数字
		int num;

		String keyword = request.getParameter("category");
		int hanbetu = Integer.parseInt(request.getParameter("addtype"));
		System.out.print(hanbetu);
		//System.out.print(keyword);

		switch (hanbetu) {
		// 組織の場合ここから
		case 1:
			num = 1;
			try {
				organaizationList = organaizationDao.selectAllOrganaiation();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			System.out.print(num);
			request.setAttribute("recode", organaizationList);
			// request.setAttribute("orglist", orglist);
			break;

		// 役職の場合ここから
		case 2:
			num = 2;
			try{
				addData=request.getParameter("addtext");
				System.out.println("add:"+addData);				
				postId = postDao.datacount();
				postId = postId + 1;
				postrecode.setPostName(addData);
				postrecode.setPostId(postId);
				
				postDao.insertPost(postrecode);
				postDao.commit();
				//System.out.print("OK!");
				
				postList = postDao.selectAllPosts();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", 2);
			request.setAttribute("recode", postList);
			RequestDispatcher disp = request.getRequestDispatcher("master.jsp");
			disp.forward(request, response);
			break;

		// 内線電話の場合ここから
		case 3:
			num = 3;
			try {
				addData=request.getParameter("addtext");
				System.out.println("add:"+addData);				
				postId = postDao.datacount();
				postId = postId + 1;
				postrecode.setPostName(addData);
				postrecode.setPostId(postId);
				
				postDao.insertPost(postrecode);
				postDao.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			request.setAttribute("recode", phoneInsideList);
			break;

		// 外線電話の場合ここから
		case 4:
			num = 4;
			try {
				phoneOutsideList = phoneDao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			request.setAttribute("recode", phoneOutsideList);
			break;

		// 会社の場合ここから
		case 5:
			num = 5;
			try {
				companyList = companyDao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block e.printStackTrace(); }
				// finally {
				try {
					con.close();
				} catch (SQLException e1) { // TODO Auto-generated
					e1.printStackTrace();
				}
			}
			request.setAttribute("num", num);
			request.setAttribute("recode", companyList);
			break;
		}// switch　終了
		/*RequestDispatcher disp = request.getRequestDispatcher("master.jsp");
		disp.forward(request, response);*/
		
	}

}

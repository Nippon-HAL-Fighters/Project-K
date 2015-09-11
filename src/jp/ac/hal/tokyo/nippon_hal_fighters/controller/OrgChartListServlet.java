package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrgChartBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.EmployeeDao;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrgChartDao;

/**
 * Servlet implementation class OrgChartListServlet
 */
@WebServlet("/OrgChartListServlet")
public class OrgChartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrgChartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrgChartDao ocd = new OrgChartDao();

		try {
			ArrayList<OrgChartBean> orgCharts = ocd.findAll();

			HashMap<String, String> empNameMap = new HashMap<String, String>();

			for (OrgChartBean ocb : orgCharts) {
				String empName = this.getEmployeeName(ocb.getEmployeeID());
				empNameMap.put(ocb.getEmployeeID(), empName);
			}

			request.setAttribute("orgCharts", orgCharts);
			request.setAttribute("empNameMap", empNameMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("./org_chart_list.jsp").forward(request, response);
	}

	private String getEmployeeName(String employeeID) throws SQLException {
		EmployeeDao ed = new EmployeeDao();
		EmployeeBean eb = ed.selectListEmployees(employeeID);
		ed.close();

		return eb.getEmployeeName();
	}

}

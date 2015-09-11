package jp.ac.hal.tokyo.nippon_hal_fighters.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrgChartBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.dao.OrgChartDao;

import com.google.gson.Gson;

/**
 * Servlet implementation class OrgChartController
 */
@WebServlet("/OrgChartServlet/*")
public class OrgChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrgChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reqOrgChartID = Integer.parseInt(request.getPathInfo().replaceAll("/", ""));

		OrgChartDao ocd = new OrgChartDao();
		OrgChartBean ocb = new OrgChartBean();
		try {
			ocb = ocd.find(reqOrgChartID);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();
		out.println(ocb.getGraph());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		BufferedReader bufferReaderBody = new BufferedReader(request.getReader());
		String body = bufferReaderBody.readLine();

		OrgChartBean ocb = new OrgChartBean();

		HttpSession session = request.getSession();

		ocb.setEmployeeID((String) session.getAttribute("employee_id"));
		ocb.setGraph(body);
		ocb.setLastModify(new Date());

		OrgChartDao ocd = new OrgChartDao();

		try {
			ocb.setTitle(ocd.getTitleFromJson(body));
			ocb.setOrgChartID(ocd.save(ocb));
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		Gson gson = new Gson();
		out.print(gson.toJson(ocb));
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		BufferedReader bufferReaderBody = new BufferedReader(request.getReader());
		String body = bufferReaderBody.readLine();

		OrgChartDao ocd = new OrgChartDao();

		int orgChartID = ocd.getOrgChartIDFromJson(body);

		String title = ocd.getTitleFromJson(body);

		OrgChartBean ocb = new OrgChartBean();
		ocb.setOrgChartID(orgChartID);
		ocb.setGraph(body);
		ocb.setLastModify(new Date());
		ocb.setTitle(title);

		HttpSession session = request.getSession();

		ocb.setEmployeeID((String) session.getAttribute("employee_id"));

		try {
			ocd.update(ocb);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		out.println(gson.toJson(ocb));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orgChartID = Integer.valueOf(req.getParameter("org_chart_id"));

		OrgChartDao ocd = new OrgChartDao();

		try {
			ocd.delete(orgChartID);
		} catch (Exception e) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	}

}

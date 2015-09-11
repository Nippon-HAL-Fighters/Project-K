package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrgChartBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

import com.google.gson.Gson;

/**
 * org_chartsテーブルにアクセスするためのオブジェクト
 *
 * @author 近藤
 *
 */
public class OrgChartDao {

	/**
	 * org_chartsテーブルのレコードを全て取得する
	 *
	 * @return OrgChartBeanが入ったArrayList
	 * @throws Exception
	 */
	public ArrayList<OrgChartBean> findAll() throws Exception {
		DBConnecter dbConn = new DBConnecter();
		Connection conn = dbConn.getConnection();

		String selectAll = "SELECT org_chart_id, graph, title, last_mod, employee_id FROM org_charts";

		PreparedStatement state = conn.prepareStatement(selectAll);

		ResultSet result = state.executeQuery();

		ArrayList<OrgChartBean> orgChartList = new ArrayList<OrgChartBean>();

		while (result.next()) {
			OrgChartBean ocb = new OrgChartBean();

			ocb.setOrgChartID(result.getInt("org_chart_id"));
			ocb.setEmployeeID(result.getString("employee_id"));
			ocb.setGraph(result.getString("graph"));
			ocb.setTitle(result.getString("title"));
			ocb.setLastModify(result.getDate("last_mod"));
			ocb.setEmployeeID(result.getString("employee_id"));

			orgChartList.add(ocb);
		}

		conn.close();

		return orgChartList;
	}

	/**
	 * org_chartsテーブルから引数で渡されたorgChartIdに一致するレコードを返す
	 *
	 * @param ocb 取得したいレコードのorg_chart_id
	 * @return 一致するレコードがなかった場合はnull
	 * @throws Exception
	 */
	public OrgChartBean find(int orgChartId) throws Exception {
		DBConnecter dbConn = new DBConnecter();
		Connection conn = dbConn.getConnection();

		String selectOne = "SELECT org_chart_id, graph, title, last_mod, employee_id FROM org_charts WHERE org_chart_id = ?";

		PreparedStatement state = conn.prepareStatement(selectOne);

		state.setInt(1, orgChartId);

		ResultSet result = state.executeQuery();

		if (!result.first()) {
			return null;
		}

		Date parsedDate = this.parseDate(result.getString("last_mod"));

		OrgChartBean selectedOcb = new OrgChartBean();

		selectedOcb.setOrgChartID(result.getInt("org_chart_id"));
		selectedOcb.setGraph(result.getString("graph"));
		selectedOcb.setTitle(result.getString("title"));
		selectedOcb.setLastModify(parsedDate);
		selectedOcb.setEmployeeID(result.getString("employee_id"));

		conn.close();

		return selectedOcb;
	}

	/**
	 * 引数に渡されたOrgChartBeanの内容でレコードを挿入します
	 *
	 * @param ocb orgChartIdはSETしなくてOK
	 * @return INSERTに失敗した場合は0、成功の場合は挿入されたレコードのorg_chart_idを返す
	 * @throws Exception
	 */
	public int save(OrgChartBean ocb) throws Exception {
		DBConnecter dbConn = new DBConnecter();
		Connection conn = dbConn.getConnection();

		String insert = "INSERT INTO org_charts (graph, title, last_mod, employee_id) VALUES (?, ?, ?, ?)";

		String lastModStr = this.formatDate(ocb.getLastModify());

		PreparedStatement state = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

		state.setString(1, ocb.getGraph());
		state.setString(2, ocb.getTitle());
		state.setString(3, lastModStr);
		state.setString(4, ocb.getEmployeeID());

		state.executeUpdate();

		ResultSet genKeys = state.getGeneratedKeys();

		int ret = 0;

		if (genKeys.next()) {
			ret = genKeys.getInt(1);
		}

		conn.commit();
		conn.close();

		return ret;
	}

	/**
	 * 引数で渡されたOrgChartBeanのorgChartIdに一致するレコードを更新します
	 *
	 * @param ocb 更新したいOrgChartBean
	 * @return 更新に成功した場合はtrue、失敗した場合はfalse
	 * @throws Exception
	 */
	public boolean update(OrgChartBean ocb) throws Exception {
		DBConnecter dbConn = new DBConnecter();
		Connection conn = dbConn.getConnection();

		String updateSql = "UPDATE org_charts SET graph = ?, title = ?, last_mod = ?, employee_id = ? WHERE org_chart_id = ?";

		PreparedStatement state = conn.prepareStatement(updateSql);

		String lastModStr = this.formatDate(ocb.getLastModify());

		state.setString(1, ocb.getGraph());
		state.setString(2, ocb.getTitle());
		state.setString(3, lastModStr);
		state.setString(4, ocb.getEmployeeID());
		state.setInt(5, ocb.getOrgChartID());

		if (state.executeUpdate() != 1) {
			conn.rollback();
			conn.close();
			return false;
		}

		conn.commit();
		conn.close();

		return true;
	}

	/**
	 * 引数のIDと一致するレコードを削除します
	 *
	 * @param orgChartId
	 * @return 削除に成功した場合はtrue、削除に失敗した場合はfalse
	 * @throws Exception
	 */
	public boolean delete(int orgChartId) throws Exception {
		DBConnecter dbConn = new DBConnecter();
		Connection conn = dbConn.getConnection();

		String deleteSql = "DELETE FROM org_charts WHERE org_chart_id = ?";

		PreparedStatement state = conn.prepareStatement(deleteSql);

		state.setInt(1, orgChartId);

		if (state.executeUpdate() != 1) {
			conn.rollback();
			conn.close();
			return false;
		}

		conn.commit();
		conn.close();

		return true;
	}

	public String getTitleFromJson(String jsonStr) {
		Gson gson = new Gson();

		OrgChartBean ocb = gson.fromJson(jsonStr, OrgChartBean.class);

		return ocb.getTitle();
	}

	public int getOrgChartIDFromJson(String jsonStr) {
		Gson gson = new Gson();

		OrgChartBean ocb = gson.fromJson(jsonStr, OrgChartBean.class);

		return ocb.getOrgChartID();
	}

	private String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		return format.format(date);
	}

	private Date parseDate(String dateStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		return format.parse(dateStr);
	}

}

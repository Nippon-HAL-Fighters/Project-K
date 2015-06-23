package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

public class OrganaizationDao {
	
	Connection con = null;
	
	/**
	 * コンストラクタ
	 * @param Connection
	 **/
	public OrganaizationDao (Connection con) {
		this.con = con;
	}

	/**
	 * コンストラクタ
	 **/
	public OrganaizationDao() {
		if(con == null){
			DBConnecter db = new DBConnecter();
			con = db.getConnection();
		}
	}
	
		
	/**
	 * 全件取得
	 *
	 * @return ArrayList OrganazationList
	 * @throws SQLException
	 */
	public ArrayList<OrganaizationBean> selectAllOrganaiation() throws SQLException {
		String selectSQL = "SELECT organaization_id,organaization_name FROM organaizations";

		PreparedStatement select = con.prepareStatement(selectSQL);

		ResultSet selectResult = select.executeQuery();

		ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
		while (selectResult.next()) {
			//EmployeeBean employeeBean = new EmployeeBean();
			OrganaizationBean organaiationBean = new OrganaizationBean();
			organaiationBean.setOrganaizationId(selectResult.getString("organaization_id"));
			organaiationBean.setOrganaizationName(selectResult.getString("organaization_name"));	
			organaizationList.add(organaiationBean);
		}
		return organaizationList;
	}
		
	
	/**
	 * コミット
	 * @throws SQLException 
	 **/
	public void commit() throws SQLException {
		con.commit();
	}

	/**
	 * ロールバック
	 * @throws SQLException 
	 **/
	public void rollback() throws SQLException {
		con.rollback();
	}

	/**
	 * クローズ
	 * @throws SQLException 
	 **/
	public void close() throws SQLException {
		con.close();
	}
}

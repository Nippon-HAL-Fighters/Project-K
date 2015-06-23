package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

public class OrganaizationDao {

	Connection con = null;

	/**
	 * コンストラクタ
	 * 
	 * @param Connection
	 **/
	public OrganaizationDao(Connection con) {
		this.con = con;
	}

	/**
	 * コンストラクタ
	 **/
	public OrganaizationDao() {
		if (con == null) {
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
	public ArrayList<OrganaizationBean> selectAllOrganaiation()
			throws SQLException {
		String SelectSQL = "SELECT organaization_id,organaization_name FROM organaizations";

		PreparedStatement select = con.prepareStatement(SelectSQL);

		ResultSet selectResult = select.executeQuery();

		ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
		while (selectResult.next()) {
			OrganaizationBean organaiationBean = new OrganaizationBean();
			organaiationBean.setOrganaizationId(selectResult
					.getString("organaization_id"));
			organaiationBean.setOrganaizationName(selectResult
					.getString("organaization_name"));
			organaizationList.add(organaiationBean);
		}
		return organaizationList;
	}

	/**
	 * 組織情報を登録するためのメソッド
	 * 
	 * @param organaiationBean
	 * @return
	 * @throws SQLException
	 */
	public int insertOrganaiation(OrganaizationBean organaiationBean) throws SQLException {

		String InsertSQL = "INSERT INTO organaizations VALUES(?,?)";
		PreparedStatement prst = con.prepareStatement(InsertSQL);
		prst.setString(1, organaiationBean.getOrganaizationId());
		prst.setString(2, organaiationBean.getOrganaizationName());
		return prst.executeUpdate();
	}
	
	/*
	public ArrayList<OrganaizationBean> ChaneOrganaizations() throws SQLException {
		String hanbetu = Request.getParameter("category");
		
		switch(hanbetu){
		
			//組織の場合↓↓ここから
			case "organaization":
			String ChangeSQL = "select * from organaizations";
			
			PreparedStatement select = con.prepareStatement(ChangeSQL);

			ResultSet selectResult = select.executeQuery();

			ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
			while (selectResult.next()) {
				OrganaizationBean organaiationBean = new OrganaizationBean();
				organaiationBean.setOrganaizationId(selectResult
						.getString("organaization_id"));
				organaiationBean.setOrganaizationName(selectResult
						.getString("organaization_name"));
				organaizationList.add(organaiationBean);
			}
			return organaizationList;
			break;
			//↑↑ここまで
			
			//役職の場合↓↓ここから
			case "organaization":
			String ChangeSQL = "select * from organaizations";
			
			PreparedStatement select = con.prepareStatement(ChangeSQL);

			ResultSet selectResult = select.executeQuery();

			ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
			while (selectResult.next()) {
				OrganaizationBean organaiationBean = new OrganaizationBean();
				organaiationBean.setOrganaizationId(selectResult
						.getString("organaization_id"));
				organaiationBean.setOrganaizationName(selectResult
						.getString("organaization_name"));
				organaizationList.add(organaiationBean);
			}
			return organaizationList;
			break;
			//↑↑ここまで
			
			//内線番号の場合↓↓ここから
			case "organaization":
			String ChangeSQL = "select * from organaizations";
			
			PreparedStatement select = con.prepareStatement(ChangeSQL);

			ResultSet selectResult = select.executeQuery();

			ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
			while (selectResult.next()) {
				OrganaizationBean organaiationBean = new OrganaizationBean();
				organaiationBean.setOrganaizationId(selectResult
						.getString("organaization_id"));
				organaiationBean.setOrganaizationName(selectResult
						.getString("organaization_name"));
				organaizationList.add(organaiationBean);
			}
			return organaizationList;
			break;
			//↑↑ここまで
			
			//組織の場合↓↓ここから
			case "organaization":
			String ChangeSQL = "select * from organaizations";
			
			PreparedStatement select = con.prepareStatement(ChangeSQL);

			ResultSet selectResult = select.executeQuery();

			ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
			while (selectResult.next()) {
				OrganaizationBean organaiationBean = new OrganaizationBean();
				organaiationBean.setOrganaizationId(selectResult
						.getString("organaization_id"));
				organaiationBean.setOrganaizationName(selectResult
						.getString("organaization_name"));
				organaizationList.add(organaiationBean);
			}
			return organaizationList;
			break;
			//↑↑ここまで
			
			//組織の場合↓↓ここから
			case "organaization":
			String ChangeSQL = "select * from organaizations";
			
			PreparedStatement select = con.prepareStatement(ChangeSQL);

			ResultSet selectResult = select.executeQuery();

			ArrayList<OrganaizationBean> organaizationList = new ArrayList<OrganaizationBean>();
			while (selectResult.next()) {
				OrganaizationBean organaiationBean = new OrganaizationBean();
				organaiationBean.setOrganaizationId(selectResult
						.getString("organaization_id"));
				organaiationBean.setOrganaizationName(selectResult
						.getString("organaization_name"));
				organaizationList.add(organaiationBean);
			}
			return organaizationList;
			break;
			//↑↑ここまで
			
			
			
			case "";
			
			
			
		}
		
	}*/

	/**
	 * コミット
	 * 
	 * @throws SQLException
	 **/
	public void commit() throws SQLException {
		con.commit();
	}

	/**
	 * ロールバック
	 * 
	 * @throws SQLException
	 **/
	public void rollback() throws SQLException {
		con.rollback();
	}

	/**
	 * クローズ
	 * 
	 * @throws SQLException
	 **/
	public void close() throws SQLException {
		con.close();
	}
}

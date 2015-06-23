package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Posts テーブル用のDao
 * 
 * @author s.kageyama
 */

public class PhoneDao {

	private Connection con = null;
	
	/**
	 * コンストラクタ
	 * @param Connection
	 **/
	public PhoneDao (Connection con) {
		this.con = con;
	}

	/**
	 * コンストラクタ
	 **/
	public PhoneDao() {
		if(con == null){
			DBConnecter db = new DBConnecter();
			con = db.getConnection();
		}
	}

	/**
	 * 　全件取得 　@return ArrayList PostList
	 * 
	 * @throws SQLException
	 **/
	public ArrayList<PhoneBean> selectAllInsidePhone() throws SQLException {

		String selectSQL = "SELECT phone_id,phone_inside FROM phones";

		PreparedStatement select = con.prepareStatement(selectSQL);

		ResultSet selectResult = select.executeQuery();
		ArrayList<PhoneBean> PhoneInsideList = new ArrayList<PhoneBean>();

		while (selectResult.next()) {
			PhoneBean phoneBean = new PhoneBean();
			phoneBean.setPhoneId(selectResult.getInt("phone_id"));
			phoneBean.setPhoneInside(selectResult.getString("phone_inside"));

			PhoneInsideList.add(phoneBean);
		}
		return PhoneInsideList;
	}
	
	/**
	 * 　全件取得 　@return ArrayList PostList
	 * 
	 * @throws SQLException
	 **/
	public ArrayList<PhoneBean> selectAllOutsidePhone() throws SQLException {

		String selectSQL = "SELECT phone_id,phone_outside FROM phones";

		PreparedStatement select = con.prepareStatement(selectSQL);

		ResultSet selectResult = select.executeQuery();
		ArrayList<PhoneBean> PhoneInsideList = new ArrayList<PhoneBean>();

		while (selectResult.next()) {
			PhoneBean phoneBean = new PhoneBean();
			phoneBean.setPhoneId(selectResult.getInt("phone_id"));
			phoneBean.setPhoneOutside(selectResult.getString("phone_outside"));

			PhoneInsideList.add(phoneBean);
		}
		return PhoneInsideList;
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

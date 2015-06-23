package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

public class PhoneDao {
	private Connection con = null;
	
	/**
	 * コンストラクタ
	 * @param Connection
	 **/
	public PhoneDao(Connection con) {
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
	 * 登録データの件数を取得
	 * @return int datacount
	 * @throws SQLException	 
	 */
	public int datacount() throws SQLException{
		String countsql = "SELECT phone_id FROM phones";
		PreparedStatement count = con.prepareStatement(countsql);
		ResultSet countResult = count.executeQuery();
		int datacount = 0;
		while(countResult.next()){
			datacount = countResult.getInt("phone_id");
		}
		return datacount;
	}
	
	/**
	 * インサート 
	 * @param PhoneBean
	 * @throws SQLException	
	 */
	public int insertPhone(PhoneBean insertphone) throws SQLException{
		String insertSQL = "INSERT INTO phones("
				+"phone_id,phone_inside,phone_outside)"
				+"VALUES(?,?,?)";
		
		PreparedStatement insert = con.prepareStatement(insertSQL);
		
		insert.setInt(1, insertphone.getPhoneId());
		insert.setString(2, insertphone.getPhoneInside());
		insert.setString(3, insertphone.getPhoneOutside());
		
		return insert.executeUpdate();
	}
	
	/**
	 * アップデート
	 * @param PhoneBean
	 * @throws SQLException	
	 */
	public int upodatePhone(PhoneBean updatephone) throws SQLException{
		String updateSQL = "UPDATE phones SET "
				+"phone_inside = ?,phone_outside = ?"
				+"WHERE phone_id = ?";
		
		PreparedStatement update = con.prepareStatement(updateSQL);
		
		update.setString(1, updatephone.getPhoneInside());
		update.setString(2, updatephone.getPhoneOutside());
		update.setInt(3, updatephone.getPhoneId());
		
		System.out.println(updateSQL);
		
		return update.executeUpdate();
	}
	
	
	/**
	 * 削除
	 * @param  phoneBean 削除データ
	 * @throws SQLException
	 */
	public int deletephone(PhoneBean delphone) throws SQLException{
		String deleteSQL = "DELETE FROM employees WHERE employee_id = ?";
		
		PreparedStatement delete = con.prepareStatement(deleteSQL);
		delete.setInt(1,delphone.getPhoneId());		
		
		return delete.executeUpdate();
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

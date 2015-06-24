package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PhoneBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Posts テーブル用のDao
 * 
 * @author s.kageyama
 */

public class CompanyDao {

	private Connection con = null;
	
	/**
	 * コンストラクタ
	 * @param Connection
	 **/
	public CompanyDao (Connection con) {
		this.con = con;
	}

	/**
	 * コンストラクタ
	 **/
	public CompanyDao() {
		if(con == null){
			DBConnecter db = new DBConnecter();
			con = db.getConnection();
		}
	}

	
	/**
	 * 全件取得
	 * @return Arraylist CompanyList
	 * @throws SQLException
	 **/
	public ArrayList<CompanieBean> selectAll() throws SQLException {

		String selectSQL = "SELECT company_id,compnay_name FROM companies";

		PreparedStatement select = con.prepareStatement(selectSQL);

		ResultSet selectResult = select.executeQuery();
		ArrayList<CompanieBean> CompanyList = new ArrayList<CompanieBean>();

		while (selectResult.next()) {
			CompanieBean companieBean = new CompanieBean();			
			companieBean.setCompanyId(selectResult.getInt("company_id"));
			companieBean.setCompanyName(selectResult.getString("compnay_name"));
			CompanyList.add(companieBean);
		}
		return CompanyList;
	}
	
	/**
	 * 登録データの件数を取得
	 * @return int datacount
	 * @throws SQLException	 
	 */
	public int datacount() throws SQLException{
		String countsql = "SELECT company_id FROM phones";
		PreparedStatement count = con.prepareStatement(countsql);
		ResultSet countResult = count.executeQuery();
		int datacount = 0;
		while(countResult.next()){
			datacount = countResult.getInt("company_id");
		}
		return datacount;
	}
	
	/**
	 * インサート 
	 * @param PhoneBean
	 * @throws SQLException	
	 */
	public int insertCompany(CompanieBean insertcompany) throws SQLException{
		String insertSQL = "INSERT INTO companies(company_id, compnay_name) VALUES (?,?)";
		PreparedStatement insert = con.prepareStatement(insertSQL);
		
		insert.setInt(1, insertcompany.getCompanyId());
		insert.setString(2, insertcompany.getCompanyName());
		return insert.executeUpdate();
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

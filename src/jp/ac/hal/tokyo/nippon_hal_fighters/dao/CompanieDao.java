package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

public class CompanieDao {
	
	private Connection con = null;
	
	/**
	 * コンストラクタ
	 * @param Connrction
	 **/
	public CompanieDao(Connection con) {
		this.con = con;
	}
	
	/**
	 * コンストラクタ
	 * @param Connrction
	 **/
	public CompanieDao() {
		if(con == null){
			DBConnecter db = new DBConnecter();
			con = db.getConnection();
		}
	}
	
	/**
	 *　全件取得 　@return ArrayList CompanieList
	 * @throws SQLException
	 **/
	public ArrayList<CompanieBean> selectAllCompanie() throws SQLException {
		String selectSQL = "SELECT company_id,compnay_name FROM companies";
		PreparedStatement select = con.prepareStatement(selectSQL);
		ResultSet selectResult = select.executeQuery();
		ArrayList<CompanieBean> CompList = new ArrayList<CompanieBean>();

		while (selectResult.next()) {
			CompanieBean compBean = new CompanieBean();
			compBean.setCompanyId(selectResult.getInt("company_id"));
			compBean.setCompanyName(selectResult.getString("compnay_name"));
			CompList.add(compBean);
		}
		return CompList;
	}	
	
	/**
	 * 会社情報の削除
	 * @param  CompanyBean 削除データ
	 * @return delete 情報追加成功数 1なら成功
	 * @throws SQLException
	 **/
	public int deletePost(CompanieBean deletecomp) throws SQLException{
		
		String deleteSql = "DELETE FROM companies WHERE company_id = ?";
		PreparedStatement delete = con.prepareStatement(deleteSql);
		delete.setInt(1, deletecomp.getCompanyId());
		
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

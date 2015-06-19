package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Posts テーブル用のDao
 * 
 * @author a.kikuhara
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
	public ArrayList<PostBean> selectAllPosts() throws SQLException {

		String selectSQL = "SELECT post_id,post_name FROM posts";

		PreparedStatement select = con.prepareStatement(selectSQL);

		ResultSet selectResult = select.executeQuery();
		ArrayList<PostBean> PostList = new ArrayList<PostBean>();

		while (selectResult.next()) {
			PostBean postBean = new PostBean();
			postBean.setPostId(selectResult.getInt("post_id"));
			postBean.setPostName(selectResult.getString("post_name"));

			PostList.add(postBean);
		}
		return PostList;
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

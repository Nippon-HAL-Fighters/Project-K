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
 * @author a.kikuhara
 */

public class PostDao {

	private Connection con = null;
	
	/**
	 * コンストラクタ
	 * @param Connection
	 **/
	public PostDao (Connection con) {
		this.con = con;
	}

	/**
	 * コンストラクタ
	 **/
	public PostDao() {
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
	 * 登録データの件数を取得
	 * @return int datacount
	 * @throws SQLException	 
	 */
	public int datacount() throws SQLException{
		String countsql = "SELECT post_id FROM posts";
		PreparedStatement count = con.prepareStatement(countsql);
		ResultSet countResult = count.executeQuery();
		int datacount = 0;
		while(countResult.next()){
			datacount = countResult.getInt("post_id");
		}
		return datacount;
	}
	
	/**
	 * インサート 
	 * @param PostBean
	 * @throws SQLException	
	 */
	public int insertPost(PostBean insertpost) throws SQLException{
		String insertSQL = "INSERT INTO posts("
				+"post_id,post_name)"
				+"VALUES(?,?)";
		
		PreparedStatement insert = con.prepareStatement(insertSQL);
		
		insert.setInt(1, insertpost.getPostId());
		insert.setString(2, insertpost.getPostName());
		
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

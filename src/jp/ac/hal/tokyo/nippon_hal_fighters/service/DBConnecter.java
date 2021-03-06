package jp.ac.hal.tokyo.nippon_hal_fighters.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * データベースのコネクションを取得するクラス
 *
 * @author s.kato
 */
public class DBConnecter {

	private Connection con;
	private InitialContext context;
	private String DBName = "java:comp/env/jdbc/ham";

	/**
	 * コンストラクタ コネクション作成
	 *
	 * @throws NamingException
	 * @throws SQLException
	 *
	 */
	public Connection getConnection() {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(DBName);
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

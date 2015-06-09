package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;

import com.mysql.jdbc.Connection;

public class EmployeeDao {
	/** Connection */
	private Connection con;;
	
	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 * 現状コネクション用クラスなしのため仮。
	 */
	public EmployeeDao() throws NamingException, SQLException {
		ConnectionGet get = new ConnectionGet();
		con = get.getCon();
	}
	
	/**
	 *コンストラクタ 
	 * @param con
	 */
	public EmployeeDao(Connection con){
		this.con = con;
	}
	
	/**
	 * 全件を取得する
	 * @param	なし
	 * @return 	全件データ(arraylist<Employeebean>) 
	 * @throws 	SQLException
	 * @author 	kikuhara
	 **/
	public List<EmployeeBean> findAll() throws SQLException{
		
		PreparedStatement select = con.prepareStatement("select * from employees");
		ResultSet result = select.executeQuery();
		
		ArrayList<EmployeeBean> table = new ArrayList<EmployeeBean>();
		while (result.next()){
			EmployeeBean recode = new EmployeeBean();
			recode.setEmployeeId(result.getString("employee_id"));
			recode.setEmployeeName(result.getString("employee_name"));
			recode.setEmployeeStatus(result.getString("employee_status"));
			recode.setAdmin(result.getInt("admin"));
			recode.setPassword(result.getString("password"));
			recode.setOrganaizationId(result.getInt("organaization_id"));
			recode.setPostId(result.getInt("post_id"));
			recode.setPhoneId(result.getInt("phone_id"));
			recode.setCompanyId(result.getInt("company_id"));
			
			table.add(recode);
		}		
		return table;	
	}
	
	/**
	 * 更新処理
	 * @param	updateRecord 更新データ
	 * @return 	影響のあった行数 
	 * @throws 	SQLException
	 * @author 	kikuhara
	 **/
	public int update(EmployeeBean updateRecode,String employeeId) throws SQLException{
		
		PreparedStatement update = con.prepareStatement("UPDATE employees SET employee_id = ? ,employee_name = ?,employee_status = ?,admin = ?,password = ?,organaization_id = ?, post_id = ?,phone_id = ?, company_id = ? WHERE employee_id = ?");
		update.setString(1, updateRecode.getEmployeeId());
		update.setString(2, updateRecode.getEmployeeName());
		update.setString(3, updateRecode.getEmployeeStatus());
		update.setInt(4, updateRecode.getAdmin());
		update.setString(5, updateRecode.getPassword());
		update.setInt(6, updateRecode.getOrganaizationId());
		update.setInt(7, updateRecode.getPostId());
		update.setInt(8, updateRecode.getPhoneId());
		update.setInt(9, updateRecode.getCompanyId());
		update.setString(10, employeeId);	
		return update.executeUpdate();	
	}
	
	/**
	 * 新規保存
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 * @author kikuhara
	 */
	public int create(EmployeeBean insertRecode) throws SQLException{
		PreparedStatement insert = con.prepareStatement("INSERT INTO employees(employee_id, employee_name, employee_status, admin, password, organaization_id, post_id, phone_id, company_id) VALUES (?,?,?,?,?,?,?,?,?)");
		insert.setString(1, insertRecode.getEmployeeId());
		insert.setString(2, insertRecode.getEmployeeName());
		insert.setString(3, insertRecode.getEmployeeStatus());
		insert.setInt(4, insertRecode.getAdmin());
		insert.setString(5, insertRecode.getPassword());
		insert.setInt(6, insertRecode.getOrganaizationId());
		insert.setInt(7, insertRecode.getPostId());
		insert.setInt(8, insertRecode.getPhoneId());
		insert.setInt(9, insertRecode.getCompanyId());
		return insert.executeUpdate();	
	}
	
	/**
	 * 削除処理
	 *
	 * @param employeeId 削除対象
	 * @return 影響のあった行数
	 * @throws SQLException
	 * @author kikuhara
	 */
	public int delete(String emploeeId) throws SQLException{
		
		PreparedStatement delete = con.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
		delete.setString(1, emploeeId);
		return delete.executeUpdate();
	}
	
	/**
	 * 接続を閉じる
	 * @throws SQLException
	 * @author kikuhara
	 */
	public void close() throws SQLException {
		con.close();
	}

	/**
	 * コミット
	 * @throws SQLException
	 * @author kikuhara
	 */
	public void commit() throws SQLException {
		con.commit();
	}

	/**
	 * ロールバック
	 * @throws SQLException	 
	 * @author kikuhara
	 */
	public void rollback() throws SQLException {
		con.rollback();
	}
	
	
}

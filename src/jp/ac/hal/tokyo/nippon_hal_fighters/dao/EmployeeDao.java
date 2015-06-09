package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

/**
 * Employee テーブル用のDAO
 *
 * @author s.kato
 *
 */
public class EmployeeDao {

	private Connection con;

	public EmployeeDao() {
		DBConnecter db = new DBConnecter();
		con = db.getConnection();
	}

	/**
	 * 全件取得
	 *
	 * @return ArrayList EmployeeList
	 * @throws SQLException
	 */
	public ArrayList<EmployeeBean> selectAllEmployees() throws SQLException {
		String selectSQL = "SELECT employee_id, employee_name, employee_status, admin, password, organaization_id, post_id, phone_id, company_id FROM employees";

		PreparedStatement select = con.prepareStatement(selectSQL);

		ResultSet selectResult = select.executeQuery();

		ArrayList<EmployeeBean> EmployeeList = new ArrayList<EmployeeBean>();
		while (selectResult.next()) {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployeeId(selectResult.getString("employee_id"));
			employeeBean.setEmployeeName(selectResult.getString("employee_name"));
			employeeBean.setEmployeeStatus(selectResult.getString("employee_status"));
			employeeBean.setAdmin(selectResult.getInt("admin"));
			employeeBean.setPassword(selectResult.getString("password"));
			employeeBean.setOrgnaizationId(selectResult.getInt("organaization_id"));
			employeeBean.setPostId(selectResult.getInt("post_id"));
			employeeBean.setPhoneId(selectResult.getInt("phone_id"));
			employeeBean.setCompanyId(selectResult.getInt("company_id"));

			EmployeeList.add(employeeBean);
		}
		return EmployeeList;
	}

	/**
	 * 社員情報追加
	 *
	 * @param insertData
	 *            登録する社員情報のBean
	 *
	 *            EmployeeId 社員番号 数字6桁, EmployeeName 社員名 20文字まで, EmployeeStatus
	 *            雇用状態 20文字まで, admin 管理者権限 0…なし、1…あり, Password パスワード 30文字まで,
	 *            OrganaizationId 数字4桁, PostID 役職番号 数字4桁, PhoneId 電話識別番号 数字4桁,
	 *            CompanyId 会社番号 数字4桁
	 *
	 * @return insertResult 情報追加成功数 1なら成功
	 * @throws SQLException
	 */
	public int insertEmployee(EmployeeBean insertData) throws SQLException {

		String insertSQL = "INSERT INTO employees("
				+ "employee_id, employee_name, employee_status, admin, password, organaization_id, post_id, phone_id, company_id)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement insert = con.prepareStatement(insertSQL);

		insert.setString(1, insertData.getEmployeeId());
		insert.setString(2, insertData.getEmployeeName());
		insert.setString(3, insertData.getEmployeeStatus());
		insert.setInt(4, insertData.getAdmin());
		insert.setString(5, insertData.getPassword());
		insert.setInt(6, insertData.getOrgnaizationId());
		insert.setInt(7, insertData.getPostId());
		insert.setInt(8, insertData.getPhoneId());
		insert.setInt(9, insertData.getCompanyId());

		return insert.executeUpdate();
	}

	public void commit() throws SQLException {
		con.commit();
	}

	public void rollback() throws SQLException {
		con.rollback();
	}

	public void close() throws SQLException {
		con.close();
	}

}

package jp.ac.hal.tokyo.nippon_hal_fighters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.tokyo.nippon_hal_fighters.beans.BackupBean;
import jp.ac.hal.tokyo.nippon_hal_fighters.service.DBConnecter;

public class BackupDao {
	private Connection con;

	public BackupDao() {
		DBConnecter db = new DBConnecter();
		con = db.getConnection();
	}

	public int fileDelete(int backupId, int companyPlace) throws SQLException {
		String deleteSQL = "DELETE FROM seat_backups WHERE backup_id = ? AND company_place = ?";
		int deleteResult = 0;

		PreparedStatement delete = con.prepareStatement(deleteSQL);

		delete.setInt(1, backupId);
		delete.setInt(2, companyPlace);

		deleteResult = delete.executeUpdate();

		return deleteResult;

	}

	public ArrayList<BackupBean> fileSelect(int backupId) throws SQLException {
		String selectSQL = "SELECT backup_id,backup_file,backup_img,title FROM seat_backups where backup_id=?";
		PreparedStatement select = con.prepareStatement(selectSQL);

		select.setInt(1, backupId);

		ResultSet selectResult = select.executeQuery();

		ArrayList<BackupBean> BackupList = new ArrayList<BackupBean>();
		while (selectResult.next()) {
			BackupBean backupBean = new BackupBean();
			backupBean.setBackupId(selectResult.getInt("backup_id"));
			backupBean.setBackupFile(selectResult.getString("backup_file"));
			backupBean.setBackupImg(selectResult.getByte("backup_img"));
			backupBean.setTitle(selectResult.getString("title"));

			BackupList.add(backupBean);
		}

		return BackupList;

	}

	// 東京
	public ArrayList<BackupBean> tokyoSelect() throws SQLException {
		String selectSQL = "SELECT backup_id,title,reset_date,implementor FROM seat_backups where company_place = ?";
		PreparedStatement select = con.prepareStatement(selectSQL);

		select.setInt(1, 0);

		ResultSet selectResult = select.executeQuery();

		ArrayList<BackupBean> BackupList = new ArrayList<BackupBean>();
		while (selectResult.next()) {
			BackupBean backupBean = new BackupBean();
			backupBean.setBackupId(selectResult.getInt("backup_id"));
			backupBean.setTitle(selectResult.getString("title"));
			backupBean.setResetDate(selectResult.getDate("reset_date"));
			backupBean.setImplementor(selectResult.getString("implementor"));

			BackupList.add(backupBean);
		}

		return BackupList;

	}

	// 大阪
	public ArrayList<BackupBean> osakaSelect() throws SQLException {
		String selectSQL = "SELECT backup_id,title,reset_date,implementor FROM seat_backups where company_place = ?";
		PreparedStatement select = con.prepareStatement(selectSQL);

		select.setInt(1, 1);

		ResultSet selectResult = select.executeQuery();

		ArrayList<BackupBean> BackupList = new ArrayList<BackupBean>();
		while (selectResult.next()) {
			BackupBean backupBean = new BackupBean();
			backupBean.setBackupId(selectResult.getInt("backup_id"));
			backupBean.setTitle(selectResult.getString("title"));
			backupBean.setResetDate(selectResult.getDate("reset_date"));
			backupBean.setImplementor(selectResult.getString("implementor"));

			BackupList.add(backupBean);
		}

		return BackupList;

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

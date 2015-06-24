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

	public int fileDelete(int backupId, int fileId) throws SQLException {
		String deleteSQL = "DELETE FROM backups WHERE backup_id = ? AND file_id = ?";
		int deleteResult = 0;

		PreparedStatement delete = con.prepareStatement(deleteSQL);

		delete.setInt(1, backupId);
		delete.setInt(2, fileId);

		deleteResult = delete.executeUpdate();

		return deleteResult;

	}

	public ArrayList<BackupBean> fileSelect(int backupId, int fileId)
			throws SQLException {
		String selectSQL = "SELECT backup_id,backup_file,file_id FROM backups where backup_id=? AND file_id = ?";
		PreparedStatement select = con.prepareStatement(selectSQL);

		select.setInt(1, backupId);
		select.setInt(2, fileId);

		ResultSet selectResult = select.executeQuery();

		ArrayList<BackupBean> BackupList = new ArrayList<BackupBean>();
		while (selectResult.next()) {
			BackupBean backupBean = new BackupBean();
			backupBean.setBackupId(selectResult.getInt("backup_id"));
			backupBean.setBackupFile(selectResult.getBytes("backup_file"));
			backupBean.setFileId(selectResult.getInt("file_id"));

			BackupList.add(backupBean);
		}

		return BackupList;

	}

	public ArrayList<BackupBean> listSelect(int fileId) throws SQLException {
		String selectSQL = "SELECT backup_id,title,reset_date,implementor FROM backups WHERE file_id = ?";
		PreparedStatement select = con.prepareStatement(selectSQL);

		select.setInt(1, fileId);

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

package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * バックアップテーブル用のBean
 *
 * int backupId; int fileId;
 *
 * @author s.kato
 *
 */
public class BackupBean {

	private int backupId;
	private int fileId;

	public int getBackupId() {
		return backupId;
	}

	public void setBackupId(int backupId) {
		this.backupId = backupId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

}

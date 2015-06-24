package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

import java.sql.Date;

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
	private String backupFile;
	private byte backupImg;
	private String title;
	private Date resetDate;
	private String implementor;

	public int getBackupId() {
		return backupId;
	}

	public void setBackupId(int backupId) {
		this.backupId = backupId;
	}

	public String getBackupFile() {
		return backupFile;
	}

	public void setBackupFile(String backupFile) {
		this.backupFile = backupFile;
	}

	public Date getResetDate() {
		return resetDate;
	}

	public void setResetDate(Date resetDate) {
		this.resetDate = resetDate;
	}

	public String getImplementor() {
		return implementor;
	}

	public void setImplementor(String implementor) {
		this.implementor = implementor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getBackupImg() {
		return backupImg;
	}

	public void setBackupImg(byte backupImg) {
		this.backupImg = backupImg;
	}

}

package jp.ac.hal.tokyo.nippon_hal_fighters.beans;


/**
 * バックアップテーブル用のBean
 *
 * private int backupId; private String backupFile; private byte backupImg;
 * private String title; private int fileId; private Date resetDate; private
 * String implementor;
 *
 * @author s.kato
 *
 */
public class BackupBean {

	private int backupId;

	private String backupFile;
	private byte backupImg;
	private String title;
	private int fileId;
	private String resetDate;
	private String implementor;
	private String companyPlace;

	public String getCompanyPlace() {
		return companyPlace;
	}

	public void setCompanyPlace(String companyPlace) {
		this.companyPlace = companyPlace;
	}

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

	public String getBackupFile() {
		return backupFile;
	}

	public void setBackupFile(String backupFile) {
		this.backupFile = backupFile;
	}

	public String getResetDate() {
		return resetDate;
	}

	public void setResetDate(String string) {
		this.resetDate = string;
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
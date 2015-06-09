package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

public class EmployeeBean {
	
	private String employeeId;		//社員番号
	private String employeeName;	//氏名
	private String employeeStatus;	//雇用状態
	private int admin;				//管理者権限
	private String password;		//パスワード
	private int organaizationId;	//組織コード
	private int postId;				//役職コード
	private int phoneId;			//電話コード
	private int companyId;			//会社コード
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOrganaizationId() {
		return organaizationId;
	}
	public void setOrganaizationId(int organaizationId) {
		this.organaizationId = organaizationId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}

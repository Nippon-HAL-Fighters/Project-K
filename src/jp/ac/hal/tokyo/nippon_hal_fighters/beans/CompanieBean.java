package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * 会社テーブル用Bean
 *
 * int companyId; String companyName;
 *
 * @author s.kato
 *
 */

public class CompanieBean {

	private int companyId;
	private String companyName;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}

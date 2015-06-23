package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * 組織テーブル用Bean
 *
 * String organaizationId; String organaizationName;
 *
 * @author s.kato
 *
 */
public class OrganaiationBean {

	private int organaizationId;
	private String organaizationName;
	public int getOrganaizationId() {
		return organaizationId;
	}
	public void setOrganaizationId(int organaizationId) {
		this.organaizationId = organaizationId;
	}
	public String getOrganaizationName() {
		return organaizationName;
	}
	public void setOrganaizationName(String organaizationName) {
		this.organaizationName = organaizationName;
	}
}

package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * 組織テーブル用Bean
 *
 * String organaizationId; String organaizationName;
 *
 * @author s.kato
 *
 */
public class OrganaizationBean {

	private String organaizationId;
	private String organaizationName;
	
	public String getOrganaizationId() {
		return organaizationId;
	}
	public void setOrganaizationId(String organaizationId) {
		this.organaizationId = organaizationId;
	}
	public String getOrganaizationName() {
		return organaizationName;
	}
	public void setOrganaizationName(String organaizationName) {
		this.organaizationName = organaizationName;
	}
}

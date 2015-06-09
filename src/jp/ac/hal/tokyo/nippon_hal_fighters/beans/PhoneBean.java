package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * 電話テーブル用Bean
 *
 * int phoneId; String phoneInside; String phoneOutside;
 *
 * @author s.kato
 *
 */

public class PhoneBean {

	private int phoneId;
	private String phoneInside;
	private String phoneOutside;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneInside() {
		return phoneInside;
	}

	public void setPhoneInside(String phoneInside) {
		this.phoneInside = phoneInside;
	}

	public String getPhoneOutside() {
		return phoneOutside;
	}

	public void setPhoneOutside(String phoneOutside) {
		this.phoneOutside = phoneOutside;
	}

}

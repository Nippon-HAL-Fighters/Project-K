package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * 座席テーブル用のBean
 *
 * int employeeId; int seatExsits; String memo;
 *
 * @author s.kato
 *
 */

public class SeatBean {

	int employeeId;
	int seatExsits;
	String memo;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSeatExsits() {
		return seatExsits;
	}

	public void setSeatExsits(int seatExsits) {
		this.seatExsits = seatExsits;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}

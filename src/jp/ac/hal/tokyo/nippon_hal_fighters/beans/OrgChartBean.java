package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgChartBean implements Serializable {

	private int orgChartID;

	private String graph;

	private String title;

	private Date lastModify;

	private String employeeID;

}

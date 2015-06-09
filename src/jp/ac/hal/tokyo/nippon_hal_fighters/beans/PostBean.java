package jp.ac.hal.tokyo.nippon_hal_fighters.beans;

/**
 * 役職テーブル用のBean
 *
 * int postId; String postName;
 *
 * @author s.kato
 *
 */

public class PostBean {

	int postId;
	String postName;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

}

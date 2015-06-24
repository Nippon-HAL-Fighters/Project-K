package jp.ac.hal.tokyo.nippon_hal_fighters.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * User管理に関するクラス
 *
 * @author 近藤
 *
 */
public class UserUtil {

	/**
	 * ユーザがログインしているかチェックします
	 *
	 * @param request HttpServletRequest
	 * @return ログインしている場合はtrue、ログインしていない場合はfalse
	 */
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("employee_id") != null) {
			return true;
		}

		return false;
	}

	/**
	 * ユーザがAdminかチェックします
	 *
	 * @param request HttpServletRequest
	 * @return Adminユーザの場合はtrue、Adminユーザ以外、ログインしていない場合はfalse
	 */
	public static boolean isAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("isAdmin") == null) {
			return false;
		}

		return (boolean) session.getAttribute("isAdmin");
	}

}

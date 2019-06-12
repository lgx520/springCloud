package common.service;

import common.pojo.User;

public interface UserService {
	/**
	 * 获得用户数据
	 * @param id
	 * @return
	 */
	String queryUser(String token);
	/**
	 * 登录
	 */
	String loginUser(User user);
	/**
	 * 退出登录
	 */
	String exit(String token);
}

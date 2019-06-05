package common.mapper;

import org.springframework.stereotype.Component;
import common.pojo.User;

@Component
public interface UserMapper {
	/**
	 * 查询用户数据
	 */
	User queryUser(User user);
}

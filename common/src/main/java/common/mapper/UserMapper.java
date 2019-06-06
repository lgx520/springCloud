package common.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import common.pojo.User;

@Component
public interface UserMapper {
	/**
	 * 查询用户数据
	 */
	List<User> getUserList(User user);
}

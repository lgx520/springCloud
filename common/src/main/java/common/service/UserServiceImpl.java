package common.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;

import common.mapper.UserMapper;
import common.pojo.User;
import common.service.redis.RedisService;
import common.util.CheckUtil;
import common.util.MD5Util;
import common.util.ResultUtil;
import common.util.SystemEnum;
import common.util.TokenUtil;

@Service
public class UserServiceImpl implements UserService{
	static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private RedisService redisService;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查询用户数据
	 */
	@Override
	public String queryUser(String token) {
		ResultUtil<User> result = new ResultUtil<>();
		try {
			CheckUtil.isNotNull(token);
		} catch (Exception e) {
			log.error("", e);
			result.setResult(SystemEnum.SYSTEM_PARAM_NULL);
			return result.toString();
		}
		try {
			//验证token
			DecodedJWT doToken = TokenUtil.doToken(token);
			
			Integer id = doToken.getClaim("id").asInt();
			
			User user = new User();
			user.setId(id);
			User queryUser = this.userMapper.queryUser(user);
			if (queryUser != null) {
				result.setResult(SystemEnum.SYSTEM_SUCCESS);
				result.setData(queryUser);
			} else {
				result.setResult(SystemEnum.SYSTEM_QUERY_USER_ID);
			}
		} catch (Exception e) {
			log.error("", e);
			result.setResult(SystemEnum.SYSTEM_ERROR);
		}
		
		return result.toString();
	}
	
	/**
	 * 用户登录
	 */
	@Override
	public String loginUser(User user) {
		ResultUtil<String> result = new ResultUtil<>();
		try {
			CheckUtil.isNotNull(user.getUserName());
			CheckUtil.isNotNull(user.getPassword());
		} catch (Exception e) {
			log.error("",e);
			result.setResult(SystemEnum.SYSTEM_PARAM_NULL);
			return result.toString();
		}
		
		try {
			//加密比较
			user.setPassword(MD5Util.MD5(user.getPassword()));
			User loginUser = this.userMapper.queryUser(user);
			if (loginUser != null) {
				//签发token
				String token = TokenUtil.sign(loginUser);
				//服务端保存token,过期时间为一小时
				this.redisService.setValueTime(loginUser.getId().toString(), token, 1, TimeUnit.HOURS);
				result.setResult(SystemEnum.SYSTEM_SUCCESS);
				result.setData(token);
			} else {
				result.setResult(SystemEnum.SYSTEM_USER_LOGIN_USER);
			}
		} catch (Exception e) {
			log.error("", e);
			result.setResult(SystemEnum.SYSTEM_ERROR);
		}
		
		return result.toString();
	}
}

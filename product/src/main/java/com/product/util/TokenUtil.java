package com.product.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.product.pojo.User;

/**
 * tokent认证登录
 * @author Neil
 *
 */
public class TokenUtil {
	private static final long EXPIRE_TIME = 5 * 60 * 1000;
	private static final String TOKEN_SECRET = "thefirsttoken123";
	
	static final Logger log = LoggerFactory.getLogger(TokenUtil.class);
	
	/**
	 * 生成token签名
	 * @param username
	 * @param password
	 * @return
	 */
	public static String sign(User user) {
		try {
			// 设置过期时间
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			// 私钥和加密算法
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			// 设置头部信息
			Map<String, Object> header = new HashMap<>(2);
			header.put("Type", "Jwt");
			header.put("alg", "HS256");
			// 返回token字符串
			return JWT.create()
					.withHeader(header)
					.withClaim("id", user.getId())
					.withExpiresAt(date)
					.sign(algorithm);
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
	}
	
	/**
	 * 解密tonken
	 */
	public static DecodedJWT doToken(String token) {
		DecodedJWT jwt = null;
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET))
	                .build();
	        jwt = verifier.verify(token);
		} catch (Exception e) {
			log.error("校验token------------>token已失效!");
		}
		return jwt;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setId(10);
		String sign = TokenUtil.sign(user);
		System.out.println(sign);
		DecodedJWT doToken = TokenUtil.doToken(sign);
		System.out.println(doToken.getClaim("id").asInt());
		
	}
}

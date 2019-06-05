package common.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 系统枚举
 * @author Neil
 *
 */
public enum SystemEnum {
	
	SYSTEM_SUCCESS("000000","成功"),SYSTEM_ERROR("999999","系统异常"),
	SYSTEM_PARAM_NULL("100001","参数不能为空"),
	SYSTEM_USER_LOGIN_USER("100003","账号或密码错误"),SYSTEM_QUERY_USER_ID("100004","用户不存在");

	SystemEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private String code;
	private String desc;
	
	@Override
	public String toString() {
		JSONObject obj = new JSONObject();
		obj.put("code", code);
		obj.put("desc", desc);
		
		return obj.toString();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}

package swagger.pojo;

import java.io.Serializable;

/**
 * @author Neil
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户名
	 */
	private String userName;
	//姓名
	private String name;
	//年龄
	private String age;
	//加入时间
	private String createTime;
	//手机号
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
}

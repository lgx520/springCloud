//package common.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import common.dao.UserMapper;
//import common.pojo.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by yangyibo on 17/1/18.
// */
//@Service
//public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口
//
//	@Autowired
//	private UserMapper userMapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String userName) { //重写loadUserByUsername 方法获得 userdetails 类型用户
//
//		//查询出一个用户
//		User queryUser = new User();
//		queryUser.setUserName(userName);
//		User user = this.userMapper.queryUser(queryUser);
//		if(user == null){
//			throw new UsernameNotFoundException("用户名不存在");
//		}
//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		//用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//		authorities.add(new SimpleGrantedAuthority(user.getUserName()));
//
//		return new org.springframework.security.core.userdetails.User(user.getUserName(),
//				user.getPassword(), authorities);
//	}
//}
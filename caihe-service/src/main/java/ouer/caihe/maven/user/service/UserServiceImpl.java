package ouer.caihe.maven.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ouer.caihe.maven.auth.model.User;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = new User();
		user.setPassword("test");
		user.setUsername("test");
		return user;
	}

}

package ouer.caihe.maven.auth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ouer.caihe.maven.auth.dto.UserDTO;
import ouer.caihe.maven.auth.model.ResourceRole;
import ouer.caihe.maven.auth.model.User;
import ouer.caihe.maven.mapper.auth.UserMapper;
import ouer.caihe.maven.mapper.auth.UserRoleMapper;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userMapper.selectUserByUsername(username);
		UserDTO userDTO = new UserDTO();
		userDTO.setAge(user.getAge());
		userDTO.setId(user.getId());
		userDTO.setPassword(user.getPassword());
		userDTO.setSex(user.getSex());
		userDTO.setUsername(user.getUsername());
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(); 
		authorities.addAll(loadUserAuthorities(user));
		userDTO.setAuthorities(authorities);
		return userDTO;
	}

	public List<GrantedAuthority> loadUserAuthorities(User user) {
		//查询该用户的权限
		List<ResourceRole> ResourceRoles = userMapper.selectResourceIdsByUserAuthorities(user.getId());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(ResourceRole resourceRole : ResourceRoles){
			authorities.add(new SimpleGrantedAuthority(resourceRole.getResourceId()));
		}
		return authorities;
	}

}

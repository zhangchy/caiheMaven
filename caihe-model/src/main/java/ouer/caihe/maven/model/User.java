package ouer.caihe.maven.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails ,Serializable{
	private static final long serialVersionUID = 576865543444374844L;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> Authorities;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return "ROLE_USER";
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	/**
	 * 获取当前用户拥有的角色
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Authorities = authorities;
	}
}

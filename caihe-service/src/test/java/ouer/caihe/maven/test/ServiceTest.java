package ouer.caihe.maven.test;

import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import ouer.caihe.maven.auth.service.UserService;

public class ServiceTest extends BaseTest<UserService>{
	@Test
	public void serviceTest(){
		UserDetails user = service.loadUserByUsername("");
		System.out.println("===================================");
		System.out.println(user.getUsername());
		System.out.println("===================================");
	}
}

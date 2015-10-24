package ouer.caihe.maven.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;


@Service("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler{
	@Value("${security.defaultTargetUrl}")
	String defaultTargetUrl;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//记录用户登录环境Log
		response.sendRedirect(request.getContextPath() + defaultTargetUrl);
	}

	public String getDefaultTargetUrl() {
		return defaultTargetUrl;
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}
}

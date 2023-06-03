package vti.com.config.exceptionHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class AuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

	@Autowired
	MessageSource messageSource;
	
	private String getMessage(String key) {
		return messageSource.getMessage(
				key,
				null, 
				"Default message!",
				LocaleContextHolder.getLocale());
	}
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		String message= getMessage("AccessDeniedException.message");;
		
		String detailMessage=accessDeniedException.getLocalizedMessage();
		int code= 9;
		String moreInfomationString = "http://localhost/api/v1/exception/9";
		
		ErrorResponse errorResponse = new ErrorResponse(message,detailMessage,null,code,moreInfomationString);
		
		//conver object to json
		
		com.fasterxml.jackson.databind.ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = writer.writeValueAsString(errorResponse);
		response.setContentType("application/json; charset = UTF-8");
		response.getWriter().write(json);
		
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		String message = getMessage("AuthenticationException.message");
		
		String detailMessage = authException.getLocalizedMessage();
		
		int code = 8;
		
		String moreInfomation = "http://localhost:8080/api/v1/exception/8";
		
		ErrorResponse errorResponse= new ErrorResponse(message, detailMessage, null, code, moreInfomation );
		
		com.fasterxml.jackson.databind.ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		String json = writer.writeValueAsString(errorResponse);
		
		
		//
		response.setContentType("application/json ;charset= UTF-8");
		response.getWriter().write(json);
		
		
	}
	

}

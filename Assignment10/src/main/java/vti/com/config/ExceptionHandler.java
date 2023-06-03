//package vti.com.config;
//
//
//	import java.util.HashMap;
//	import java.util.Iterator;
//	import java.util.Map;
//	
//	import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.http.HttpHeaders;
//	import org.springframework.http.HttpStatus;
//	import org.springframework.http.ResponseEntity;
//	import org.springframework.validation.FieldError;
//	import org.springframework.validation.ObjectError;
//	import org.springframework.web.bind.MethodArgumentNotValidException;
//	import org.springframework.web.bind.annotation.ControllerAdvice;
//	import org.springframework.web.context.request.WebRequest;
//	import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//	
//	@ControllerAdvice
//	public class ExceptionHandler  extends ResponseEntityExceptionHandler{
//		@Autowired
//		private MessageSource messageSource;
//		
//		//@SuppressWarnings("unused")
//		private String getMessage(String key) {
//			return messageSource.getMessage(
//					key,
//					null,
//					"Default message",
//					LocaleContextHolder.getLocale());
//		}
//		
//		protected ResponseEntity<Object>handleMethodArgumentNotValid(
//				MethodArgumentNotValidException exception,
//				HttpHeaders headers,
//				HttpStatus status,
//				WebRequest request){
//			Map<String, String> error = new HashMap<>();
//			
//			for (ObjectError errors : exception.getBindingResult().getAllErrors()) {
//				String fieldName = ((FieldError) error).getField();
//				String errorMessage = errors.getDefaultMessage();
//				error.put(fieldName, errorMessage);
//			}
//			
//			return new ResponseEntity<>(error,status) ;
//			
//		}
//	
//	}
//
//
//

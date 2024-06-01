package Exception;

import javax.management.BadAttributeValueExpException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jdk.jshell.spi.ExecutionControl.UserException;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(UserException.class)
	public String attributeValueExpException(BadAttributeValueExpException ex) {
		
		return ex.getMessage();
	}
	

	
	

}

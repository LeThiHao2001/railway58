package vti.com.config.exceptionHandler;

public class ErrorResponse {
	
	private String message;
	
	private String datailMessage;
	
	private Object error;
	
	private Integer code;
	
	private String moreInformation;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDatailMessage() {
		return datailMessage;
	}

	public void setDatailMessage(String datailMessage) {
		this.datailMessage = datailMessage;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public ErrorResponse(String message, String datailMessage, Object error, Integer code, String moreInformation) {
		super();
		this.message = message;
		this.datailMessage = datailMessage;
		this.error = error;
		this.code = code;
		this.moreInformation = moreInformation;
	}

	public ErrorResponse() {
		super();
	}
	
	

}

package br.com.zupacademy.marcio.casadocodigo.exception;

public class InvalidFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidFieldException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

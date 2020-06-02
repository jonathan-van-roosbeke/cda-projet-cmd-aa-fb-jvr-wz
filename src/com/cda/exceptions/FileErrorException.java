package com.cda.exceptions;

public class FileErrorException extends Exception {

	private static final long serialVersionUID = 154546L;
	private static final String message = "Fichier inexistant";

	public FileErrorException() {

		super();

	}

	public FileErrorException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return message;
	}

}

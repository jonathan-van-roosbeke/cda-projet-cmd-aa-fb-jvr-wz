package com.cda.exceptions;

public class FileErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public FileErrorException() {
	}

	public FileErrorException(String msg) {
		super(msg);
	}
}

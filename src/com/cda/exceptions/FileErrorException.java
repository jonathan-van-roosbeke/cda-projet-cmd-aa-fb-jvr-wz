package com.cda.exceptions;

public class FileErrorException extends Exception {

	public FileErrorException() {
		System.out.println("Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !");
	}

}

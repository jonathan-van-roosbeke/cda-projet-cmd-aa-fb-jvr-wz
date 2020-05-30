package com.cda.simulateur.prog;

import java.io.IOException;

import com.cda.exceptions.FileErrorException;
import com.cda.simulateur.tools.Ihm;

public class ProgrammeSimulateurConsole {

	public static void main(String[] args) {

		try {
			Ihm.lancerMenu();
		} catch (FileErrorException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem fichier");
		}

	}
}

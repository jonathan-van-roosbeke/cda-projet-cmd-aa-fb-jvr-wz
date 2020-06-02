package com.cda.simulateur.prog;

import java.io.IOException;

import com.cda.exceptions.FileErrorException;
import com.cda.simulateur.tools.Ihm;

public class ProgrammeSimulateurConsole {

	public static void main(String[] args) {
		String proprieteLancement = System.getProperty("cdi.default.folder");

		if (proprieteLancement != null) {
			System.setProperty("user.dir", proprieteLancement);
		}

		try {
			Ihm.lancerMenu();
		} catch (FileErrorException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem fichier");
		}
	}
}

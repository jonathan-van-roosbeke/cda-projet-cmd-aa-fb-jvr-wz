package com.cda.simulateur.repertory.model;

import java.io.IOException;

import com.cda.exceptions.FileErrorException;
import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

public class Getvars extends Command {
	public static Getvars getvarsInstance = new Getvars();

	private Getvars() {
		super();
	}

	@Override
	public void executer() throws FileErrorException {
		Utils.environnement();
		System.out.println("\n");
		Utils.jvm();
	}

	@Override
	public void executer(String... pSaisie) throws FileErrorException, IOException {
		String parametre = Utils.stringCleaner(pSaisie);
		String[] test = parametre.split(" ");

		if (test.length != 1) {

		}
	}
}

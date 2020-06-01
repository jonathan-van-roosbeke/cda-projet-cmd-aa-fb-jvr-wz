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
		System.out.print("\n");
		Utils.jvm();
	}

	@Override
	public void executer(String... pSaisie) throws FileErrorException, IOException {
		String parametre = Utils.stringCleaner(pSaisie);
		String[] test = parametre.split(" ");

		if (test.length == 2 && test[0].equals("-env") && test[1].equals("-prop")) {
			executer();
		} else if (test.length == 2 && test[0].equals("-prop") && test[1].equals("-env")) {
			Utils.jvm();
			System.out.print("\n");
			Utils.environnement();
		}
	}
}

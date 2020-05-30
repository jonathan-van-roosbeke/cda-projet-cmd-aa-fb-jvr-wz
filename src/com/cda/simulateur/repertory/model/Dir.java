package com.cda.simulateur.repertory.model;

import java.io.File;

import com.cda.simulateur.menu.action.Command;

public class Dir extends Command {

	public final static Dir dirInstance = new Dir();

	Dir() {
		super();
	}

	private void afficheDossier(File pFile) {
		if (pFile.isDirectory()) {
			System.out.println("<DIR> " + pFile.getName());
		} else {
			System.out.println(String.format("%18s", pFile.getName()));
		}
	}

	@Override
	public void executer() {
		String vUrl = "C:/";

		File[] vFiles = new File(vUrl).listFiles();

		for (File f : vFiles) {
			afficheDossier(f);
		}
	}

	@Override
	public void executer(String... pSaisie) {
	}
}

package com.cda.simulateur.repertory.model;

import java.io.File;

import com.cda.simulateur.menu.action.Command;

public class Dir extends Command {

	public final static Dir dirInstance = new Dir();
	protected int vNombreDossier;
	protected int vNombreFichier;

	Dir() {
		super();
	}

	private void afficheDossier(File pFile) {
		if (pFile.isDirectory()) {
			this.vNombreDossier++;
			System.out.println("<DIR> " + pFile.getName());
		} else {
			this.vNombreFichier++;
			System.out.println(String.format("%18s", pFile.getName()));
		}
	}

	public int getvNombreDossier() {
		return vNombreDossier;
	}

	public int getvNombreFichier() {
		return vNombreFichier;
	}

	@Override
	public void executer() {
		String vUrl = "C:/";
		vNombreDossier = 0;
		vNombreFichier = 0;
		File[] vFiles = new File(vUrl).listFiles();

		for (File f : vFiles) {
			afficheDossier(f);
		}
	}

	@Override
	public void executer(String... pSaisie) {
	}
}

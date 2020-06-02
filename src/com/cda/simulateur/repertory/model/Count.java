package com.cda.simulateur.repertory.model;

import java.io.File;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

public class Count extends Command {

	public static Count countInstance = new Count();
	private static int[] nombreFichier = countFichier();

	// la sortie int[] de count =>
	// int[0] = nombre repertoire / int[1] = nombre fichier
	private static int[] countFichier() {
		int vNombreDossier = 0;
		int vNombreFichier = 0;
		int[] vArrayNombreElement = new int[2];

		File[] vFiles = new File(Pwd.getAdressCourante()).listFiles();

		for (File f : vFiles) {
			if (f.isDirectory()) {
				vNombreDossier++;
			} else {
				vNombreFichier++;
			}
		}
		vArrayNombreElement[0] = vNombreDossier;
		vArrayNombreElement[1] = vNombreFichier;
		return vArrayNombreElement;
	}

	private void checkArgument(String pArgument) {
		String vNonValidArgument = "";
		pArgument = Utils.removeDuplicateCharacter(pArgument);
		for (int i = 0; i < pArgument.length(); i++) {
			if (pArgument.charAt(i) != '-' && pArgument.charAt(i) != 'd' && pArgument.charAt(i) != 'f') {
				vNonValidArgument += pArgument.charAt(i);
			}
		}

		if (vNonValidArgument.length() == 0) {
			for (int i = 0; i < pArgument.length(); i++) {
				switch (pArgument.charAt(i)) {

				case 'f':
					afficheNombreFichier(nombreFichier[1]);
					break;

				case 'd':
					afficheNombreRepertoire(nombreFichier[0]);
					break;
				}
			}

		} else {
			System.out.println("unknown option -" + vNonValidArgument);
		}
	}

	private void afficheNombreRepertoire(int pNombreElement) {
		System.out.println(pNombreElement + " dossiers");
	}

	private void afficheNombreFichier(int pNombreElement) {
		System.out.println(pNombreElement + " fichiers");
	}

	@Override
	public void executer() {
		nombreFichier = countFichier();
		afficheNombreRepertoire(nombreFichier[0]);
		afficheNombreFichier(nombreFichier[1]);
	}

	@Override
	public void executer(String... pSaisie) {
		nombreFichier = countFichier();
		String[] vArguments = pSaisie[0].split(" ");

		for (String s : vArguments) {
			checkArgument(s);
		}
	}
}

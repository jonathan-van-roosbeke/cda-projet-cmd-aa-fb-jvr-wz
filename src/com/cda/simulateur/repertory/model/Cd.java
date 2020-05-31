package com.cda.simulateur.repertory.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

public final class Cd extends Command {

	public static Cd cdInstance = new Cd();

	private Cd() {
		super();
	}

	// verifie le chemin absolue
	private static boolean existAbsolute(String pSaisie) {
		File vFile = new File(pSaisie);
		if (vFile.isDirectory()) {
			return true;
		}
		return false;
	}

	// verifie si le document existe dans le repertoire courant
	private static boolean existInRepertory(String pSaisie) {
		String vTempChemin = Pwd.getAdressCourante() + "/" + pSaisie;
		File file = new File(vTempChemin);
		if (file.isDirectory()) {
			return true;
		}
		return false;
	}

	// va dans le dossier parent
	private void goToParentDirectory() {
		if (Pwd.vCheminArray.size() > 1) {
			Pwd.vCheminArray.remove(Pwd.vCheminArray.size() - 1);
		}
	}

	// va dans le dossier courant
	private void goToFolder(String pFolder) {
		String vTempChemin = Pwd.getAdressCourante() + "/" + pFolder;
		File vFile = new File(vTempChemin);
		Pwd.vCheminArray.add(pFolder);
	}

	// converti l'adresse c:/windows -> [c:, windows]
	private List<String> convertiAdresseEntreeEnArray(String pAdresse) {
		List<String> vAdresseArray = new LinkedList<String>(Arrays.asList(pAdresse.split("/")));
		return vAdresseArray;
	}

	// converti l'url entrée c:\\windows/programmes -> c:/windows/programmes
	private String convertToValidUrl(String pAdresse) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < pAdresse.length(); i++) {
			if (pAdresse.charAt(i) == '\\') {
				sb.append("/");
			} else {
				sb.append(pAdresse.charAt(i));
			}
		}
		return sb.toString();
	}

	// envoie message d'erreur
	private void erreurChemin() {
		System.out.println("le repertoire que vous demandez est introuvable \n");
	}

	@Override
	public void executer() {
	}

	@Override
	public void executer(String... pSaisie) {
		String vAdresse = Utils.stringCleaner(pSaisie);
		vAdresse = convertToValidUrl(vAdresse);
		List<String> vListAdresse = convertiAdresseEntreeEnArray(vAdresse);

		if (vListAdresse.size() == 1) {
			if (vListAdresse.get(0).equals("..")) {
				goToParentDirectory();
			} else if (vAdresse.contains(":")) {
				if (existAbsolute(vAdresse)) {
					Pwd.vCheminArray.clear();
					Pwd.vCheminArray.addAll(vListAdresse);
				}

			} else {
				if (existInRepertory(vListAdresse.get(0))) {
					goToFolder(vListAdresse.get(0));
				} else {
					erreurChemin();
				}
			}
		} else {
			// le cas ou l'adresse contient un c: -> on verifie si le chemin abolue existe
			if (vAdresse.contains(":")) {
				if (existAbsolute(vAdresse)) {
					Pwd.vCheminArray.clear();
					Pwd.vCheminArray.addAll(vListAdresse);
				} else {
					erreurChemin();
					return;
				}
			} else {
				// le cas ou l'on se trouve dans un dossier et qu'on veut verifier si :
				// "folder1/sub-folder2/sub-subfolder3
				List<String> vTempUrl = new ArrayList<>(Pwd.vCheminArray);
				List<String> vBackupPwd = new ArrayList<>(Pwd.vCheminArray);
				for (String s : vListAdresse) {
					if (s.equals("..")) {
						goToParentDirectory();
						vTempUrl = new ArrayList<>(Pwd.vCheminArray);
					} else if (existInRepertory(s)) {
						vTempUrl.add(s);
					} else {
						erreurChemin();
						vTempUrl.clear();
						Pwd.vCheminArray.clear();
						Pwd.vCheminArray.addAll(vBackupPwd);
						return;
					}
				}
				if (vTempUrl.size() > 0) {
					Pwd.vCheminArray.clear();
					Pwd.vCheminArray.addAll(vTempUrl);
				}
			}
		}
	}
}
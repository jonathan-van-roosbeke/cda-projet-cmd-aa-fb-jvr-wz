package com.cda.simulateur.repertory.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

public final class Cd2 extends Command {
	public static Cd2 cdInstance = new Cd2();

	private Cd2() {
		super();
	}

	private static boolean verifieSiLeDocumentExisteDansRepertoireCourant(String pSaisie) {
		String tempChemin = Pwd.getAdressCourante() + "/" + pSaisie;
		File file = new File(tempChemin);
		if (file.isDirectory()) {
			return true;
		}
		return false;
	}

	private void goToParentDirectory() {
		if (Pwd.vCheminArray.size() > 1) {
			Pwd.vCheminArray.remove(Pwd.vCheminArray.size() - 1);
		}
	}

	private void goToFolder(String pFolder) {
		String tempChemin = Pwd.getAdressCourante() + "/" + pFolder;
		File file = new File(tempChemin);
		Pwd.vCheminArray.add(pFolder);
	}

	// converti l'adresse c:/windows -> [c:, windows]
	private List<String> convertiAdresseEntreeEnArray(String pAdresse) {
		List<String> adresseArray = new LinkedList<String>(Arrays.asList(pAdresse.split("\\\\")));
		return adresseArray;
	}

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

	@Override
	public void executer() {
	}

	@Override
	public void executer(String... pSaisie) {
		String adresse = Utils.stringCleaner(pSaisie);
		adresse = convertToValidUrl(adresse);
		List<String> listAdresse = convertiAdresseEntreeEnArray(adresse);
		System.out.println(listAdresse);
		if (listAdresse.size() == 1) {
			if (listAdresse.get(0).equals("..")) {
				goToParentDirectory();
			} else {
				if (verifieSiLeDocumentExisteDansRepertoireCourant(listAdresse.get(0))) {
					goToFolder(listAdresse.get(0));
				}
			}
		} else {
			List<String> tempUrl = new ArrayList<>(Pwd.vCheminArray);
			List<String> backUpPwd = new ArrayList<>();
			for (String s : listAdresse) {
				tempUrl.add(s);
				if (s.equals("..")) {
					goToParentDirectory();
				}
			}
		}
	}
}
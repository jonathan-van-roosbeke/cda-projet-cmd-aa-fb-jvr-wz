package com.cda.simulateur.repertory.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;

public final class Cd extends Command {
	private static final String ID = "cd";
	private static final String DESC = "Change de répertoire";

	Cd() {
		super(ID, DESC);
	}

	public void executer(String pSaisie) {

		// va au parent si la commande == ".." || "cd.."
		if (pSaisie.equals("..") || pSaisie.equalsIgnoreCase("cd..") && Pwd.vCheminArray.size() > 1) {
			Pwd.vCheminArray.remove(Pwd.vCheminArray.size() - 1);
			Pwd.getAdressCourante();
		} else if (pSaisie.equals(".")) {
			// on ne fait rien, on reste dans le répertoire actuel
			// si le repertoire absolue existe on efface le Pwd et on met le nouveau chemin
		} else if (verifieSiCheminAbsolueExiste(pSaisie)) {
			Pwd.vCheminArray.clear();
			List<String> temp = Arrays.asList(pSaisie.split("\\\\"));
			for (String s : temp) {
				Pwd.vCheminArray.add(s);
			}
			// on verfie si le repertoire demande existe dans le repertoire actuel
		} else if (verifieSiLeDocumentExisteDansRepertoireCourant(pSaisie)) {
			Pwd.vCheminArray.add(pSaisie);
		} else {
			System.out.println("le repertoire que vous demandez est introuvable \n");
		}
	}

	private static boolean verifieSiCheminAbsolueExiste(String pSaisie) {
		File file = new File(pSaisie);
		if (file.isDirectory()) {
			return true;
		}
		return false;
	}

	private static boolean verifieSiLeDocumentExisteDansRepertoireCourant(String pSaisie) {
		String tempChemin = Pwd.getAdressCourante() + "\\" + pSaisie;
		File file = new File(tempChemin);
		if (file.isDirectory()) {
			return true;
		}
		return false;
	}
}
package com.cda.simulateur.repertory.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;

public final class Cd extends Command {
	public static Cd cdInstance = new Cd();

	private Cd() {
		super();
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

	@Override
	public void executer() {

	}

	@Override
	public void executer(String... pSaisie) {

		// va au parent si la commande == ".." || "cd.."
		if (pSaisie[0].equals("..") || pSaisie[0].equalsIgnoreCase("cd..") && Pwd.vCheminArray.size() > 1) {
			Pwd.vCheminArray.remove(Pwd.vCheminArray.size() - 1);
			Pwd.getAdressCourante();

		} else if (pSaisie.equals(".")) {
			// on ne fait rien, on reste dans le repertoire actuel

			// si le repertoire absolue existe on efface le Pwd et on met le nouveau chemin
		} else if (verifieSiCheminAbsolueExiste(pSaisie[0])) {
			Pwd.vCheminArray.clear();
			List<String> temp = Arrays.asList(pSaisie[0].split("\\\\"));
			for (String s : temp) {
				Pwd.vCheminArray.add(s);
			}

		} else if (verifieSiLeDocumentExisteDansRepertoireCourant(pSaisie[0])) {
			Pwd.vCheminArray.add(pSaisie[0]);

		} else {
			System.out.println("le repertoire que vous demandez est introuvable \n");
		}
	}
}

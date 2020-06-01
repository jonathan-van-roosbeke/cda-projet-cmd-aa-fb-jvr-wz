package com.cda.simulateur.menu.action;

import java.util.HashMap;
import java.util.Map;

public class Help extends Command {
	private static final HashMap<String, String> LISTCMD = new HashMap<>();

	public static Help help = new Help();

	private Help() {
		super();
		LISTCMD.put("help", "Liste les cmd de la console");
		LISTCMD.put("exit", "Commande pour quitter la console");
		LISTCMD.put("history", "Liste des dernieres Cmd effectué");
		LISTCMD.put("histclear", "Efface les Cmd tapé precedement");
		LISTCMD.put("pwd", "affiche le dossier courant");
		LISTCMD.put("river", "Affiche la 1ere intersection des rivieres");
		LISTCMD.put("isprime", "Verifie si le nbre est premier.");
		LISTCMD.put("dir", "Affiche le contenu de C:");
		LISTCMD.put("CD", "Changer de repertoire");
		LISTCMD.put("find", "liste tous les fichiers dans le répertoire en cours");
		LISTCMD.put("cat", "Affiche le contenu du fichier selectionné");
		LISTCMD.put("copy", "Copie un fichier ");
		LISTCMD.put("CRF", "crée un fichier avec ce nom dans le répertoire en cours");
		LISTCMD.put("CRD", "crée un répertoire avec ce nom dans le répertoire en cours");
		LISTCMD.put("dirng", "Affiche le contenu du repertoire en cour 2.0");
	}

	@Override
	public void executer(String... pSaisie) {
		System.out.println("Bonjour sur la console cda");
		for (Map.Entry<String, String> entry : Help.LISTCMD.entrySet()) {
			System.out.println(String.format("%-12s : %15s", entry.getKey(), entry.getValue()));
		}
	}

	@Override
	public void executer() {
		System.out.println("Bonjour sur la console cda");
		for (Map.Entry<String, String> entry : Help.LISTCMD.entrySet()) {
			System.out.println(String.format("%-12s : %15s", entry.getKey(), entry.getValue()));
		}
	}
}

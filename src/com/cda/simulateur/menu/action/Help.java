package com.cda.simulateur.menu.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.cda.simulateur.tools.Utils;

public class Help extends Command {
	private static final HashMap<String, String> LISTCMD = new HashMap<>();
	private static final HashMap<String, String> DETAILCMD = new HashMap<>();

	public static Help help = new Help();

	private Help() {
		super();
		LISTCMD.put("cat", "Affiche le contenu d'un fichier texte.");
		LISTCMD.put("cd", "Change le répertoire en cours.");
		LISTCMD.put("count",
				"Affiche le nombre de fichiers et dossiers\r\n" + "             dans le répertoire en cours.");
		LISTCMD.put("copy", "Copie un fichier.");
		LISTCMD.put("crd", "Crée un répertoire.");
		LISTCMD.put("crf", "Crée un fichier dans.");
		LISTCMD.put("dir", "Affiche le contenu de c:\\");
		LISTCMD.put("dirng", "Affiche le contenu du repertoire en cours\r\n"
				+ "             et affiche le nombre de fichiers et répertoire.");
		LISTCMD.put("exit", "Quitte l'interpréteur de commandes.");
		LISTCMD.put("find", "Liste tous les fichiers dans le répertoire en cours.");
		LISTCMD.put("fline", "Affiche le contenu d'un fichier.");
		LISTCMD.put("getvars",
				"Affiche les variables d'environnement\r\n" + "             et les propriétés de la jvm");
		LISTCMD.put("help", "Affiche des informations sur les commandes.");
		LISTCMD.put("histclear", "Efface l'historique de commandes.");
		LISTCMD.put("history", "Affiche l'historique des commandes.");
		LISTCMD.put("isprime", "Affiche si le nombre est premier.");
		LISTCMD.put("ls", "Affiche le contenu du répertoire en cours.");
		LISTCMD.put("now", "Affiche l'heure et la date.");
		LISTCMD.put("pwd", "Affiche l'adresse du répertoire en cours.");
		LISTCMD.put("river", "Affiche la première intersection des rivières.");

		DETAILCMD.put("cat", "\nTYPE [lecteur:][chemin]nom_de_fichier\r\n");
		DETAILCMD.put("cd",
				"\nCD [lecteur:][chemin]\r\n" + "CD [..]\r\n" + "CD [.]\r\n"
						+ "\n  ..   Signifie que vous voulez vous placer sur le répertoire parent.\r\n"
						+ "  .    Signifie que vous voulez afficher le répertoire en cours.\r\n"
						+ "\nEntrez CD lecteur: pour afficher le répertoire en cours sur le lecteur.\r\n"
						+ "Entrez CD sans paramètres pour afficher le lecteur et le répertoire en cours.\r\n");
		DETAILCMD.put("count", "\nCOUNT \r\n" + "COUNT [-f]\r\n" + "COUNT [-d]\r\n");
		DETAILCMD.put("copy", "En cours d'implémentation.\r\n");
		DETAILCMD.put("crd", "En cours d'implémentation.\r\n");
		DETAILCMD.put("crf", "En cours d'implémentation.\r\n");
		DETAILCMD.put("dir", "En cours d'implémentation.\r\n");
		DETAILCMD.put("dirng", "En cours d'implémentation.\r\n");
		DETAILCMD.put("exit", "En cours d'implémentation.\r\n");
		DETAILCMD.put("find", "En cours d'implémentation.\r\n");
		DETAILCMD.put("fline", "En cours d'implémentation.\r\n");
		DETAILCMD.put("getvars", "En cours d'implémentation.\r\n");
		DETAILCMD.put("help", "En cours d'implémentation.\r\n");
		DETAILCMD.put("histclear", "En cours d'implémentation.\r\n");
		DETAILCMD.put("history", "En cours d'implémentation.\r\n");
		DETAILCMD.put("isprime", "En cours d'implémentation.\r\n");
		DETAILCMD.put("ls", "En cours d'implémentation.\r\n");
		DETAILCMD.put("now", "En cours d'implémentation.\r\n");
		DETAILCMD.put("pwd", "En cours d'implémentation.\r\n");
		DETAILCMD.put("river", "En cours d'implémentation.\r\n");
	}

	@Override
	public void executer(String... pSaisie) {
		String arg = Utils.stringCleaner(pSaisie);
		String[] args = arg.split(" ");
		if (LISTCMD.get(args[0]) == null) {
			System.out.println("Cette commande n’est pas prise en charge par l’utilitaire d’aide.\n");
		} else {
			System.out.println(LISTCMD.get(args[0]) + "\n" + DETAILCMD.get(args[0]));
		}
	}

	@Override
	public void executer() {
		System.out.println(
				"Pour plus d’informations sur une commande spécifique, entrez HELP\n" + "suivi de la commande.");

		LinkedHashMap<String, String> collect = LISTCMD.entrySet().stream()
				.collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue())).entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		collect.forEach((k, e) -> System.out.format("%-12s %s%n", k.toUpperCase(), e));
		System.out.println("");
	}
}

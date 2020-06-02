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
		LISTCMD.put("crf", "Crée un fichier.");
		LISTCMD.put("dir", "Affiche la liste des fichiers et sous-répertoires\r\n" + "             d'un répertoire.");
		LISTCMD.put("dirng", "Affiche le contenu du repertoire en cours\r\n"
				+ "             et affiche le nombre de fichiers et répertoire.");
		LISTCMD.put("exit", "Quitte l'interpréteur de commandes.");
		LISTCMD.put("find", "Recherche une chaîne de caractères dans un ou plusieurs\r\n" + "             fichiers.");
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

		DETAILCMD.put("cat", "\nCAT [lecteur:][chemin][nom_de_fichier]\r\n");
		DETAILCMD.put("cd",
				"\nCD [lecteur:][chemin]\r\n" + "CD [..]\r\n" + "CD [.]\r\n"
						+ "\n  ..   Signifie que vous voulez vous placer sur le répertoire parent.\r\n"
						+ "  .    Signifie que vous voulez afficher le répertoire en cours.\r\n"
						+ "\nEntrez CD lecteur: pour afficher le répertoire en cours sur le lecteur.\r\n"
						+ "Entrez CD sans paramètres pour afficher le lecteur et le répertoire en cours.\r\n");
		DETAILCMD.put("count", "\nCOUNT \r\n" + "COUNT [-f]\r\n" + "COUNT [-d]\r\n");
		DETAILCMD.put("copy", "\nCOPY [nom_de_fichier][nom_de_fichier_copié].\r\n");
		DETAILCMD.put("crd", "\nCRD [nom_de_répertoire].\r\n"
				+ "\nCréé un répertoire dont le nom est rentré en paramètre\r\n" + "dans le répertoire en cours.\r\n");
		DETAILCMD.put("crf", "\nCRF [nom_de_fichier].\r\n" + "\nCréé un fichier dont le nom est rentré en paramètre\r\n"
				+ "dans le répertoire en cours.\r\n");
		DETAILCMD.put("dir",
				"\nDIR\r\n" + "DIR [lecteur:][chemin]\r\n"
						+ "\nAffiche la liste des fichiers et sous-répertoires du répertoire en cours."
						+ "\nAffiche la liste des fichiers et sous-répertoires du répertoire spécifié.\r\n");
		DETAILCMD.put("dirng",
				"\nDIRNG\r\n" + "DIRNG [lecteur:][chemin]\r\n"
						+ "\nAffiche la liste des fichiers et sous-répertoires du répertoire en cours\r\n"
						+ "et affiche le nombre de fichiers et/ou de répertoires du répertoire en cours\r\n"
						+ "ou du répertoire spécifié\r\n");
		DETAILCMD.put("exit", "\nEXIT\r\n" + "\nQuitte le programme console.jar (interpréteur de commandes).\r\n");
		DETAILCMD.put("find", "\nFIND\r\n" + "FIND [-starts]\"chaîne\"\r\n" + "FIND [-ends]\"chaîne\"\r\n"
				+ "FIND [-starts]\"chaîne\"[-ends]\"chaîne\"\r\n"
				+ "\n  -starts[chaîne]   Signifie que vous recherchez un fichier dont le nom commence\r\n"
				+ "                    par la chaîne de caractères entrée en paramètre.\r\n"
				+ "  -ends[chaîne]     Signifie que vous recherchez un fichier dont le nom ou l'extension\r\n"
				+ "                    se termine par la chaîne de caractères entrée en paramètre\r\n"
				+ "                    Si les deux paramètres sont spécifiés, signifie que vous recherchez un fichier dont le nom commence\r\n"
				+ "                    et se termine par les chaînes de caractères entrées en paramètre.\r\n");
		DETAILCMD.put("fline", "\nFLINE [nom_de_fichier][-n]\r\n" + "FLINE [nom_de_fichier][-d] [-f] [-s]\r\n"
				+ "\n  -n  Affiche le nombre de lignes, ne peut pas être utilisée en même temps qu'une autre option.\r\n"
				+ "  -d  Permet de définir inclusivement le numéro de ligne à partir duquel le traitement va être fait.\r\n"
				+ "  -f  Permet de définir inclusivement le numéro de ligne jusqu'auquel le traitement va être fait.\r\n"
				+ "  -s  Permet de chercher une chaîne de caractères dans une ligne.\r\n");
		DETAILCMD.put("getvars", "\nGETVARS\r\n" + "GETVARS [-env]\r\n" + "GETVARS [-prop]\r\n"
				+ "GETVARS [-env][-prop]\r\n"
				+ "\n         Sans paramètres affiche les variables d'environnement et les propriétes de la JVM.\r\n"
				+ "  -env   Affiche les variables d'environnement.\r\n"
				+ "  -prop  Affiche les propriétés de la JVM.\r\n");
		DETAILCMD.put("help", "\nHELP\r\n" + "HELP [commande]\r\n"
				+ "\n  commande  Affiche des informations d'aide sur cette commande.\r\n");
		DETAILCMD.put("history", "\nHISTORY\r\n" + "\nAffiche un historique des 10 dernières commandes.\r\n");
		DETAILCMD.put("histclear", "\nHISTCLEAR\r\n" + "\nEfface le contenu de l'historique des commandes.\r\n");
		DETAILCMD.put("isprime", "\nISPRIME [nombre]\r\n"
				+ "\nAffiche \"yes\" si le nombre entré en paramètre est un nombre premier\r\nsinon affiche \"no\".\r\n");
		DETAILCMD.put("ls", "\nLS\r\n" + "\nAffiche les fichiers et les répertoires du répertoire en cours.\r\n");
		DETAILCMD.put("now",
				"\nNOM\r\n" + "NOW [-t] [-d] [-dt] [-td]\r\n"
						+ "\n      Sans paramètres affiche l'heure et la date.\r\n" + "  -t  Affiche l'heure.\r\n"
						+ "  -d  Affiche la date.\r\n");
		DETAILCMD.put("pwd", "En cours d'implémentation.\r\n");
		DETAILCMD.put("river",
				"\nRIVER [nombre][nombre]\r\n" + "\nAprès addition à eux-même de chacun des chiffres qui composent\r\n"
						+ "les nombres entrés en paramètres, affiche leur nombre commun s'ils se croisent.\r\n");
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

package com.cda.simulateur.tools;

public class Output {
	private static final String ANSI_GREEN = "\u001B[92m";
	private static final String ANSI_RESET = "\u001B[0m";

	public static void adresseCourante(String pAdresseCourante) {
		System.out.println(ANSI_GREEN + pAdresseCourante + ANSI_RESET);
		System.out.print("> ");
	}

	public static void syntaxeIncorrecte() {
		System.out.println("La syntaxe de la commande n’est pas correcte.");
	}

	public static void fichierIntrouvable() {
		System.out.println("Le fichier spécifié est introuvable.");
	}

	public static void copieFichierReussie() {
		System.out.println("1 fichier(s) copié(s).");
	}

	public static void copieFichierEchec() {
		System.out.println("0 fichier(s) copié(s).");
	}

	public static void creationFichierReussie() {
		System.out.println("1 fichier(s) créé(s).");
	}

	public static void creationFichierEchec() {
		System.out.println("Création impossible.");
	}

	public static void creationRepertoireReussie() {
		System.out.println("Répertoire créé.");
	}

	public static void creationRepertoireEchec() {
		System.out.println("Création répertoire impossible.");
	}

	public static void fichierExisteDeja(String pNomFichier) {
		System.out.println("Un sous-répertoire ou un fichier " + pNomFichier + " existe déjà.");
	}

	public static void nbreLignes(String pNomFichier, int pNbrLignes) {
		System.out.println(pNomFichier + " contient " + pNbrLignes);
	}

	public static void commandePasPriseEnCharge() {
		System.out.println("Cette commande n’est pas prise en charge par l’utilitaire d’aide.\n");
	}

	public static void introHelp() {
		System.out.println(
				"Pour plus d'informations sur une commande spécifique, entrez HELP\n" + "suivi de la commande.");
	}

	public static void sautLigne() {
		System.out.println("");
	}
}

package com.cda.simulateur.menu.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class History extends Command {
	public static final ArrayList<String> LISTCOMMAND = new ArrayList<>();
	private static DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("hh:mm:ss  dd-MM-yyyy");
	public static History HistoryInstance= new History();

	private History() {

	}

	public static History getHistory() {
		return HistoryInstance;
	}

	public static ArrayList<String> getListcommand() {
		return LISTCOMMAND;
	}

	public static void ajouterCmd(String pCmd) {
		if(!pCmd.equals("exit") || !pCmd.equals("help")) {
		LISTCOMMAND.add(pCmd + " " + LocalDateTime.now().format(vDateFormat));
		}
	}

	public void executer() {
		for (String string : LISTCOMMAND) {
			System.out.println(string);
		}
	}

	@Override
	public void executer(String... pSaisie) {
		
	}



}

/*
 * ajouter la commande "history" si la commande est égale à history , le
 * programme affiche la liste des 10 dernières commandes ( sans la commande
 * history ). Cette commande affiche ,en plus de la commande, les paramètres
 * passés à la commande et la date de l’exécution de la commande avec ce format
 * 11:40:22 03/10/2018.
 */
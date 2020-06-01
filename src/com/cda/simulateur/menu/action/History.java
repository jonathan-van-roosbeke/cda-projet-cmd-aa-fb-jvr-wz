package com.cda.simulateur.menu.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class History extends Command {

	public static final ArrayList<String> LISTCOMMAND = new ArrayList<>();
	private static DateTimeFormatter vDateFormat = DateTimeFormatter.ofPattern("hh:mm:ss  dd-MM-yyyy");
	public static History HistoryInstance = new History();
	private static int cmp;

	private History() {

	}

	public static History getHistory() {
		return HistoryInstance;
	}

	public static ArrayList<String> getListcommand() {
		return LISTCOMMAND;
	}

	public static void ajouterCmd(String pCmd) {
		if (pCmd.equals("exit") || pCmd.equals("help") || pCmd.equals("history") || pCmd.equals("histclear")) {

		} else {
			LISTCOMMAND.add(cmp, pCmd + " " + LocalDateTime.now().format(vDateFormat));
			cmp++;
		}
		if (cmp == 10) {
			cmp = 0;
		}
	}

	@Override
	public void executer() {
		for (String string : LISTCOMMAND) {
			System.out.println(string);
		}
	}

	@Override
	public void executer(String... pSaisie) {

	}

	public int getCmp() {
		return cmp;
	}
}

package com.cda.simulateur.tools;

import java.util.HashMap;
import java.util.Scanner;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.menu.action.Exit;
import com.cda.simulateur.menu.action.Help;
import com.cda.simulateur.menu.action.History;

public class Ihm {
	public static HashMap<String, Command> listCmd = new HashMap<>();
	private static Ihm ihmInstance = new Ihm();

	private Ihm() {
		listCmd.put("exit", Exit.exitInstance);
		listCmd.put("help", Help.help);
		listCmd.put("history", History.HistoryInstance);

	}

	public static HashMap<String, Command> getListCmd() {
		return listCmd;
	}

	public static void setListCmd(HashMap<String, Command> listCmd) {
		Ihm.listCmd = listCmd;
	}

	public static Ihm getIhmInstance() {
		return ihmInstance;
	}

	public static void setIhmInstance(Ihm ihmInstance) {
		Ihm.ihmInstance = ihmInstance;
	}

	public static Command getAllCommand(String pCmd) {
		return listCmd.get(pCmd);
	}

	public static void lancerMenu() {
		Scanner sc = new Scanner(System.in);
		String cmd;
		do {
			System.out.println("saisissez une cmd");
			cmd = sc.nextLine().toLowerCase();
			String[] test = cmd.split(" ");
			if (test.length == 1) {
				Ihm.getAllCommand(test[0]).executer();
				History.ajouterCmd(cmd);
			} else {
				Ihm.getAllCommand(test[0]).executer(test[1]);
				History.ajouterCmd(cmd);
			}
		} while (!Exit.exit);
		sc.close();
	}

}

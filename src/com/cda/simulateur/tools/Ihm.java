package com.cda.simulateur.tools;

import java.util.HashMap;
import java.util.Scanner;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.menu.action.Exit;
import com.cda.simulateur.menu.action.Help;
import com.cda.simulateur.menu.action.History;
import com.cda.simulateur.menu.action.HistoryClear;
import com.cda.simulateur.repertory.model.Cd;
import com.cda.simulateur.repertory.model.Ls;
import com.cda.simulateur.repertory.model.Pwd;

public class Ihm {
	public static HashMap<String, Command> listCmd = new HashMap<>();
	private final static Ihm ihmInstance = new Ihm();
	private Scanner scanner;
	private boolean interactif;
	private boolean afficherCommentaire;

	private Ihm() {
		listCmd.put("exit", Exit.exitInstance);
		listCmd.put("help", Help.help);
		listCmd.put("history", History.HistoryInstance);
		listCmd.put("pwd", Pwd.pwdInstance);
		listCmd.put("histclear", HistoryClear.HistoryClearInstance);
		listCmd.put("cd", Cd.cdInstance);
		listCmd.put("ls", Ls.lsInstance);

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

	public int lireEntier() {
		System.out.print("< ");
		int saisie = this.scanner.nextInt();
		if (!interactif) {
			System.out.print(saisie);
		}
		if (this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if (this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}

	public long lireLong() {
		System.out.print("< ");
		long saisie = this.scanner.nextLong();
		if (!interactif) {
			System.out.print(saisie);
		}
		if (this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if (this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}

	public float lireFloat() {
		System.out.print("< ");
		float saisie = this.scanner.nextFloat();
		if (!interactif) {
			System.out.print(saisie);
		}
		if (this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if (this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}

	public String lireMot() {
		System.out.print("< ");
		String saisie = this.scanner.next();
		if (!interactif) {
			System.out.print(saisie);
		}
		if (this.scanner.hasNextLine()) {
			String vComm = this.scanner.nextLine();
			if (this.afficherCommentaire) {
				System.out.print(vComm);
			}
		}
		System.out.println();
		return saisie;
	}

	public String lireLigne() {
		System.out.print("< ");
		String saisie = this.scanner.nextLine();
		if (!interactif) {
			System.out.println(saisie);
		}
		return saisie;
	}
}

package com.cda.simulateur.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.cda.exceptions.FileErrorException;
import com.cda.simulateur.file.model.copy.Copy;
import com.cda.simulateur.file.model.copy.Crd;
import com.cda.simulateur.file.model.copy.Crf;
import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.menu.action.Exit;
import com.cda.simulateur.menu.action.Help;
import com.cda.simulateur.menu.action.History;
import com.cda.simulateur.menu.action.HistoryClear;
import com.cda.simulateur.minijeux.IsPrime;
import com.cda.simulateur.minijeux.River;
import com.cda.simulateur.repertory.model.Cat;
import com.cda.simulateur.repertory.model.Cd;
import com.cda.simulateur.repertory.model.Count;
import com.cda.simulateur.repertory.model.Dir;
import com.cda.simulateur.repertory.model.Dirng;
import com.cda.simulateur.repertory.model.Find;
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
		listCmd.put("pwd", Pwd.vPwdInstance);
		listCmd.put("histclear", HistoryClear.HistoryClearInstance);
		listCmd.put("cd", Cd.cdInstance);
		listCmd.put("river", River.isRiverInstance);
		listCmd.put("isprime", IsPrime.isPrimeInstance);
		listCmd.put("ls", Ls.lsInstance);
		listCmd.put("dir", Dir.dirInstance);
		listCmd.put("dirng", Dirng.dirngInstance);
		listCmd.put("copy", Copy.copyInstance);
		listCmd.put("cat", Cat.catInstance);
		listCmd.put("find", Find.findInstance);
		listCmd.put("crf", Crf.crfInstance);
		listCmd.put("crd", Crd.crdInstance);
		listCmd.put("count", Count.countInstance);

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

	public static void lancerMenu() throws FileErrorException, IOException {
		Scanner sc = new Scanner(System.in);
		String cmd;
		do {
			System.out.println("saisissez une cmd");
			cmd = sc.nextLine().toLowerCase().trim();

			if (cmd.startsWith("cd.")) {
				String commande = cmd.substring(0, 2);
				String argument = cmd.substring(2);
				Ihm.getAllCommand(commande).executer(argument);
				History.ajouterCmd(commande);
			} else if (cmd.indexOf(" ") == -1) {
				Ihm.getAllCommand(cmd).executer();
				History.ajouterCmd(cmd);
			} else {
				String commande = cmd.substring(0, cmd.indexOf(" "));
				String arguments = cmd.substring(cmd.indexOf(" ") + 1).trim();
				if (verifierCmd(commande)) {
					Ihm.getAllCommand(commande).executer(arguments);
					History.ajouterCmd(commande);
				}
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

	private static boolean verifierCmd(String pCmd) {
		if (listCmd.containsKey(pCmd)) {
			return true;
		} else {
			System.out.println("La commande " + pCmd + " n'est pas encore implenté.");
			return false;
		}
	}
}

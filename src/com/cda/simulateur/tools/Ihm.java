package com.cda.simulateur.tools;

import java.util.Scanner;

public class Ihm {
	public static final Ihm IHM_INS = new Ihm();

	private Scanner scanner;
	private boolean interactif;
	private boolean afficherCommentaire;

	private Ihm() {
		this.interactif = Boolean.TRUE;
		this.scanner = new Scanner(System.in);
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

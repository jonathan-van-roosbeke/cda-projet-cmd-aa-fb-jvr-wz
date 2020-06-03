package com.cda.simulateur.file.model.copy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

public class Fline extends Command {
	public static Fline flineInstance = new Fline();

	public Fline() {
		super();

	}

	@Override
	public void executer() {

	}

	@Override
	public void executer(String... pSaisie) {
		String fichier;
		ArrayList<String> arrayText = null;
		String encours = "";
		int nbrLine = 0;
		String recherche;
		int debut = 0;
		int fin = 0;
		String arg = Utils.stringCleaner(pSaisie);
		String[] tabArgsSaisie = arg.split(" ");
		String[] argSwitch = { "-n", "-d", "-s", "-f" };
		List<String> arrayArgs = Arrays.asList(argSwitch);
		for (int i = 1; i < tabArgsSaisie.length; i++) {
			if (tabArgsSaisie[i].equals("-d") && tabArgsSaisie[i + 1].matches("^[0-9]+$") && i < tabArgsSaisie.length) {
				debut = Integer.parseInt(tabArgsSaisie[i + 1]);
			}
			if (tabArgsSaisie[i].equals("-f") && i < tabArgsSaisie.length - 1) {
				if (tabArgsSaisie[i + 1].matches("^[0-9]+$")) {
					fin = Integer.parseInt(tabArgsSaisie[i + 1]);
				}
			}
			if (tabArgsSaisie[i].equals("-s") && i < tabArgsSaisie.length) {
				recherche = tabArgsSaisie[i + 1];
			}
		}
		if (Utils.existFile(tabArgsSaisie[0])) {
			fichier = tabArgsSaisie[0];
		} else {
			System.out.println("Fichier introuvable.");
			return;
		}

		for (int i = 1; i < tabArgsSaisie.length; i++) {
			if (arrayArgs.contains(tabArgsSaisie[i])) {
				encours = tabArgsSaisie[i];

				switch (arrayArgs.indexOf(encours)) {
				case 0:
					if (tabArgsSaisie[1].equals("-n") && tabArgsSaisie.length == 2) {
						System.out.println("Le nombre de ligne du fichier est de : " + nbreLigne(fichier));

						break;
					} else {
						System.out.println("Saisi incorrect");
						return;
					}
				case 1:
					fin = fin == 0 ? nbreLigne(fichier) : fin;
					lireFichierAPartirDe(fichier, debut, fin);
					break;
				case 2:
					for (String string : lireFichierAvecRecherche(fichier, tabArgsSaisie[i + 1])) {
						System.out.println(string);
					}

					break;
				default:
					break;
				}
			}
		}
	}

	private static int nbreLigne(String pFichier) {
		String str;
		int nbreLigne = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(pFichier))) {
			while ((str = br.readLine()) != null) {
				nbreLigne++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nbreLigne;
	}

	private static void lireFichier(String pFichier) {
		String str;
		int nbreLigne = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(pFichier))) {
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> lireFichierAvecRecherche(String pFichier, String Precherche) {
		ArrayList<String> listRecup = new ArrayList<>();
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader(pFichier))) {
			while ((str = br.readLine()) != null) {
				if (str.contains(Precherche)) {
					listRecup.add(str);
				}

			}
			if (str == null) {
				System.out.println("Aucune correspondance");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listRecup;
	}

	public static void lireFichierAPartirDe(String pFichier, int pDebut, int pFin) {
		String str;
		int compteur = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(pFichier))) {
			while ((str = br.readLine()) != null) {
				compteur++;
				if (compteur >= pDebut && compteur <= pFin) {
					System.out.println(str);

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.cda.simulateur.file.model.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Output;
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
		String str;
		int nbrLignes = 0;
		String arg = Utils.stringCleaner(pSaisie);
		String[] args = arg.split(" ");
		File file = new File(args[0]);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((str = br.readLine()) != null) {
				if (str.contains("urna")) {
					System.out.println(str);
				}
				nbrLignes++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Output.nbreLignes(pSaisie[0], nbrLignes);
	}

	public static int verifArgs(String... pSaisie) {
		String[] argSwitch = { "-n", "-d", "-f", "-g" };
		List<String> arrayArgs = Arrays.asList(argSwitch);
		String arg = Utils.stringCleaner(pSaisie);
		String[] args = arg.split(" ");

		return 0;
	}

	public static void traitementString(String pSaisie) {
		String[] pSaisieSplit = pSaisie.split(" ");
		String opt1 = pSaisieSplit[2];
		String opt2 = pSaisieSplit[3];

	}

	/*
	 * ajouter la commande "fline" qui fait des traitements sur un fichier ligne par
	 * ligne : format : fline nomFichier -option1 -option2 ... fline est toujours
	 * suivi du nom d'un fichier, sinon erreur syntaxe -n : affiche le nombre de
	 * lignes, ne peut pas être utilisé en même temps qu'une autre option. -d :
	 * permet de définir le numéro de ligne à partir duquel le traitement va être
	 * fait (inclus). -f : permet de définir le numéro de ligne jusqu'auquel le
	 * traitement va être fait (inclus). -g : permet de chercher un string dans une
	 * ligne, peut être utilisé avec les options -d et -f exemple : > cat
	 * fichier.txt contenu l1 contenu l2 contenu l3 > fline fichier.txt contenu l1
	 * contenu l2 contenu l3 > fline fichier.txt -n 3 lignes > fline fichier.txt -d
	 * l1 contenu l1 > fline fichier.txt -g l contenu l1 contenu l2 contenu l3 >
	 * fline fichier.txt -g l -d 2 contenu l2 contenu l3 > fline fichier.txt -g l -f
	 * 2 -d 1 contenu l1 contenu l2
	 */
}

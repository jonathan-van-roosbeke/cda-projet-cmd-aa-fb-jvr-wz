package com.cda.simulateur.file.model.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		String str;
		int nbrLine = 0;
		String arg = Utils.stringCleaner(pSaisie);
		String[] args = arg.split(" ");
		File file = new File(args[0]);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		try {
			while ((str = br.readLine()) != null) {
				nbrLine++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nombre de lignes dans le fichier : " + nbrLine);
	}

	public static int verifArgs(String... pSaisie) {
		String[] argSwitch = { "-n", "-d", "-f", "-g" };
		List<String> arrayArgs = Arrays.asList(argSwitch);
		String arg = Utils.stringCleaner(pSaisie);
		String[] args = arg.split(" ");

		return 0;
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

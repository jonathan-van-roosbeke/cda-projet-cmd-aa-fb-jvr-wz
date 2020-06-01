package com.cda.simulateur.minijeux;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

/**
 * Classe <b>IsPrime</b> qui teste si le nombre entré en paramètre est premier
 * ou pas.
 *
 * @return ne retourne rien.
 * @param prend en paramètre un var-args qui contient un String récupéré depuis
 *              "Ihm.lancerMenu()". Ce paramètre est splité puis ce String
 *              numérique est converti en Int.
 * @exception lève une exception si le var-args passé en argument est vide ou
 *                 n'est pas de type numérique.
 */

public class IsPrime extends Command {
	public static IsPrime isPrimeInstance = new IsPrime();

	private IsPrime() {
		super();
	}

	@Override
	public void executer(String... pArg) {
		String nbreSaisi = Utils.stringCleaner(pArg);
		String[] test = nbreSaisi.split(" ");
		boolean prime = true;

		Pattern p = Pattern.compile("\\D");
		Matcher m = p.matcher(nbreSaisi);

		if (pArg[0] == "" || test.length != 1 || m.find()) {
			System.out.println("isprime prends un seul paramètre qui doit être un entier positif et compris entre 0 et "
					+ Long.MAX_VALUE);
		} else {
			Long n = (long) 0;
			if (n < 0) {
				System.out.println(n + " n'est pas un entier positif");
			} else {
				try {
					n = Long.parseLong(nbreSaisi);
				} catch (NumberFormatException nfe) {
					System.out.println(n + " est trop grand. Saisir un nombre entre 0 et " + Long.MAX_VALUE);
					prime = false;
				}

				boolean bool = false;
				String result = n + " n'est pas un nombre premier";
				if (n <= 1) {
				} else {
					for (long i = 2; i * i <= n; i++) {
						if (n % i == 0) {
							bool = true;
						}
					}
					if (!bool) {
						result = n + " est un nombre premier";
					}
				}
				if (prime) {
					System.out.println(result);
				}
			}
		}
	}

	@Override
	public void executer() {
		executer("");
	}
}
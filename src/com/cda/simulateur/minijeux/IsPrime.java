package com.cda.simulateur.minijeux;

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

		if (pArg[0] == "" || test.length != 1) {
			System.out.println("isprime prends un entier en paramètre");
		} else {
			int n = 0;

			try {
				n = Integer.parseInt(nbreSaisi);
			} catch (NumberFormatException nfe) {
				System.out.println(nbreSaisi + " n'est pas un entier");
				prime = false;
			}

			boolean bool = false;
			String result = "n'est pas un nombre premier";
			if (n <= 1) {
			} else {
				for (long i = 2; i * i <= n; i++) {
					if (n % i == 0) {
						bool = true;
					}
				}
				if (!bool) {
					result = "est un nombre premier";
				}
			}
			if (prime) {
				System.out.println(result);
			}
		}
	}

	@Override
	public void executer() {
		executer("");
	}
}
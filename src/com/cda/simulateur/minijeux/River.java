package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

/**
 * Classe <b>River</b> qui teste à quel moment deux nombres entrés en paramètre
 * se rejoignent ou pas, en additionant à eux-mêmes, chacun de leurs chiffres
 * entre eux.
 * 
 * @return ne retourne rien.
 * @param prend en paramètre un String. Ce paramètre est splité puis chacun des
 *              deux Strings numériques sont convertis en Int.
 * @exception lève une exception si le var-args passé en argument est vide ou
 *                 n'est pas de type numérique.
 *
 */

public class River extends Command {
	public static River isRiverInstance = new River();

	private River() {
		super();
	}

	@Override
	public void executer(String... pArg) {
		if (pArg[0].equals("")) {
			System.out.println("river prends 2 entiers en paramètres");
		} else {
			String result = Utils.stringCleaner(pArg);
			String[] test = result.split(" ");

			if (test.length != 2) {
				System.out
						.println(test.length < 2 ? "Nombre de paramètre incorrect" : "Nombre de paramètres incorrects");
			} else {
				String strTempA = test[0];
				String strTempB = test[1];
				int intTempA = 0;
				int intTempB = 0;
				int compteur = 0;
				boolean river = true;

				try {
					intTempA = Integer.parseInt(strTempA);
				} catch (NumberFormatException nfe) {
					System.out.println(strTempA + " n'est pas un entier");
					river = false;
				}

				try {
					intTempB = Integer.parseInt(strTempB);
				} catch (NumberFormatException nfe) {
					System.out.println(strTempB + " n'est pas un entier");
					river = false;
				}

				while (intTempA != intTempB && river) {
					if (intTempA > intTempB) {
						for (char i : strTempB.toCharArray()) {
							intTempB += Character.getNumericValue(i);
						}
					} else {
						for (char i : strTempA.toCharArray()) {
							intTempA += Character.getNumericValue(i);
						}
					}
					strTempA = String.valueOf(intTempA);
					strTempB = String.valueOf(intTempB);
					compteur++;
					if (compteur == 5000000) {
						result = ("délai expiré");
						return;
					}

					if (intTempA == intTempB) {
						river = false;
						System.out.println(strTempA);
					}
				}
			}
		}
	}

	@Override
	public void executer() {
		executer("");
	}

}
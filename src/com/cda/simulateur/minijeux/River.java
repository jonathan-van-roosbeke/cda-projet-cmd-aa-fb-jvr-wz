package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Utils;

public class River extends Command {
	public static River isRiverInstance = new River();

	private River() {
		super();
	}

	@Override
	public void executer(String... pArg) {
		String result = Utils.stringCleaner(pArg);

		String[] test = result.split(" ");

		String strTempA = test[0];
		String strTempB = test[1];

		int intTempA = Integer.parseInt(strTempA);
		int intTempB = Integer.parseInt(strTempB);
		int compteur = 0;

		while (intTempA != intTempB) {

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
				System.out.println("délai expiré");
				return;
			}
		}
		System.out.println(strTempA);
	}

	@Override
	public void executer() {
	}
}
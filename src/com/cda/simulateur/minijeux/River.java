package com.cda.simulateur.minijeux;

import static com.cda.simulateur.tools.Ihm.IHM_INS;

import com.cda.simulateur.menu.action.Command;

public class River extends Command {
	private static final String ID = "river";
	private static final String DESC = "Affiche la première intersection des rivières";
	private static String pArgs = 

	River(String pArgs) {
		super(ID, DESC);
	}

	public void executer() {
		String r1 = IHM_INS.lireMot();
		String r2 = IHM_INS.lireMot();

		while (r1 != r2) {
			if (r1 > r2) {
				for (char i : r2.toCharArray()) {
					r2 += Character.getNumericValue(i);
				}
			} else {
				for (char i : r1.toCharArray()) {
					r1 += Character.getNumericValue(i);
				}
			}
		}
		System.out.println(r1);
	}
}
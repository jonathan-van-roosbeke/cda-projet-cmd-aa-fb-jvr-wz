package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;

public class River extends Command {

	River() {
		super();
	}

	public void executer(String r1, String r2) {

		while (r1 != r2) {
			if (r1 > r2) {
				for (char i : Long.toString(r2).toCharArray()) {
					r2 += Character.getNumericValue(i);
				}
			} else {
				for (char i : Long.toString(r1).toCharArray()) {
					r1 += Character.getNumericValue(i);
				}

			}
		}
		System.out.println(r1);
	}

	@Override
	public void executer(String... pSaisie) {

	}

	@Override
	public void executer() {
		// TODO Auto-generated method stub

	}
}

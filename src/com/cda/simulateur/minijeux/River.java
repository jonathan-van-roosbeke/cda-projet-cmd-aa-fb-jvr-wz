package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;

public class River extends Command {
	private static String pArgA = "";
	private static String pArgB = "";

	public River(String pArg) {
		super();

		try {
			String[] temp = pArg.split(" ");
			this.pArgA = temp[0];
			this.pArgB = temp[1];
		} catch (Exception e) {
			System.out.println("erreur de saisie");
		}
	}

	@Override
	public void executer() {
		String strTempA = pArgA;
		String strTempB = pArgB;
		int intTempA = Integer.parseInt(pArgA);
		int intTempB = Integer.parseInt(pArgB);

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
		}
		System.out.println(strTempA);
	}

	@Override
	public void executer(String... pSaisie) {
	}
}
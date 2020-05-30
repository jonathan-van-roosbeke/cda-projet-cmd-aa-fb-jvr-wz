package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;

public class IsPrime extends Command {
	public static IsPrime isPrimeInstance = new IsPrime();

	private IsPrime() {
		super();
	}

	public static void executer(String pArg) {
//		String[] temp = pArg.split(" ");
//		String strTempA = temp[1];
	}

	@Override
	public void executer(String... pSaisie) {

		int n = Integer.parseInt(pSaisie[0]);
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
		System.out.println(result);
	}

	@Override
	public void executer() {
	}
}

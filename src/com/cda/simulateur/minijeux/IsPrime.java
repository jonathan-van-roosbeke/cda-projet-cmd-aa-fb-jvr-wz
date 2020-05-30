package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;

public class IsPrime extends Command {
	private static String pArg = "";

	public IsPrime(String pArg) {
		super();

		try {
			this.pArg = pArg;
		} catch (Exception e) {
			System.out.println("erreur de saisie");
		}
	}

	@Override
	public void executer() {
		int n = Integer.parseInt(pArg);

		boolean bool = false;
		String result = " n'est pas premier";
		if (n <= 1) {
		} else {
			for (long i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					bool = true;
				}
			}
			if (!bool) {
				result = " est premier";
			}
		}
		System.out.println(result);
	}

	@Override
	public void executer(String... pSaisie) {

	}
}
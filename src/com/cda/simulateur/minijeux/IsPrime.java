package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.tools.Ihm;

public class IsPrime extends Command {
	IsPrime() {
		super();
	}

	@Override
	public void executer() {
		long n = Ihm.getIhmInstance().lireLong();
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

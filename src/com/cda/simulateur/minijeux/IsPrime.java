package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;
import static com.cda.simulateur.tools.Ihm.IHM_INS;

public class IsPrime extends Command {
	private static final String ID = "isprime";
	private static final String DESC = "Vérifier si le nombre est premier";
	
	IsPrime() {
		super(ID, DESC);
	}

	protected IsPrime(String pId, String pDescription) {
		super(pId, pDescription);
	}

	@Override
	public void executer() {
		long n = IHM_INS.lireLong();
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
}
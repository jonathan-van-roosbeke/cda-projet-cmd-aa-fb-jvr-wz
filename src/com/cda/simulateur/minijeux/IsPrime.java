package com.cda.simulateur.minijeux;

import com.cda.simulateur.menu.action.Command;
import static com.cda.simulateur.tools.Ihm.IHM_INS;

public class IsPrime extends Command {

	@Override
	public boolean executer() {
		long n = IHM_INS.lireLong();
		if (n <= 1) {
			return false;
		} else {
			for (long i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
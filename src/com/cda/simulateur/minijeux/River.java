package com.cda.simulateur.minijeux;

import static com.cda.simulateur.tools.Ihm.IHM_INS;

import com.cda.simulateur.menu.action.Command;

public class River extends Command {

	public boolean executer() {
		long r1 = IHM_INS.lireLong();
		long r2 = IHM_INS.lireLong();

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
			System.out.println(r1);
		}
		return Boolean.TRUE;
	}
}
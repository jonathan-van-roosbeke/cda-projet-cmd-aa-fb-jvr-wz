package com.cda.simulateur.prog;

import com.cda.simulateur.menu.action.Now;
import com.cda.simulateur.tools.Ihm;

public class ProgrammeSimulateurConsole {

	public static void main(String[] args) {
		String proprieteLancement = System.getProperty("cdi.default.folder");

		if (proprieteLancement != null) {
			System.setProperty("user.dir", proprieteLancement);
		}
		Now.nowInstance.executer("-t-t");
		Ihm.lancerMenu();
	}
}

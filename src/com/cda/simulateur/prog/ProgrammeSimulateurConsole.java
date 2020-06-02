package com.cda.simulateur.prog;

<<<<<<< HEAD
import com.cda.simulateur.menu.action.Now;
=======
import java.io.File;

>>>>>>> dev
import com.cda.simulateur.tools.Ihm;

public class ProgrammeSimulateurConsole {

	public static void main(String[] args) {
		String proprieteLancement = System.getProperty("cdi.default.folder");
		File testFichier = new File(proprieteLancement);

		if (proprieteLancement != null && testFichier.exists()) {
			if (!(testFichier.isFile())) {
				System.setProperty("user.dir", proprieteLancement);
			}
		}
<<<<<<< HEAD
		Now.nowInstance.executer("ts");
=======
>>>>>>> dev
		Ihm.lancerMenu();
	}
}

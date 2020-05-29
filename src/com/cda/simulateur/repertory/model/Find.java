package com.cda.simulateur.repertory.model;

import com.cda.simulateur.menu.action.Command;

public class Find extends Command {
	private static final String ID = "find";
	private static final String DESC = "Liste tous les fichiers dans le répertoire en cours";
	
	Find() {
		super(ID, DESC);
	}

	@Override
	public void executer() {
	}
}

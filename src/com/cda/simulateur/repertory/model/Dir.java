package com.cda.simulateur.repertory.model;

import com.cda.simulateur.menu.action.Command;

public class Dir extends Command {
	private static final String ID = "dir";
	private static final String DESC = "Affiche le contenu de C:\\";
	
	Dir() {
		super(ID, DESC);
	}
	@Override
	public void executer() {
	}

}

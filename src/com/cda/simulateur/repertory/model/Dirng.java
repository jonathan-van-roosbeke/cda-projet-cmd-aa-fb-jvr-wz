package com.cda.simulateur.repertory.model;

import com.cda.simulateur.menu.action.Command;

public class Dirng extends Command {
	private static final String ID = "dirng";
	private static final String DESC = "Affiche le contenu du répertoire en cours et liste les fichiers";
	
	Dirng() {
		super(ID, DESC);
	}

	@Override
	public void executer() {
	}
}

package com.cda.simulateur.file.model.copy;

import com.cda.simulateur.menu.action.Command;

public class Crd extends Command {
	private static final int ID = 4;
	private static final String DESC = "Crée un répertoire avec ce nom dans le répertoire en cours";
	
	Crd() {
		super(ID, DESC);
	}
	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		return false;
	}

}

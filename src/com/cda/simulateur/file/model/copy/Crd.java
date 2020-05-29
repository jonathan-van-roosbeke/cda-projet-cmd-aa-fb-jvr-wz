package com.cda.simulateur.file.model.copy;

import java.io.File;

import com.cda.simulateur.menu.action.Command;

public class Crd extends Command {
	private static final String ID = "crd";
	private static final String DESC = "Crée un répertoire avec ce nom dans le répertoire en cours";
	
	Crd() {
		super(ID, DESC);
	}
	
	@Override
	public void executer() {
		File vRep = new File(description);
		
	}
}

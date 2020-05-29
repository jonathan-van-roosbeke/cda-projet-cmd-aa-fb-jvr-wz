package com.cda.simulateur.file.model.copy;

import java.io.File;

import com.cda.simulateur.menu.action.Command;

public class Crd extends Command {
	private static final String ID = "crd";
	private static final String DESC = "Cr�e un r�pertoire avec ce nom dans le r�pertoire en cours";

	Crd() {
		super(ID, DESC);
	}

	@Override
	public void executer() {
		File vRep = new File(description);
	}
}
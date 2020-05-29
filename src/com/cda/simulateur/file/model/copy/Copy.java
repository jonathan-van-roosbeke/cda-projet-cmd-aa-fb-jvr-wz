package com.cda.simulateur.file.model.copy;

import com.cda.simulateur.menu.action.Command;

public class Copy extends Command {
	private static final String ID = "copy";
	private static final String DESC = "Copie un fichier";

	Copy() {
		super(ID, DESC);
	}

	@Override
	public void executer() {
	}
}
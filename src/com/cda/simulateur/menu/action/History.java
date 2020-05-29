package com.cda.simulateur.menu.action;

public class History extends Command {
	private static final String ID = "history";
	private static final String DESC = "Liste les dernières commandes tapées";
	
	History() {
		super(ID, DESC);
	}
	
	@Override
	public void executer() {
		
	}
}

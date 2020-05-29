package com.cda.simulateur.menu.action;

public class HistoryClear extends Command {
	private static final String ID = "histclear";
	private static final String DESC = "Efface les dernières commandes tapées";
	
	HistoryClear() {
		super(ID, DESC);
	}
	
	@Override
	public void executer() {
	}
}

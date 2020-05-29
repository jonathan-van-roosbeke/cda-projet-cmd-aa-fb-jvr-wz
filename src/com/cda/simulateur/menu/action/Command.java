package com.cda.simulateur.menu.action;

public abstract class Command extends Action {
	protected Command(String pId, String pDescription) {
		super(pId, pDescription);
	}
	
	@Override
	public void executer() {
	}
}
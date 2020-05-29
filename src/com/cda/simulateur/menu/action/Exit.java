package com.cda.simulateur.menu.action;

public class Exit extends Command {
	public static boolean exit = false;
	public static Exit exitInstance= new Exit();
	
	
	public Exit() {
		super();

	}

	public void executer() {
		exit = true;
	}

	@Override
	public String toString() {
		return "Merci au revoir";
	}

	@Override
	public void executer(String... pSaisie) {
		
	}
}

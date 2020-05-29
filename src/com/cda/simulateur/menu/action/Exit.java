package com.cda.simulateur.menu.action;

public class Exit extends Command {
	public static boolean exit = false;
	private static final String ID = "exit";
	private static final String DESC = "Quitter la console";

	Exit() {
		super(ID, DESC);
	}

	@Override
	public void executer() {
		exit = true;
	}

//	public String toString() {
//		return "Merci au revoir";
//	}
}

package com.cda.simulateur.repertory.model;

import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;

public final class Cd extends Command {

	public static void changeDirectory(String pCommande) {
		if(pCommande.equals("..") || pCommande.equalsIgnoreCase("cd..") && Pwd.vCheminArray.size() > 1) {
			Pwd.vCheminArray.remove(Pwd.vCheminArray.size() - 1);
		} else if(pCommande.equals(".")) {
			
		} else {
			List<String> temp = Arrays.asList(pCommande.split("\\\\"));
			for(String s : temp) {
				Pwd.vCheminArray.add(s);
			}
		}
	}

	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		return false;
	}
}

package com.cda.simulateur.repertory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;

public final class Pwd extends Command {

	private static final String vCheminDeDebut = System.getProperty("user.dir");
	protected static List<String> vCheminArray = new ArrayList<>(Arrays.asList(vCheminDeDebut.split("\\\\")));
	
	// retourne le chemin du repertoire courant
	public String executer() {
		StringBuilder sb = new StringBuilder();
		for(String s : vCheminArray) {
			sb.append(s);
			sb.append("\\");
		}
		return sb.toString().substring(0, sb.length()-1);
	}
}

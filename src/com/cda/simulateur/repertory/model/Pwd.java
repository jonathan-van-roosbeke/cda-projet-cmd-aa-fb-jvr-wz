package com.cda.simulateur.repertory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;

public final class Pwd extends Command {
	private static final String vCheminDeDebut = System.getProperty("user.dir");
	protected static List<String> vCheminArray = new ArrayList<>(Arrays.asList(vCheminDeDebut.split("\\\\")));
	public static String adressCourante = vCheminDeDebut;
	private static final String ID = "pwd";
	private static final String DESC = "Affiche le dossier courant";
	
	Pwd() {
		super(ID, DESC);
	}
	
	@Override
	public void executer() {
		StringBuilder sb = new StringBuilder();
		for(String s : vCheminArray) {
			sb.append(s);
			sb.append("\\");
		}
		Pwd.setAdressCourante(sb.toString());
		System.out.println(vCheminArray);
		System.out.println(adressCourante);
	}
	
	public static String getAdressCourante() {
		return adressCourante;
	}
	public static void setAdressCourante(String adressCourante) {
		Pwd.adressCourante = adressCourante;
	}
}


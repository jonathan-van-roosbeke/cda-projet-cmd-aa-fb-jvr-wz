package com.cda.simulateur.repertory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.menu.action.Command;

public final class Pwd extends Command {
	private static final String vCheminEnCours = System.getProperty("user.dir");
	protected static List<String> vCheminArray = new ArrayList<>(Arrays.asList(vCheminEnCours.split("\\\\")));
	public static String adressCourante = vCheminEnCours;
	public final static Pwd pwdInstance = new Pwd();

	private Pwd() {
		super();
	}

	// retourne le chemin du repertoire courant

	public static Pwd getPwdinstance() {
		return pwdInstance;
	}

	@Override
	public void executer() {

		StringBuilder sb = new StringBuilder();
		for (String s : vCheminArray) {
			sb.append(s);
			sb.append("\\");
		}
		Pwd.setAdressCourante(sb.toString());
		System.out.println(adressCourante);
	}

	public static String getAdressCourante() {
		return adressCourante;
	}

	public static void setAdressCourante(String adressCourante) {
		Pwd.adressCourante = adressCourante;
	}

	@Override
	public void executer(String... pSaisie) {

	}
}

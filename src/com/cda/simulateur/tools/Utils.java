package com.cda.simulateur.tools;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cda.simulateur.repertory.model.Pwd;

public class Utils {
	public static void executer() {
		File curDir = new File(Pwd.getAdressCourante());
		File[] filesList = curDir.listFiles();
		for (File f : filesList) {
			System.out.println(f.getName());
		}
		System.out.println();
	}

	public static String stringCleaner(String[] pArg) {
		String commande = pArg[0];
		String regex = "\\s+";
		String result = commande.replaceAll(regex, " ").trim();
		return result;
	}

	public static String stringCleaner(String pArg) {
		String commande = pArg;
		String regex = "\\s+";
		String result = commande.replaceAll(regex, " ").trim();
		return result;
	}

	public static void copieContenu(String pIn, String pOut) throws IOException {
		int c;
		FileReader in = new FileReader(pIn);
		FileWriter out = new FileWriter(pOut);
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
	}

	public static boolean verifSaisieNombre(String pSaisie) {
		Pattern p = Pattern.compile("\\D");
		Matcher m = p.matcher(pSaisie);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static void environnement() {
		Map<String, String> varEnv = System.getenv();
		for (String varEnvNom : varEnv.keySet()) {
			System.out.format("%s = %s%n", varEnvNom, varEnv.get(varEnvNom));
		}
	}

	public static void jvm() {
		Map<Object, Object> propJvm = System.getProperties();
		for (Object propJvmNom : propJvm.keySet()) {
			if (!(Utils.stringCleaner(System.getProperty((String) propJvmNom)).isEmpty())) {
				System.out.format("%s = %s%n", propJvmNom, System.getProperty((String) propJvmNom));
			}
		}
	}
}
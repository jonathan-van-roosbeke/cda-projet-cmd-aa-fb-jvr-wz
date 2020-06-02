package com.cda.simulateur.tools;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
		Map<String, String> properties = System.getenv();

		LinkedHashMap<String, String> collect = properties.entrySet().stream()
				.collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue())).entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		collect.forEach((k, e) -> System.out.format("%-32s = %s%n", k, e));
	}

	public static void jvm() {
		Properties properties = System.getProperties();

		LinkedHashMap<String, String> collect = properties.entrySet().stream()
				.collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue())).entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		collect.forEach((k, e) -> System.out.format("%-32s = %s%n", k, e));
	}

}
package com.cda.simulateur.menu.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.cda.simulateur.tools.Utils;

public class Now extends Command {
	private static DateTimeFormatter vDateFormatHeure = DateTimeFormatter.ofPattern("hh:mm:ss");
	private static DateTimeFormatter vDateFormatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static Now nowInstance = new Now();

	private Now() {
		super();

	}

	@Override
	public void executer() {

	}

	@Override
	public void executer(String... pSaisie) {
		switch (verifArgs(pSaisie)) {
		case -1:
			System.out.println("il est temps d'aller dormir");
			break;
		case 0:
			System.out.println(LocalDateTime.now().format(vDateFormatHeure));
			break;
		case 1:
			System.out.println(LocalDateTime.now().format(vDateFormatDate));
			break;
		case 3:
			System.out.println(
					LocalDateTime.now().format(vDateFormatHeure) + " " + LocalDateTime.now().format(vDateFormatDate));
			break;
		case 4:
			System.out.println(
					LocalDateTime.now().format(vDateFormatHeure) + " " + LocalDateTime.now().format(vDateFormatDate));
			break;
		default:
			break;
		}
	}

	public static int verifArgs(String... pSaisie) {
		String[] argSwitch = { "-d", "-t", "-dt", "-td" };
		List<String> arrayArgs = Arrays.asList(argSwitch);
		String arg = Utils.stringCleaner(pSaisie);
		String[] args = arg.split(" ");

		return arrayArgs.indexOf(args[0]);
	}
}

/*
 * "now" affiche l'heure et/ou la date système.
 * 
 * now affiche "il est grand temps d'aller dormir ! " now -d 11:42:22 now -t
 * 03/10/2020 now -dt 11:42:22 03/10/2020 now -td 11:42:22 03/10/2020 now -t -d
 * 11:42:22 03/10/2020 now -d -t 11:42:22 03/10/2020 now -r unknown option -r
 * now -ty unknow option -y
 */
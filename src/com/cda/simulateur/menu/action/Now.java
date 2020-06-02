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

		if (pSaisie[0].startsWith("-")) {
			String encours = "";

			String test = pSaisie[0];
			Character[] argSwitch = { 'd', 't' };
			List<Character> arrayArgs = Arrays.asList(argSwitch);
			test = Utils.removeDuplicateCharacter(test).replace("-", "");
			for (int i = 0; i < test.length(); i++) {
				if (arrayArgs.contains(test.charAt(i))) {

				} else {
					encours += test.charAt(i);
				}

			}
			if (encours.equals("")) {
				for (int i = 0; i < test.length(); i++) {
					char charEncour = test.charAt(i);
					switch (arrayArgs.indexOf(charEncour)) {

					case 0:
						System.out.print(LocalDateTime.now().format(vDateFormatDate) + " ");
						break;
					case 1:
						System.out.print(LocalDateTime.now().format(vDateFormatHeure) + " ");
						break;

					default:
						break;
					}
				}
			} else {
				System.out.println(" unknown option -" + encours);
			}
			System.out.println();

		} else {
			System.out.println("l'option doit commencer par - ");
		}
	}
}

/*
 * "now" affiche l'heure et/ou la date système.
 * 
 * now affiche "il est grand temps d'aller dormir ! " now -d 11:42:22 now -t
 * 03/10/2020 now -d -t 11:42:22 03/10/2020 now -t -
 * 
 * d 11:42:22 03/10/2020 now -t -d 11:42:22 03/10/2020 now -d -t 11:42:22
 * 03/10/2020 now -r unknown option -r now -ty unknow option -y
 */
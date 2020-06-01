package com.cda.simulateur.repertory.model;

import java.io.File;

import com.cda.simulateur.menu.action.Command;

public class Ls extends Command {

	public final static Ls lsInstance = new Ls();

	private static Ls getLsInstance() {
		return lsInstance;
	}

	@Override
	public void executer() {
		File vFolder = new File(Pwd.getAdressCourante());
		File[] vFilesList = vFolder.listFiles();
		for (File f : vFilesList) {
			if (f.isDirectory()) {
				System.out.println("<DIR>   " + f.getName());
			} else {
				System.out.println("<FILE>  " + f.getName());
			}
		}
		System.out.println();
	}

	@Override
	public void executer(String... pSaisie) {
		// TODO Auto-generated method stub
	}
}
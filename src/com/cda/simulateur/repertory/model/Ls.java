package com.cda.simulateur.repertory.model;

import java.io.File;

public class Ls {

	// liste les documents et fichier du repertoire courant
	public static void executer() {
		File curDir = new File(Pwd.executer());
		File[] filesList = curDir.listFiles();
        for(File f : filesList){
            System.out.println(f.getName());
        }
        System.out.println();
	}
	
}

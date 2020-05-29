package com.cda.simulateur.tools;

import java.io.File;

import com.cda.simulateur.repertory.model.Pwd;

public class Utils {
	public static void executer() {
		File curDir = new File(Pwd.getAdressCourante());
		File[] filesList = curDir.listFiles();
        for(File f : filesList){
            System.out.println(f.getName());
        }
        System.out.println();
	}
}
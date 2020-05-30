package com.cda.simulateur.file.model.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.cda.exceptions.FileErrorException;
import com.cda.simulateur.menu.action.Command;

public class Copy extends Command {

	public static void copy(String args) throws FileErrorException, IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		if (args.length() == 0) {
			throw new FileErrorException("Il n'y pas de argument");
		} else {
			File srcFile = new File(args);
			String fileName = args;
			String destName;
			File destFile;
			if (fileName.indexOf('.') == -1) {
				destName = fileName + "-2";
				destFile = new File(destName);
			} else {
				fileName = args.substring(0, args.lastIndexOf('.'));
				String ext = args.substring(args.indexOf('.'));
				destFile = new File(fileName + "-2" + ext);
			}
			if (srcFile.exists() && destFile.exists()) {
				fis = new FileInputStream(srcFile);
				fos = new FileOutputStream(destFile);

				byte[] buf = new byte[1024];
				int len;
				while ((len = fis.read(buf)) != -1) {
					fos.write(buf, 0, len);
				}
				System.out.println("C'est reussie");
			} else {
				throw new FileErrorException("Le fichier n'existe pas");
			}
//			System.out.println("Fichier introuvable");
			if (fos != null)
				fos.close();
			if (fis != null)
				fis.close();
		}

	}

	@Override
	public void executer(String... pSaisie) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executer() {
		// TODO Auto-generated method stub

	}
}

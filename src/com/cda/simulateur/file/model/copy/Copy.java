package com.cda.simulateur.file.model.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.cda.simulateur.menu.action.Command;
import com.cda.simulateur.repertory.model.Pwd;

public class Copy extends Command {
	public static Copy copyInstance = new Copy();

	Copy() {
	}

	@Override
	public void executer(String... pSaisie) {
		System.getProperty("user.dir");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		if (pSaisie[0].indexOf(" ") != -1) {
			System.out.println("L'argument n'est pas correct");
		}

		try {
			Pwd.setAdressCourante(Pwd.getAdressCourante());
			File srcFile = new File(Pwd.getAdressCourante() + "/" + pSaisie[0]);
			String fileName = pSaisie[0];
			String destName;
			File destFile;
			if (fileName.indexOf('.') == -1) {
				destName = fileName + "-2";
				destFile = new File(Pwd.getAdressCourante() + "/" + destName);
			} else {
				fileName = pSaisie[0].substring(0, pSaisie[0].lastIndexOf('.'));
				String ext = pSaisie[0].substring(pSaisie[0].indexOf('.'));
				destFile = new File(Pwd.getAdressCourante() + "/" + fileName + "-2" + ext);
			}
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void executer() {
		System.out.println("Manque argument");
	}
}

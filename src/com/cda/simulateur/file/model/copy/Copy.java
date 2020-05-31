package com.cda.simulateur.file.model.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.cda.exceptions.FileErrorException;
import com.cda.simulateur.menu.action.Command;

public class Copy extends Command {
	public static Copy copyInstance = new Copy();

	Copy() {
	}

	@Override
	public void executer(String... pSaisie) throws FileErrorException, IOException {
		System.getProperty("user.dir");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		if (pSaisie[0].indexOf(" ") != -1) {
			throw new FileErrorException("L'argument n'est pas correct");
		}

		File srcFile = new File(pSaisie[0]);
		String fileName = pSaisie[0];
		String destName;
		File destFile;
		if (fileName.indexOf('.') == -1) {
			destName = fileName + "-2";
			destFile = new File(destName);
		} else {
			fileName = pSaisie[0].substring(0, pSaisie[0].lastIndexOf('.'));
			String ext = pSaisie[0].substring(pSaisie[0].indexOf('.'));
			destFile = new File(fileName + "-2" + ext);
		}

		fis = new FileInputStream(srcFile);
		fos = new FileOutputStream(destFile);

		byte[] buf = new byte[1024];
		int len;
		while ((len = fis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		if (fos != null)
			fos.close();
		if (fis != null)
			fis.close();
	}

	@Override
	public void executer() throws FileErrorException {
		throw new FileErrorException("votre command manque argument");
	}
}

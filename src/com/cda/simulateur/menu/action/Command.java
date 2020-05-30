package com.cda.simulateur.menu.action;

import java.io.IOException;

import com.cda.exceptions.FileErrorException;

public abstract class Command {

	public abstract void executer() throws FileErrorException;

	public abstract void executer(String... pSaisie) throws FileErrorException, IOException;

}

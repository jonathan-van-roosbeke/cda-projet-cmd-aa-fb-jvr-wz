package com.cda.simulateur.menu.action;

public abstract class Action {
	protected final String id;
	protected final String description;
	
	protected Action(String pId, String pDescription) {
		this.id = pId;
		this.description = pDescription;
	}
	
	protected abstract void executer();
	
	public String getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}
}

package cartes;

public enum Type {
	FEU("Feu Rouge", "Feu Vert", "Véhicule Prioritaire"),
	ESSENCE("Panne d'Essence", "Essence", "Citerne"),
	CREVAISON("Crevaison", "Roue de Secours", "Increvable"), 
	ACCIDENT("Accident", "Réparation", "As du Volant");
	
	private String attaqueDescription;
	private String paradeDescription;
	private String botteDescription;
	
	private Type(String attaqueDescription, String paradeDescription, String botteDescription) {
		this.attaqueDescription = attaqueDescription;
		this.paradeDescription = paradeDescription;
		this.botteDescription = botteDescription;
	}

	public String getAttaqueDescription() {
		return attaqueDescription;
	}

	public String getParadeDescription() {
		return paradeDescription;
	}

	public String getBotteDescription() {
		return botteDescription;
	}
	
}

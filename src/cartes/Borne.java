package cartes;

public class Borne extends Carte {
	
	private int km;

	public Borne(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder("Borne ");
		text.append(km);
		text.append(" km");
		return text.toString();
	}

}

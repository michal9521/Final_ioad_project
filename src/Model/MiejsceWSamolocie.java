package Model;

enum klasa {
	biznes, ekonomiczna;
}	

public class MiejsceWSamolocie {
	private klasa klasa; 	
	private int numerKolumny;
	private int numerRzedu;
	
	public MiejsceWSamolocie(klasa kl, int numerKol, int numerRzedu){
		this.klasa = kl;
		this.numerKolumny = numerKol;
		this.numerRzedu = numerRzedu;
	}
	
	public int getNumerKolumny() {
		return this.numerKolumny;
	}
	
	public int getNumerRzedu() {
		return this.numerRzedu;
	}
}

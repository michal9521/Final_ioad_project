package Model;

public class Airbus_A380 extends Samolot {
	
	public Airbus_A380(String id) {
		super(id);
		this.calkowitaMasaPodreczna = 20000;
		this.calkowitaMasaBagazu = 100000;
		this.iloscMiejsc = 200;
		this.iloscMiejscBiznes = 50;
		this.iloscMiejscEko = iloscMiejsc - iloscMiejscBiznes;
		
		InitMiejsca(iloscMiejscBiznes, iloscMiejscEko);
	}

	@Override
	public String getNazwaModelu() {
		// TODO Auto-generated method stub
		return "Airbus_A380";
	}
}

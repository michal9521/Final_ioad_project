package Model;

public class Boeing_787 extends Samolot {
	
	public Boeing_787(String id) {
		super(id);
		this.calkowitaMasaPodreczna = 20000;
		this.calkowitaMasaBagazu = 100000;
		this.iloscMiejsc = 200;
		this.iloscMiejscBiznes = 50;
		this.iloscMiejscEko = iloscMiejsc - iloscMiejscBiznes;
		
		InitMiejsca(iloscMiejscBiznes, iloscMiejscEko);
	}
	
	public Boeing_787(String id, String miasto, int idLotu) {
		super(id, miasto, idLotu);
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
		return "Boeing_787";
	}
}

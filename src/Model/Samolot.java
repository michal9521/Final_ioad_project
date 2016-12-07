package Model;

import java.util.ArrayList;
import java.util.List;

enum status {
	gotowyDoLotu, wyladowywany, zaladowywany, gotowDoStartu, zaparkowany;
}
public abstract class Samolot {
	protected String idSamolotu;
	protected int iloscMiejsc;
	protected int iloscMiejscBiznes;
	protected int iloscMiejscEko;
	protected float calkowitaMasaPodreczna;
	protected float calkowitaMasaBagazu;
	protected MiejsceParkingowe parkingRef;
	protected status status;
	protected List<MiejsceWSamolocie> listaMiejsc;
	
	public Samolot(String id) {
		this.idSamolotu = id;
		this.listaMiejsc = new ArrayList<MiejsceWSamolocie>();
		this.status = status.gotowyDoLotu;
		System.out.println(this.status.toString());
		this.parkingRef = new MiejsceParkingowe(3, 'A');
	}
	
	public void InitMiejsca(int iloscBiznes, int iloscEko){
		int rzad = 0;
		int kolumna = 0;
		for (int i = 0; i < iloscBiznes; i++){
			this.listaMiejsc.add(new MiejsceWSamolocie(klasa.biznes, rzad, kolumna));
			kolumna+=kolumna;
			if (i%4 == 0){
				rzad+=rzad;
				kolumna = 0;
			}
		}
		
		for (int i = 0; i < iloscEko; i++){
			this.listaMiejsc.add(new MiejsceWSamolocie(klasa.ekonomiczna, rzad, kolumna));
			kolumna+=kolumna;
			if (i%8 == 0){
				rzad+=rzad;
				kolumna = 0;
			}
		}
	}
	public MiejsceParkingowe getParkingRef() {
		return this.parkingRef;
	}
	
	public void setParkingRef(MiejsceParkingowe miejsce){
		this.parkingRef = miejsce;
		miejsce.setSamolotRef(this);
	}
	
	public void delParkingRef() {
		this.parkingRef = null;
	}
	
	public String getSamolotId() {
		return this.idSamolotu;
	}
	
	public float getCalkowitaWagaPodreczna() {
		return this.calkowitaMasaPodreczna;
	}
	
	public float getCalkowitaWagaBagazu() {
		return this.calkowitaMasaBagazu;
	}
	
	public String getId() {
		return this.idSamolotu;
	}
	
	public status getStatusSamolotu() {
		return this.status;
	}
	
	public void setStatusSamolotu(status status) {
		this.status = status;
	}
	
	public abstract String getNazwaModelu();
	
	public int getLiczbaMiejscEko() {
		return this.iloscMiejscEko;
	}
	
	public int getLiczbaMiejscBiznes() {
		return this.iloscMiejscBiznes;
	}
	
	public MiejsceParkingowe getMiejsceParkingowe() {
		return this.parkingRef;
	}
	
//	public void getWolneMiejscaWSamolocie() {
//		List<MiejsceWSamolocie> wolneMiejsca = null;
//		
//		for (int i = 0; i < this.listaMiejsc.size(); i++) {
//			if ()
//		}
//	}
}

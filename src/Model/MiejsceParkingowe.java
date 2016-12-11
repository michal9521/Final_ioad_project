package Model;

public class MiejsceParkingowe {
	private String idMiejscaParkigowego;
	private Samolot samolotRef;
	
	public MiejsceParkingowe(int numer, char znak) {
		this.idMiejscaParkigowego = new StringBuilder().append("").append(znak).toString();
		this.idMiejscaParkigowego += Integer.toString(numer);
	}	
	
	public MiejsceParkingowe(String park){
		this.idMiejscaParkigowego = park;
	}
	
	public Samolot getSamolotRef(){
		return this.samolotRef;
	}
	
	public void setSamolotRef(Samolot samolot) {
		this.samolotRef = samolot;
	}
	
	public void delSamolotRef() {
		this.samolotRef.delParkingRef();
		this.samolotRef = null;
	}
	
	public String getId() {
		return this.idMiejscaParkigowego;
	}
}

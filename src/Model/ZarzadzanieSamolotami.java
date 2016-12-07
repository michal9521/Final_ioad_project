package Model;

import java.util.ArrayList;
import java.util.List;

public class ZarzadzanieSamolotami {
	private static final Object[][] String = null;
	private List<Samolot> listaSamolotow;
	private List<MiejsceParkingowe> listaMiejscParkingowych;
	
	public ZarzadzanieSamolotami() {
		this.listaSamolotow = new ArrayList<Samolot>();
		this.listaMiejscParkingowych = new ArrayList<MiejsceParkingowe>();
		InitMiejscaParkingowe();
	}
	
	public void Przylot(Samolot samolot){
		this.listaSamolotow.add(samolot);
	}
	
	public void Odlot(Samolot samolot){
		this.listaSamolotow.remove(samolot);
	}
	
	public boolean ParkujSamolot(Samolot samolot, MiejsceParkingowe miejsce){
		if (miejsce.getSamolotRef() == null) {
			miejsce.setSamolotRef(samolot);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ZwolnijMiejsce(MiejsceParkingowe miejsce) {
		if (miejsce.getSamolotRef() == null){
			return false;
		}
		else{
			miejsce.delSamolotRef();
			return true;
		}
	}
	
	public void InitMiejscaParkingowe() {
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(0, 'A'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(1, 'A'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(2, 'A'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(3, 'A'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(4, 'A'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(0, 'B'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(1, 'B'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(2, 'B'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(3, 'B'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(4, 'B'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(1, 'C'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(2, 'C'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(3, 'C'));
		this.listaMiejscParkingowych.add(new MiejsceParkingowe(4, 'C'));
	}
	
	public Samolot ZnajdzPoId(String id){
		for (int i = 0; i < listaSamolotow.size(); i++){
			if (listaSamolotow.get(i).getSamolotId() == id){
				return listaSamolotow.get(i);
			}
		}
		return null;
	}
	
	public List<Samolot> getListaSamolotow() {
		return this.listaSamolotow;
	}
	
	public List<MiejsceParkingowe> getWolneMiejscaParkingowe() {
		List<MiejsceParkingowe> wolneMiejsca = null;
		for (int i = 0; i < this.listaMiejscParkingowych.size(); i++) {
			if (this.listaMiejscParkingowych.get(i).getSamolotRef() == null) {
				wolneMiejsca.add(this.listaMiejscParkingowych.get(i));
			}
		}
		return wolneMiejsca;
	}
	
	public void AddPlanes() {
		Samolot s1 = new Airbus_A319("a01");
		Samolot s2 = new Boeing_737("a02");
		Samolot s3 = new Tupolew_204("a03");	
		this.listaSamolotow.add(s1);
		this.listaSamolotow.add(s2);
	}
	
    String[][] columnNames1 ={ {"Plane Id",
    		"Model",
            "Ilosc Miejsc Biznes",
            "Ilosc Miejsc Eko",
            "Calk. masa bagazu",
            "Calk. masa podreczna", "Status", "Miejsce park."}};
    
//    {
//	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
//	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
//	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"},
//	    {"22d", "Boeing_737", "50", "150", "20000", "2000", "Wolny", "a30"}
//	};
    
    public String[][] toTab() {
//    	String pom[];
    	String[][] tab = new String[listaSamolotow.size()][];
    	for (int i = 0; i < this.listaSamolotow.size(); i++) {
    		System.out.println("test");
		tab[i] = new String []{ this.listaSamolotow.get(i).getId(),
				this.listaSamolotow.get(i).getNazwaModelu(),
				Integer.toString(this.listaSamolotow.get(i).getLiczbaMiejscBiznes()),
				Integer.toString(this.listaSamolotow.get(i).getLiczbaMiejscEko()),
				this.listaSamolotow.get(i).getStatusSamolotu().toString(),
					this.listaSamolotow.get(i).getMiejsceParkingowe().toString()};				
    	}
//    	for (int i = 0; i < this.listaSamolotow.size(); i++) {
//    		String tab[] = 
//    	}
		return tab;	
    }
}

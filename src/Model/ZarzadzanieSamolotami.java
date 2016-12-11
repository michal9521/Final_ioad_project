package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Controller.MySQLAccess;

public class ZarzadzanieSamolotami {
	private static final Object[][] String = null;
	private List<Samolot> listaSamolotow;
	private List<MiejsceParkingowe> listaMiejscParkingowych;
	private List<Samolot> przylatujaceSamoloty;
	private List<Samolot> listaSamolotowNaPlycie;

	private MySQLAccess db;
	
	public ZarzadzanieSamolotami() {
		this.listaSamolotow = new ArrayList<Samolot>();
		this.listaMiejscParkingowych = new ArrayList<MiejsceParkingowe>();
		this.przylatujaceSamoloty = new ArrayList<Samolot>();
		InitMiejscaParkingowe();
		db = new MySQLAccess();
		listaSamolotowNaPlycie  = new ArrayList<Samolot>();
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
		Przylot(s3);
	}
	
    public String[][] toTab() {
    	
    	String[][] tab = new String[listaSamolotow.size()][];
    	
    	for (int i = 0; i < this.listaSamolotow.size(); i++) {
    			tab[i] = new String []{ this.listaSamolotow.get(i).getId(),
				this.listaSamolotow.get(i).getNazwaModelu(),
				Integer.toString(this.listaSamolotow.get(i).getLiczbaMiejscBiznes()),
				Integer.toString(this.listaSamolotow.get(i).getLiczbaMiejscEko()),
				Float.toString(this.listaSamolotow.get(i).getCalkowitaWagaBagazu()),
				Float.toString(this.listaSamolotow.get(i).getCalkowitaWagaPodreczna()),
				this.listaSamolotow.get(i).getStatusSamolotu().toString(),
				this.listaSamolotow.get(i).getMiejsceParkingowe().getId()};				
    	}
		return tab;	
    }
    
    public void PrzylatujaceSamoloty() {
		Samolot s4 = new Airbus_A319("a04", "Moskwa", 605);
		Samolot s5 = new Boeing_737("a05", "Warszawa", 100);
		Samolot s6 = new Tupolew_204("a06", "New York", 043);
    	this.przylatujaceSamoloty.add(s4);
    	this.przylatujaceSamoloty.add(s5);
    	this.przylatujaceSamoloty.add(s6);
    }
    public String[][] toTab2() {    	
    	String[][] tab = new String[przylatujaceSamoloty.size()][];
    	for (int i = 0; i < this.przylatujaceSamoloty.size(); i++) {
    		tab[i] = new String[]{
    				this.przylatujaceSamoloty.get(i).getNazwaModelu(),
    				this.przylatujaceSamoloty.get(i).getMiasto(),
    				Integer.toString(this.przylatujaceSamoloty.get(i).getIdLotu())
    		};
    	}
		return tab;
    }
    
    private List<Samolot> pobierzSamolotyZBazy(){
    	
    	List<Samolot> listaSamolotow = new ArrayList<Samolot>();
    	Samolot samolot = null;
    	List<SamolotDB> listaSamolotowDB = db.getSamolotyListFromDatabase();
    	List<ModeleSamolotow> listaModeleSamolotow = db.getModeleSamolotowListFromDatabase();
    	for(SamolotDB samolotDB : listaSamolotowDB){
    		String nazwaModelu = samolotDB.getModelSamolotu().getNazwa();
    		// stworz faktyczyny samolot dziedziczacy z samolot.
    		if(nazwaModelu.equals("Airbus A319")){
    			samolot = new Airbus_A319(Integer.toString(samolotDB.getIdSamolotu()));
    		}
    		else if(nazwaModelu.equals("Airbus A380")){
    			samolot = new Airbus_A380(Integer.toString(samolotDB.getIdSamolotu()));
    		}
    		else if(nazwaModelu.equals("Boeing 737")){
    			samolot = new Boeing_737(Integer.toString(samolotDB.getIdSamolotu()));
    		}
    		else if(nazwaModelu.equals("Boeing 787")){
    			samolot = new Boeing_787(Integer.toString(samolotDB.getIdSamolotu()));
    		}
    		else if(nazwaModelu.equals("Tupolew 204")){
    			samolot = new Tupolew_204(Integer.toString(samolotDB.getIdSamolotu()));
    		}
    		Model.status []statusy = {	Model.status.gotowyDoLotu, Model.status.rozladowany, Model.status.zaladowany, Model.status.gotowDoStartu, Model.status.zaparkowany};
			samolot.setStatusSamolotu(statusy[samolotDB.getStatusSamolotu()-1]);
			if(!listaSamolotowNaPlycie.contains(samolot)){
				listaSamolotow.add(samolot);
			}
    	}
    	return listaSamolotow;
    	
    }
    
    private Samolot wyszukajSamolotPoId(List<Samolot> lista, String id){
    	for(Samolot samolot : lista){
    		if(samolot.getSamolotId().equals(id)){
    			return samolot;
    		}
    	}
    	return null;
    }
    
    public void pobieranieSamolotowPzylatujacych(){
    	List<Lot> listaLotow = db.getLotyListFromDatabase();
    	List<Samolot> listaSamolotow = pobierzSamolotyZBazy();
    	Date dzisiejszaData = new Date();
    	for(Lot lot : listaLotow){
    		if(lot.getDataPrzylotu().getDay() == dzisiejszaData.getDay() 
    				&& lot.getDataPrzylotu().getMonth() == dzisiejszaData.getMonth() 
    				&& lot.getDataPrzylotu().getYear() == dzisiejszaData.getYear())
    		{
    			Samolot sam = wyszukajSamolotPoId(listaSamolotow,Integer.toString(lot.getIdSamolotu()));
    			if(!czySamolotNaPlycie(sam)){
    				listaSamolotowNaPlycie.add(sam);
    			}
    		}
    	}
    }
    
    public void pobranieSamolotowWylatujacychZLodzi(){
    	List<Lot> listaLotow = db.getLotyListFromDatabase();
    	List<Samolot> listaSamolotow = pobierzSamolotyZBazy(); 
    	for(Lot lot : listaLotow){
    		if(lot.getMiejsceWylotu().equals("Lodz")){
    			Samolot sam = wyszukajSamolotPoId(listaSamolotow,Integer.toString(lot.getIdSamolotu()));
    			if(!czySamolotNaPlycie(sam)){
    				listaSamolotowNaPlycie.add(sam);
    			}
    		}
    	}
    }
    
    public String[][] samolotyNaPlycieDoWyswietlenia(){
    	String tab[][] = new String[listaSamolotowNaPlycie.size()][];
    	for (int i = 0; i < this.listaSamolotowNaPlycie.size(); i++) {
			tab[i] = new String []{ this.listaSamolotowNaPlycie.get(i).getSamolotId(),
					this.listaSamolotowNaPlycie.get(i).getNazwaModelu(),
					this.listaSamolotowNaPlycie.get(i).getStatusSamolotu().toString(),
					this.listaSamolotowNaPlycie.get(i).getMiejsceParkingowe().getId()};				
    	}
	return tab;	
    }
    
    private boolean czySamolotNaPlycie(Samolot samolot){
    	for(Samolot sam : listaSamolotowNaPlycie){
    		if(sam.getSamolotId().equals(samolot.getSamolotId())){
    			return true;
    		}
    	}
    	return false;
    }
    
    public void zmienStatus(int i, status status){
    	listaSamolotowNaPlycie.get(i).setStatusSamolotu(status);
    	db.UpdateStatus(Integer.parseInt(listaSamolotowNaPlycie.get(i).getSamolotId()), status.ordinal()+1);
    }
    
}

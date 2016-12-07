import Controller.MySQLAccess;
import Model.ZarzadzanieSamolotami;
import WIndow.PanelZarzadzania;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Katy!");
		ZarzadzanieSamolotami zarzadzanie = new ZarzadzanieSamolotami();
		zarzadzanie.AddPlanes();
		PanelZarzadzania okno = new PanelZarzadzania(zarzadzanie);
		MySQLAccess db = new MySQLAccess();
	}

}

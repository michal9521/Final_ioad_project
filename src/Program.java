import Controller.MySQLAccess;
import Model.ZarzadzanieSamolotami;
import Samolot.StartWindow;
import Samolot.ZarządzanieSamolotamiWindow;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ZarzadzanieSamolotami zarzadzanie = new ZarzadzanieSamolotami();
//		zarzadzanie.AddPlanes();
//		zarzadzanie.PrzylatujaceSamoloty();
		// new ZarządzanieSamolotamiWindow(zarzadzanie, new MySQLAccess());
		new StartWindow().setVisible(true);
	}

}

import Controller.MySQLAccess;
import Model.ZarzadzanieSamolotami;
import Samolot.StartWindow;
import Samolot.Zarz¹dzanieSamolotamiWindow;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ZarzadzanieSamolotami zarzadzanie = new ZarzadzanieSamolotami();
//		zarzadzanie.AddPlanes();
//		zarzadzanie.PrzylatujaceSamoloty();
		// new Zarz¹dzanieSamolotamiWindow(zarzadzanie, new MySQLAccess());
		new StartWindow().setVisible(true);
	}

}

import Controller.MySQLAccess;
import Model.ZarzadzanieSamolotami;
import Samolot.NoweOkno;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZarzadzanieSamolotami zarzadzanie = new ZarzadzanieSamolotami();
		zarzadzanie.AddPlanes();
		zarzadzanie.PrzylatujaceSamoloty();
		/*NoweOkno okno =*/ new NoweOkno(zarzadzanie, new MySQLAccess());
	}

}

import cage.Cage;
import zone.Zone;
import animal.*;
import animal.mammal.Elephant;
import animal.mammal.Lion;
import animal.reptile.Crocodile;
import animal.reptile.Turtle;

public class ZooManagement {

	public static void main(String[] args) {
		Zoo zoo = new Zoo(10);

//		Zone zone3 = new Zone("REPTILE", 5);

		Zone mammalZone = new Zone("MAMMAL", 10);		
		Cage lionCage1 = new Cage("lion", 2);
		Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    lionCage1.addAnimal(lion1);
        Cage elephantCage1 = new Cage("elephant",1);
        Cage elephantCage2 = new Cage("elephant",1);
        Animal elephant1 = new Elephant("E1", "500Kg", "cold", 5, 4);
		elephantCage1.addAnimal(elephant1);
        mammalZone.addCage(lionCage1);
		mammalZone.addCage(elephantCage1);
		mammalZone.addCage(elephantCage2);
		zoo.addZone(mammalZone);
	
		Zone reptileZone = new Zone("REPTILE",15);
		Cage crocodileCage1 = new Cage("crocodile", 5);
		Animal crcodile1 = new Crocodile("c1", "500kg", "yellow", "XYZ");
		crocodileCage1.addAnimal(crcodile1);
		Animal crcodile2 = new Crocodile("c2", "200kg", "yellow", "XYZ");
		crocodileCage1.addAnimal(crcodile2);
		reptileZone.addCage(crocodileCage1);
		Cage turtleCage1 = new Cage("turtle",3);
		Animal turtle1 = new Turtle("t1","50kg", "blue", "ABC");
		turtleCage1.addAnimal(turtle1);
		reptileZone.addCage(turtleCage1);
		Cage turtleCage2 = new Cage("turtle",2);
		reptileZone.addCage(turtleCage2);
		
		
	}
}

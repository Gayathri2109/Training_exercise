package day3;

public class VariableDemo {


public static void main(String[] args) {

 TrainingRoom room1=new TrainingRoom();
 room1.teach();
 TrainingRoom room2=new TrainingRoom();

  }
}
class Chalk{
public Chalk() {
 System.out.println("chalk object created...");
 }
}
class Canteen{
 Canteen(){ 
	 System.out.println("canteen object is created...");
 }
}
class Projector{
 Projector(){
 System.out.println("projector object is created...");
 }
}
class TrainingRoom{
public TrainingRoom() {
 System.out.println("training room object iscreated...");
 }
public void teach() {
 Chalk chalk=new Chalk();
 }

Projector projector=new Projector();
static Canteen canteen=new Canteen();
}

package Day17;

public class EnumDemo {
public static void main(String[] args) {
	Cars car;
	car = Cars.maruthi;
	met(car);
  }
public static void met(Cars car) {
	if(car==Cars.maruthi)
		System.out.println("It's maruthi......");
	else if(car==Cars.fiat)
		System.out.println("It's a fiat car....");
	
	switch(car)
	{
	case maruthi:{
		System.out.println("\"It's maruthi......\"");
		break;
	}
	}
	
	
	Cars c[] = Cars.values();
//	for(Cars cc:c)
//	  System.out.println(cc);
	
	for(Cars cc:c)
		  System.out.println(cc.getPrize());

}
}

enum Cars{
	//maruthi,suzukhi,porsche,fiat,tata;
	maruthi(268),suzukhi(3174),porsche(1823),fiat(100),tata(200);
	private int prize;
	
	private Cars(int prize) {
		this.prize = prize;
	}
	
	public int getPrize()
	{
		return prize;
	}
}

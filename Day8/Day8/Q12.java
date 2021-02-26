package Day8;

public class Q12 {
public static void main(String[] args) {
	Harris h[] = new Harris[3];
	h[0] = new HarrisInfoTech();
	h[1] = new HarrisPharma();
	h[2] = new HarrisTechnologies();
	for(int i=0;i<3;i++)
		h[i].getMethod();
}
}

abstract class Harris{
	public abstract void getMethod();
}

class HarrisInfoTech extends Harris{
	@Override
	public void getMethod() {
		// TODO Auto-generated method stub
		System.out.println("HarrisInfoTech");
	}
}

class HarrisPharma extends Harris{

	@Override
	public void getMethod() {
		// TODO Auto-generated method stub
		System.out.println("HarrisPharma");
	}
}

class HarrisTechnologies extends Harris{
	@Override
	public void getMethod() {
		// TODO Auto-generated method stub
		System.out.println("HarrisTechnologies");
	}
}

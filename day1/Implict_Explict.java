package day1;

public class Implict_Explict {
public static void main(String[] args) {
	byte b = 1;
	short s = 2;
	int i = 5;
	long l = 900;
	float f = 1.1f;
	double d = 2.2;
	
	{
		//Implicit
		int x = b;
		double y = l;
		long ll = s;
	}
	
	{
		//Explicit
		float f1 = (float)d;
		byte b1 = (byte)l;
		short s1 = (short)f;
		int c = (int)d;
	}
	
	
}
}

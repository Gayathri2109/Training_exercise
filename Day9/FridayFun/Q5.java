package Day9.FridayFun;

public class Q5 {
public static void main(String[] args) {
	int threeDigitNo = 0;
	for(int i=1;i<=4;i++)
	{
		for(int j=1;j<=4;j++)
		{
			for(int k=1;k<=4;k++)
			{
				//threeDigitNo++;
				//System.out.println(i+""+j+""+k);
				if(k!=i && k!=j && i!=j)
				{
					threeDigitNo++;
					System.out.println(i+""+j+""+k);
				}
			}
		}
	}
	System.out.println("Total Three Digit Nos are : "+threeDigitNo);
}
}

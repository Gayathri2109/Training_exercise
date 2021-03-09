package Day16;

public class PrintfDemp {
	
	
	/* String formatting
	 * flag +(default) .....padding to left - padding to the right
	 * [.] ..percision for float
	 * [width] - in padding how many output char u want....
	 */

	public static void main(String[] args) {
		//printf f-formating 
		
		//System.out.printf("formating instructions", "input");
		
		System.out.printf("Integer Value....%06d\nFloat Vlaue....%.1f\nString Value....%s",200,14.3f,"gayu");
		// String s = String.format(null, args) - can also use this for formating
		//%06d - telss to print 6 nos...
		
		System.out.printf("\n%-15s %-15s %-15s","Column1","Column2","Column3");
		System.out.printf("\n%15s","gayu");
		
		//met(1,2,3,0,4,5,6);
	}
	
	//int..i is a feature introduced in jdk5 - which accepts multiple values....
	public static void met(int...i) {
		for(int i1:i)
			System.out.print(i1);
	}
}

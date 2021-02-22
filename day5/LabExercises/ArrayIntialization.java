package LabExercises;

public class ArrayIntialization {
public static void main(String[] args) {
	//single dimensional array
	int a[] = new int[5];
	int b[] = {1,2,3,4};
	
	//two dimensional array
	int ab[][] = new int[2][3];
	int cd[][] = {{1,2},{3,4,5}};

    //uneven dimensional array
	int ob[][] = new int[3][];
    ob[0] = new int[5];
    ob[1] = new int[8];
    
	
}

}

package Day8;

public class Q14 {
public static void main(String[] args) {
	Result res = new Result("Rani", 21, 90, 95, 80);
	
	System.out.println("Total marks: "+res.gettotalmarks());
}
}

class Student{
	String name;
	int rollNo;
	
	public Student(String name,int i) {
		this.name = name;
		rollNo = i;
	}
	
}

class Exam extends Student{
	
	int maths,science,social;

	public Exam(String name, int i, int maths, int science, int social) {
		super(name, i);
		this.maths = maths;
		this.science = science;
		this.social = social;
	}
	
}

class Result extends Exam{
	
	int totalMarks;
	
	public Result(String name, int i, int maths, int science, int social) {
		super(name, i, maths, science, social);
	}

	public int gettotalmarks()
	{
		totalMarks = maths+science+social;
		return totalMarks;
		
	}
	
	
}

package inheritancepack;

public class BataShoeFactory extends ShoeFactory{

	private String BataName;

	public final String getBataName() {
		return BataName;
	}

	public final void setBataName(String bataName) {
		BataName = bataName;
	}
	
	public void visit() {
		new Handler().handle(this);
	}
	
}

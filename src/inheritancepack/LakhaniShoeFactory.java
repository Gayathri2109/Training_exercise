package inheritancepack;

public class LakhaniShoeFactory extends ShoeFactory{

	private String LakhaniName;

	public final String getLakhaniName() {
		return LakhaniName;
	}

	public final void setLakhaniName(String lakhaniName) {
		LakhaniName = lakhaniName;
	}
	
	public void visit() {
		new Handler().handle(this);
	}
	
}

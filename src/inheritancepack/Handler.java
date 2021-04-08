package inheritancepack;

public class Handler {

	public void handle(ShoeFactory obj) {
		System.out.println(obj.getName());
	}
	
	public void handle(BataShoeFactory obj) {
		System.out.println(obj.getBataName());
	}
	
	public void handle(LakhaniShoeFactory obj) {
		System.out.println(obj.getLakhaniName());
	}
}

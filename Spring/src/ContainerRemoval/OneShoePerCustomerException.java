package ContainerRemoval;

public class OneShoePerCustomerException extends Exception {

	private String msg;
	
	public OneShoePerCustomerException(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
}

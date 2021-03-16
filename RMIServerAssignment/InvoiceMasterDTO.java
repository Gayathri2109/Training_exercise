package Assignment;

import java.io.Serializable;
import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable{
	
	private int invno;
	private LocalDate invdate;
	private int customerno;
	
	
	public final int getInvno() {
		return invno;
	}
	public final void setInvno(int invno) {
		this.invno = invno;
	}
	public final LocalDate getInvdate() {
		return invdate;
	}
	public final void setInvdate(LocalDate invdate) {
		this.invdate = invdate;
	}
	public final int getCustomerno() {
		return customerno;
	}
	public final void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	

	@Override
	public String toString() {
		return "invno=" + invno + ", invdate=" + invdate + ", customerno=" + customerno;
	}
	
	
}

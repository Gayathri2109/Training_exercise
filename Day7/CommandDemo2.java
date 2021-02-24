package Day7;

public class CommandDemo2 {
	
	static ESeva es;
	static {
		Corporation cp = new Corporation();
		Foodsafety fs = new Foodsafety();
		Hospital hsp = new Hospital();
		Police pp = new Police();
		
		es =  new ESeva();
		
		es.setCommand(new HotelOpenCommand(fs, hsp, cp, pp), 0);
		es.setCommand(new ForeignDeathCommand(fs, hsp, cp, pp), 1);
		es.setCommand(new OrphanDeathCommand(fs, hsp, cp, pp), 2);
		
	}
	
	public static void main(String[] args) {
		es.exeCommand(3);
	}
}



class ESeva
{
	Command1 com[] = new Command1[5];
	public ESeva() {
		for(int i=0;i<5;i++)
			com[i] = new dummy1();
	}
	
	public void setCommand(Command1 c,int clot)
	{
		com[clot] = c;
	}
	
	public void exeCommand(int s)
	{
		com[s].execute();
	}
	
	
	class dummy1 extends Command1
	{
		@Override
		public void execute() {
			System.out.println("I am Dummy...Yet to be operational...");
			
		}
	}
}


abstract class Command1
{
	Foodsafety fs;
	Hospital hsp;
	Corporation cp;
	Police pp;
	
	public Command1() {
		// TODO Auto-generated constructor stub
	}
	
	public Command1(Foodsafety fs, Hospital hsp, Corporation cp, Police pp) {
		super();
		this.fs = fs;
		this.hsp = hsp;
		this.cp = cp;
		this.pp = pp;
	}

	public abstract void execute();
}

class HotelOpenCommand extends Command1
{
	public HotelOpenCommand(Foodsafety fs, Hospital hsp, Corporation cp, Police pp)
	{
		super(fs,hsp,cp,pp);
	}
	
	
	@Override
	public void execute() {
		System.out.println("Hotel opening Process staterd");
		fs.checkPremisis();
		cp.doInspection();
		pp.givePoliceCertificate();
		fs.giveFSSCertificate();
		System.out.println("Hotel opening Process over...You can run the Hotel....");
	}
}

class ForeignDeathCommand extends Command1
{
	public ForeignDeathCommand(Foodsafety fs, Hospital hsp, Corporation cp, Police pp)
	{
		super(fs,hsp,cp,pp);
	}
	@Override
	public void execute() {
		System.out.println("Foreign Death certificate Process started....");
		pp.doPoliceInvestigation();
		pp.givePoliceCertificate();
		cp.doInspection();
		hsp.doPostmortem();
		cp.giveDeathCeritificate();
		hsp.arrangeTransport();
		System.out.println("Foreign Death certificate Process over......now send the body");
	}
	
}

class OrphanDeathCommand extends Command1
{
	public OrphanDeathCommand(Foodsafety fs, Hospital hsp, Corporation cp, Police pp)
	{
		super(fs,hsp,cp,pp);
	}
	@Override
	public void execute() {
		System.out.println("Orphan Death Process started....");
		hsp.doPostmortem();
		pp.doPoliceInvestigation();
		pp.givePoliceCertificate();
		cp.giveDeathCeritificate();
		System.out.println("Orphan Death Process over....now bury the body....");
		
	}
}

class Hospital
{
	public void doPostmortem()
	{
		System.out.println("Postmortem done by hospital...");
	}
	
	public void arrangeTransport()
	{
		System.out.println("body Transport arranged...");
	}
}

class Police
{
	public void doPoliceInvestigation()
	{
		System.out.println("Police Investigation DOne....");
	}
	
	public void givePoliceCertificate()
	{
		System.out.println("Police Certificate given.....");
	}
	
}

class Foodsafety
{
	public void checkPremisis()
	{
		System.out.println("Premisis checked by the FSS officials...");
	}
	
	public void giveFSSCertificate()
	{
		System.out.println("FSS  certificate given....");
	}
}

class Corporation
{
	public void giveDeathCeritificate()
	{
		System.out.println("Death certificate given...");
	}
	public void doInspection()
	{
		System.out.println("Inspection done by corporation....");
	}
	
}

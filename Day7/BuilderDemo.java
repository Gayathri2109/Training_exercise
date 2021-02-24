package Day7;

public class BuilderDemo {

	public static void main(String[] args) {
		Computer mycom1 = new Computer.ComputerBuilder("hdd enabled...", "16 gb ram....").build();
		System.out.println(mycom1);
		Computer mycom2 = new Computer.ComputerBuilder("hdd enabled....","16gb ram....").setBluetooth("bluethoot enabled....").setGraphicsCard("graphics card enabled...").build();
		System.out.println(mycom2);
	}
}


class Computer{

	//fixed
	private String hdd;
	private String ram;
	//additional
	private String bluetooth;
	private String graphicsCard;
	
	public Computer(ComputerBuilder build) {
		// TODO Auto-generated constructor stub
	this.hdd = build.hdd;
	this.ram = build.ram;
	this.bluetooth = build.getBluetooth();
	this.graphicsCard = build.getGraphicsCard();
	}
	
	
	
	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", ram=" + ram + ", bluetooth=" + bluetooth + ", graphicsCard=" + graphicsCard
				+ "]";
	}



	public static class ComputerBuilder
	{
		//fixed
		private String hdd;
		private String ram;
		//additional
		private String bluetooth;
		private String graphicsCard;
		
		public ComputerBuilder(String hdd,String ram) {
			// TODO Auto-generated constructor stub
			this.hdd = hdd;
			this.ram = ram;
		}

		public final String getBluetooth() {
			return bluetooth;
		}

		public final ComputerBuilder setBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
		}

		public final String getGraphicsCard() {
			return graphicsCard;
		}

		public final ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		
		public Computer build()
		{
			return new Computer(this);
		}
		
		
	}
}


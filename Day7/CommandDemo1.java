package Day7;

public class CommandDemo1 {
	
	static UniversalRemote uni;
	static
	{	Tv sony = new Tv();
		SetTopBox set = new SetTopBox();
		SoundSystem ss = new SoundSystem();
		VGame vgame = new VGame();
		uni = new UniversalRemote();
		
		uni.setCommand(new NewsChannel(sony, vgame, ss, set),0);
		uni.setCommand(new playTennis(sony, vgame, ss, set), 1);
		uni.setCommand(new serialChannel(sony, vgame, ss, set), 2);
		
	}
	public static void main(String[] args) {
		uni.executeCommand(0);
	}

}

class UniversalRemote
{
	Command c[] = new Command[5];
	
	public UniversalRemote() {
		for(int i=0;i<5;i++)
			c[i] = new dummy();
	}
	
	public void setCommand(Command c,int slot)
	{
		this.c[slot] = c;
	}
	
	public void executeCommand(int slot)
	{
		c[slot].execute();
	}
	
	
	
	class dummy extends Command
	{
		@Override
		public void execute() {
			// TODO Auto-generated method stub
		System.out.println("I am Dummy....Yet to be operational....");	
		}
	}
	
}


abstract class Command
{
	Tv sony;
	VGame vgame;
	SoundSystem ss;
	SetTopBox set;
	
	public Command() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Command(Tv sony, VGame vgame, SoundSystem ss, SetTopBox set) {
		super();
		this.sony = sony;
		this.vgame = vgame;
		this.ss = ss;
		this.set = set;
	}


	public abstract void execute();
}

class NewsChannel extends Command
{
	public NewsChannel(Tv sony, VGame vgame, SoundSystem ss, SetTopBox set)
	{
		super(sony,vgame,ss,set);
		
	}
	public void execute() {
		System.out.println("News Channel Command process starts....");
		sony.switchOn();
		sony.av1Mode();
		ss.highSound();
		set.newsChannel();
		System.out.println("News Channel Command process gets over....");
	};
}

class serialChannel extends Command{
	public serialChannel(Tv sony, VGame vgame, SoundSystem ss, SetTopBox set)
	{
		super(sony,vgame,ss,set);
		
	}
	@Override
		public void execute() {
		System.out.println("Serial Channel Command process starts....");
		sony.switchOn();
		sony.av1Mode();
		ss.lowSound();
		set.serialChannel();
		System.out.println(" Serial Channel Command process gets over....");
			
		}	
}

class playTennis extends Command
{
	public playTennis(Tv sony, VGame vgame, SoundSystem ss, SetTopBox set)
	{
		super(sony,vgame,ss,set);
		
	}
	@Override
	public void execute() {
		System.out.println("PlayTennis Command process starts....");
		sony.switchOn();
		sony.av1Mode();
		ss.highSound();
		vgame.playTennis();
		System.out.println("PlayTennis Command process gets over....");
		
	}
}

class Tv{
	public void switchOn()
	{
		System.out.println("TV is switched On");
	}
	public void av1Mode()
	{
		System.out.println("av1 mode on...");
	}
}

class SetTopBox{
	
	public void newsChannel()
	{
		System.out.println("news channel on");
	}
	public void serialChannel()
	{
		System.out.println("serial channel on...");
	}
}

class SoundSystem{
	public void lowSound()
	{
		System.out.println("Low Sound On");
	}
	public void highSound()
	{
		System.out.println("High Sound on...");
	}
}

class VGame{
	public void playTennis()
	{
		System.out.println("play Tennis....");
	}
	
}
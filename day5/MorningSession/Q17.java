package MorningSession;

public class Q17 {
public static void main(String[] args) {
	Base b = new Base();
	Sub s = (Sub)b;
}
}

class Base{}
class Sub extends Base{}
class Sub2 extends Base{}
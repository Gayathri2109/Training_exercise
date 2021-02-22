package MorningSession;


 class over {
	 private void amethod(int i)
	 {
		 System.out.println("Base.amethod");
	 }
}
 
 class Q59 extends over
 {
	 public static void main(String[] args) {
		Q59 o = new Q59();
		int i =0;
		o.amethod(i);
		
		
	}
	 
	 public void amethod(int i)
	 {
		 System.out.println("Over.Method");
	 }
 }

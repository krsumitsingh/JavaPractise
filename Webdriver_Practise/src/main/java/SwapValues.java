
public class SwapValues {

	static int a = 1;
	static int b = 2;
	static int c;
	public static void main(String[] args) {
		System.out.println("Value of a and b before swap is "+ a +" and "+b );
		c=a;
		a=b;
		b=c;
		
		System.out.println("Value of a and b after swap is "+ a +" and "+b );
	}

}

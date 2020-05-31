
public class ObjParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*Test T1 = new Test(1, 2);
Test T2 = new Test(1, 2);
Test T3 = new Test(50, 50);
	
		
	

	System.out.println("T1 is equal to T2--"+T1.equals(T2));
	System.out.println("T1 is equal to T3--"+T1.equals(T3));*/
	
	Test T4 = new Test(10);	
	Test T5;
		System.out.println("Value before increment--"+T4.a);
		
		T5 = T4.increment();
		System.out.println("Value after increment"+T5.a);
}


}

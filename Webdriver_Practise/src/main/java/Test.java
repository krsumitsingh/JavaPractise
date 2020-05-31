
public class Test {
	int a,b;
	
	/*Test(int i,int j){
		a = i;
		System.out.println("The value of a is---"+a);
		b = j;
		System.out.println("The value of b is---"+b);
		
	}
	
	
	public boolean equals(Test Object){
		if(Object.a==Object.b)
			return false;
			else
			return true;
			
		
	}*/
	//====================================================================
	Test(int b){
		
		a = b;
	}
	
	Test increment(){
		
		Test temp1 = new Test(a+10);
		 return temp1;
		
	}
	
	
	
	
}

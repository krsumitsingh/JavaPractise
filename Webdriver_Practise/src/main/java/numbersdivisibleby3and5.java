import java.util.Scanner;


public class numbersdivisibleby3and5 {

	//static int num;
	
	public static void main(String[] args) {
		
	/*	//num = Math.random()*100;
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		
		System.out.println("Enter a number");
		
		if(num%3 == 0){
			System.out.println("Number "+num+" is divisible by 3");
		}*/
		
		System.out.println("Divided by 3: ");		
		for (int i=1; i<100; i++) {
			if (i%3==0) 
			System.out.print(i +", ");			
		}			
				
		System.out.println("\n\nDivided by 5: ");
		for (int i=1; i<100; i++) {
			if (i%5==0) System.out.print(i +", ");			
		}
				
		System.out.println("\n\nDivided by 3 & 5: ");			
		for (int i=1; i<100; i++) {
			if (i%3==0 && i%5==0) System.out.print(i +", ");			
		}
		System.out.println("\n");
		
	}

}

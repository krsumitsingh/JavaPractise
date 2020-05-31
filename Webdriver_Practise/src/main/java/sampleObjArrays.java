public class sampleObjArrays {

	public int roll_no;
	public String name;

	sampleObjArrays(int roll_no, String name) {
		this.roll_no = roll_no;
		this.name = name;
	}

	public static class GFG {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			// declares an Array of integers.
			sampleObjArrays[] arr = new sampleObjArrays[5];
	 
	        // allocating memory for 5 objects of type Student.
	        //arr = new sampleObjArrays[5];
	 
	        // initialize the first elements of the array
	        arr[0] = new sampleObjArrays(1,"aman");
	 
	        // initialize the second elements of the array
	        arr[1] = new sampleObjArrays(2,"vaibhav");
	 
	        // so on...
	        arr[2] = new sampleObjArrays(3,"shikar");
	        arr[3] = new sampleObjArrays(4,"dharmesh");
	        arr[4] = new sampleObjArrays(5,"mohit");
	 
	        // accessing the elements of the specified array
	        for (int i = 0; i < arr.length; i++)
	            System.out.println("Element at " + i + " : " +
	                        arr[i].roll_no +" "+ arr[i].name);
			
			
		}

	}

}
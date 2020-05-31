


class UserDefinedType
{
    int i=10;
    String abc="SAM";
    char XYZ = 'a'; 
    void methodOne()
    {
        System.out.println("From User Defined Type Object");
        System.out.println("value of i is: "+i );
        System.out.println("value of abc is: "+abc );
        System.out.println("value of char xyz is: "+XYZ);
        
    }
}


public class ArraysInJava {

	public static void main(String[] args) {
        UserDefinedType[] arrayOfUserDefinedTypeObjects = new UserDefinedType[10];
        for (int i = 0; i < arrayOfUserDefinedTypeObjects.length; i++)
        {
            //Creating an object of 'UserDefinedType' and
            //assigning it to an element of array
            arrayOfUserDefinedTypeObjects[i] = new UserDefinedType();
            
        }
        arrayOfUserDefinedTypeObjects[1].methodOne();   //accessing member of 'UserDefinedType'


	}

}

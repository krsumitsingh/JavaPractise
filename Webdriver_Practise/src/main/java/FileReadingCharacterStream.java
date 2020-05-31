import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class FileReadingCharacterStream {

	static String FilePath = System.getProperty("user.dir")+"//src//main//java//Sandbox_Production_Sites.txt";
	static boolean text = ""!=" null";
	public static void main(String[] args) throws IOException {
		FileInputStream FIS = new FileInputStream(FilePath);
		InputStreamReader inputsteramreader = new InputStreamReader(FIS);
		BufferedReader reader = new BufferedReader(inputsteramreader);
	while(text = reader.readLine()!= null){
		System.out.println("The text line is: "+text );
	}
			
			
		
		
		
		
	}

}

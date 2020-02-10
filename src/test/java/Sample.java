import java.io.IOException;
import java.util.ArrayList;

public class Sample {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
DataDrivenTest myobj = new DataDrivenTest();
 ArrayList<String> a =myobj.getData("Login");
 
 System.out.println(a.get(0));
 System.out.println(a.get(1));
 System.out.println(a.get(2));
 System.out.println(a.get(3));


	}

}

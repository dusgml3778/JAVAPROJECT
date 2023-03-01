import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class JSON3 {

	
	public static void main(String[] args) {

		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		

		try {
			System.out.println("入力してください");
			String address = io.readLine();
			String addr = URLEncoder.encode(address,"UTF-8");
	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

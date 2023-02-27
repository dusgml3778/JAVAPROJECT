import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSON2 {

	public static void main(String[] args) {
		String str = "info.json";
		
		InputStream is = JSON2.class.getResourceAsStream(str);

		if(is==null) {
			throw new NullPointerException("No Path");
		} 
		
		JSONTokener tokener = new JSONTokener(is);
		JSONObject object = new JSONObject(tokener);
		
		JSONArray students = object.getJSONArray("students");
		
		for(Object ja : students) {
			
			System.out.println(ja);
		}
		
	}

}

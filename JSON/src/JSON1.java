import org.json.JSONArray;
import org.json.JSONObject;

public class JSON1 {
	public static void main(String[] args) {
		// JSON-Java(org.json)
		JSONArray students = new JSONArray();
		JSONObject student = new JSONObject();	
		student.put("name", "HONGGIlDONG");
		student.put("phone", "010-1111-1111");
		student.put("address", "SEOUL");
		
		students.put(student);
		
		student = new JSONObject();
		
		student.put("name", "HONGGIlDONG1");
		student.put("phone", "010-1111-1112");
		student.put("address", "SEOUL1");

		students.put(student);
		
		JSONObject object = new JSONObject();
		
		object.put("students", students);
		
		System.out.println(object.toString(2));
	}

}

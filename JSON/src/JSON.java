import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSON {

	public static void main(String[] args) {
		// Object -> JSON(String)

		BookDTO dto = new BookDTO("JAVA", 21000, "Aircon", 670);

		Gson g = new Gson();

		String json = g.toJson(dto);

		System.out.println(json);

		BookDTO dto1 = g.fromJson(json, BookDTO.class);

		System.out.println(dto1);

		List<BookDTO> lst = new ArrayList<BookDTO>();

		lst.add(new BookDTO("JAVA1", 21000, "Aircon1", 570));
		lst.add(new BookDTO("JAVA2", 31000, "Aircon2", 670));
		lst.add(new BookDTO("JAVA3", 41000, "Aircon3", 770));

		String str = g.toJson(lst);

		System.out.println(str);

		List<BookDTO> list = g.fromJson(str, new TypeToken<List<BookDTO>>() {
		}.getType());

		for (BookDTO b : list) {

			System.out.println(b);
		}

	}

}

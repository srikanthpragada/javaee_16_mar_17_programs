package json;

import com.google.gson.Gson;

public class CreateJsonFromJob {

	public static void main(String[] args) {
		Job j = new Job("PROG", "Programmer");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(j));
		
	}

}

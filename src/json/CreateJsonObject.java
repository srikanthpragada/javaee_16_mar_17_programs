package json;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateJsonObject {

	public static void main(String[] args) {
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("name", "Srikanth");
		builder.add("occupation", "Director");
		builder.add("company", "Srikanth Technologies");
		
		JsonArrayBuilder emails = Json.createArrayBuilder();
		emails.add("srikanthpragda@yahoo.com");
		emails.add("srikanthpragada@gmail.com");
		
		builder.add("emails", emails);
		
		JsonObject person = builder.build();
		
		
		System.out.println(person.toString());

	}

}

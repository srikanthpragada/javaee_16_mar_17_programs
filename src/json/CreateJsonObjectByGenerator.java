package json;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class CreateJsonObjectByGenerator {

	public static void main(String[] args) {
		JsonGenerator gen = Json.createGenerator(System.out);
		gen.writeStartObject()
		   .write("name", "Srikanth")
		   .write("occupation", "Director, Srikanth Technologies")
		   .writeEnd();
        gen.close();
	}

}

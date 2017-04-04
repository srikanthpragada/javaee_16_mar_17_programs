package json;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadCourseDetails {

	public static void main(String[] args) throws Exception  {

      JsonReader reader = Json.createReader( new FileReader("f:\\classroom\\mar16\\course.json"));
      JsonObject course = reader.readObject();
      
      System.out.println( course.getString("name"));
      
      

	}

}

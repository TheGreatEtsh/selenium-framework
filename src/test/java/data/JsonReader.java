package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	
	public static class User {
        public String firstName;
        public String lastName;
        public String email;
        public String password;

        public User(String firstName, String lastName, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
        }
    }

	public List<User> jsonRead() throws FileNotFoundException, IOException, ParseException {
		String userDataPath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.json";
		File userDataFile = new File(userDataPath);

		JSONParser userDataParser = new JSONParser();
		JSONArray userDataArray = (JSONArray) userDataParser.parse(new FileReader(userDataFile));
		List<User> users = new ArrayList<>();
		for (Object object : userDataArray) {
			JSONObject jsonObject = (JSONObject) object;
			String firstName = (String) jsonObject.get("firstName");
			String lastName = (String) jsonObject.get("lastName");
			String email = (String) jsonObject.get("email");
			String password = (String) jsonObject.get("password");

			users.add(new User(firstName, lastName, email, password));
		}
		return users;
	}
}

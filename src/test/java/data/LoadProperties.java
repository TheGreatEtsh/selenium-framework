package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	private static String userDataPropertiesPath = System
			.getProperty("user.dir") + "\\src\\main\\java\\properties\\UserData.properties";
	public static Properties userData = loadProperty(userDataPropertiesPath);

	private static String saucelabsUserPropertiesPath = System
			.getProperty("user.dir") + "\\src\\main\\java\\properties\\SaucelabsUser.properties";
	public static Properties saucelabsUserData = loadProperty(saucelabsUserPropertiesPath);

	private static Properties loadProperty(String path) {
		Properties property = new Properties();

		try {
			FileInputStream stream = new FileInputStream(path);
			property.load(stream);

		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		}

		return property;

	}
}

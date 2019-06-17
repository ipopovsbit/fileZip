package zipping.co;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtility {
	
      private static Properties properties;
      private static Properties parentProperties;
	
      static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("resources/conf.properties"));
			if (properties.getProperty("parentConf") != null) {
				parentProperties.load(new FileInputStream(properties.getProperty("parentConf")));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getProperty(String propName) {
		if (properties.getProperty(propName) != null)
			return properties.getProperty(propName);
		if (parentProperties != null)
			return parentProperties.getProperty(propName);
		return null;
	}
}

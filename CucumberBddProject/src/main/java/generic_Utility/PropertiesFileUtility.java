package generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {
	public String readDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(Iconstant.PropertyFilePath);
		Properties pos=new Properties();
		pos.load(fis);
		return pos.getProperty(key);
	}

}

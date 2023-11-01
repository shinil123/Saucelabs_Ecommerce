package ecom.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromProperties(String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	
	public String getDataFromPropertieswithPath(String path, String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(path);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
}

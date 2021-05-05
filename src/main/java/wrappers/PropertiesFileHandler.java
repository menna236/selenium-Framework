package wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileHandler {

    static String filePath="Config.properties";
   public static Properties prop=new Properties();

   static {
       FileInputStream fs=null;
       try
       {
           fs=new FileInputStream(filePath);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       try
       {
           prop.load(fs);
       } catch (IOException e) {
           e.printStackTrace();
       }
       finally {
           try {
               fs.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   public static String getvalue(String key)
   {
        try{
           return prop.getProperty(key);
        } catch (Exception e) {
          return  null;
        }

   }
}

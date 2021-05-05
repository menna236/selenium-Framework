package wrappers;



import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileHandler {

    public static String filename="Config.json";
    JSONObject Jsonobj;

   public JsonFileHandler(String file)
    {
        parse(file);
    }

    public void parse(String file)
    {

        String jsonData=readFile(file);
        try {
            Jsonobj=new JSONObject(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readFile(String filepath)
    {
        String result="";
      try{

          BufferedReader bf=new BufferedReader(new FileReader(filepath));
          StringBuilder sb=new StringBuilder();
          String line= bf.readLine();
          while (line!=null)
          {
              sb.append(line);
              line= bf.readLine();
              result=sb.toString();
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }

           return result;
    }

    public String getValue(String attribute)
    {
        return Jsonobj.getString(attribute);
    }
}
